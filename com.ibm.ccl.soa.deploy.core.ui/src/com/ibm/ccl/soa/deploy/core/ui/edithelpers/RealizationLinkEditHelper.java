/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
/*
 * Created on May 2, 2005
 * 
 * TODO To change the template for this generated file go to Window - Preferences - Java - Code
 * Style - Code Templates
 */
package com.ibm.ccl.soa.deploy.core.ui.edithelpers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ConfigureBaseCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ReorientRealizationLinkCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.EObjectContainmentUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * 
 * 
 * @author Ed Snible (based on jswanke original)
 */
public class RealizationLinkEditHelper extends DeployCoreBaseEditHelper {

	protected ICommand getEditContextCommand(final GetEditContextRequest req) {

		IEditCommandRequest editRequest = req.getEditCommandRequest();
		if (editRequest instanceof CreateRelationshipRequest) {
			final CreateRelationshipRequest createRelationshipRequest = (CreateRelationshipRequest) editRequest;

			// see if this unit can be realized
			EObject o = createRelationshipRequest.getSource();
			if (o instanceof Unit) {
				Unit unit = (Unit) o;
				DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
				if (!dvs.canBeLinkSource(unit, new LinkType[] { LinkType.REALIZATION }).isOK()) {
					return null;
				}
			}

			EObject container = EObjectContainmentUtil.findContainerOfAnySubtype(
					createRelationshipRequest.getSource(), CorePackage.eINSTANCE.getUnit());
			Unit unit = (Unit) container;
			if (unit == null) {
				return null;
			}
			Topology top = unit.getTopology();
			GetEditContextCommand result = new GetEditContextCommand(req);
			result.setEditContext(top);
			return result;
		}
		return null;
	}

	/**
	 * Gets a command to change the source or target of a wire.
	 */
	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		return new ReorientRealizationLinkCommand(req);
	}

	/*
	 * configure service link (does nothing right now)
	 */
	protected ICommand getConfigureCommand(final ConfigureRequest req) {
		return new ConfigureBaseCommand(req, CorePackage.eINSTANCE.getDependencyLink()) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
				DependencyLink link = (DependencyLink) req.getElementToConfigure();
				return CommandResult.newOKCommandResult(link);
			}

		};
	}

}
