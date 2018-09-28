/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeploySemanticType;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class MoveToNewGroupCommand extends DeployTransactionalCommand {
	private static final int VIEW_OFFSET = 800;

	private final List selectedParts;
	private final DiagramEditPart diagramEP;

	/**
	 * @param selectedParts
	 * @param diagramEP
	 */
	public MoveToNewGroupCommand(List selectedParts, DiagramEditPart diagramEP) {
		super(diagramEP.getEditingDomain(), Messages.CMD_LABEL_MOVE_TO_NEW_GROUP,
				getAllWorkspaceFiles(diagramEP.getNotationView()));

		this.diagramEP = diagramEP;
		this.selectedParts = selectedParts;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		/** Create a new unit group */
		CreateViewAndElementRequest createGroupReq = (CreateViewAndElementRequest) CreateViewRequestFactory
				.getCreateShapeRequest(DeploySemanticType.UNITGROUP, diagramEP
						.getDiagramPreferencesHint());
		Command newGroupCommand = diagramEP.getCommand(createGroupReq);
		newGroupCommand.execute();
		List<View> createdRootViews = (List<View>) createGroupReq.getExtendedData().get(
				DeployCreateElementAndViewCommand.CREATEDROOTVIEWS);
		View newGrpView = createdRootViews.get(0);
		boolean isTree = false;
		View newGrpAreaView = ViewUtil.getChildBySemanticHint(newGrpView,
				DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		if (newGrpAreaView == null) {
			isTree = true;
			newGrpAreaView = ViewUtil.getChildBySemanticHint(newGrpView,
					DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}
		Unit newGrp = (Unit) newGrpView.getElement();

		/** Set the position and size of the new group */
		if (selectedParts.size() > 0) {
			DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) GEFUtils
					.getTopEditPart((EditPart) selectedParts.get(0));
			View view = (View) ep.getModel();
			Integer oldX = (Integer) ViewUtil.getStructuralFeatureValue(view,
					NotationPackage.eINSTANCE.getLocation_X());
			Integer oldY = (Integer) ViewUtil.getStructuralFeatureValue(view,
					NotationPackage.eINSTANCE.getLocation_Y());
			ViewUtil.setStructuralFeatureValue(newGrpView, NotationPackage.eINSTANCE.getLocation_X(),
					oldX);
			ViewUtil.setStructuralFeatureValue(newGrpView, NotationPackage.eINSTANCE.getLocation_Y(),
					oldY);
		}

		ViewUtil.setStructuralFeatureValue(newGrpAreaView, NotationPackage.eINSTANCE
				.getDrawerStyle_Collapsed(), new Boolean(false));
		if (!isTree) {
			ViewUtil.setStructuralFeatureValue(newGrpView, NotationPackage.eINSTANCE.getSize_Width(),
					new Integer(DeployCoreConstants.UNIT_NEW_SHAPES_WIDTH));
			ViewUtil.setStructuralFeatureValue(newGrpView, NotationPackage.eINSTANCE.getSize_Height(),
					new Integer(DeployCoreConstants.UNIT_NEW_SHAPES_HEIGHT));
		}

		/** Move selected edit parts to new group */
		for (int i = 0; i < selectedParts.size(); i++) {
			EditPart srcEP = (EditPart) selectedParts.get(i);
			View srcView = (View) srcEP.getModel();
			View containerView = (View) srcView.eContainer();
			Unit srcUnit = (Unit) srcView.getElement();

			// Delete the old member link
			if (!(containerView instanceof Diagram)) {
				MemberLink memberLink = findMemberLink((Unit) containerView.getElement(), srcUnit);
				if (memberLink != null) {
					EcoreUtil.remove(memberLink);
				}
			}

			// Create the new member link between selected unit and target unit group
			DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
			if (dvs.canCreateLink(newGrp, srcUnit, LinkType.MEMBER_SET).isOK()) {
				LinkDescriptor[] hld = dvs.getPossibleLinks(newGrp, srcUnit, LinkType.MEMBER_SET);
				if (hld.length > 0) {
					hld[0].create();
				}
			}

			// Reposition the view object
			if (!isTree) {
				ViewUtil.setStructuralFeatureValue(srcView, NotationPackage.eINSTANCE.getLocation_X(),
						new Integer(VIEW_OFFSET * (selectedParts.size() - i - 1)));
				ViewUtil.setStructuralFeatureValue(srcView, NotationPackage.eINSTANCE.getLocation_Y(),
						new Integer(VIEW_OFFSET * (selectedParts.size() - i - 1)));
			}

			// Insert selected View into children list of the target group view
			newGrpAreaView.insertChild(srcView);
		}

		return CommandResult.newOKCommandResult();
	}

	private MemberLink findMemberLink(Unit source, Unit target) {
		List memberLinks = source.getMemberLinks();
		for (int i = 0; i < memberLinks.size(); i++) {
			MemberLink memberLink = (MemberLink) memberLinks.get(i);
			if (memberLink.getTarget() == target) {
				return memberLink;
			}
		}

		return null;
	}
}
