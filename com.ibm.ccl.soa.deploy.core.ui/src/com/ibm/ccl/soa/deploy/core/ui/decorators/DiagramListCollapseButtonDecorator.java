/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.decorators;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.providers.DeployDecoratorProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * @see DeployDecoratorProvider
 */
public class DiagramListCollapseButtonDecorator extends DeployListCollapseButtonDecorator {

	/**
	 * @param decoratorTarget
	 */
	public DiagramListCollapseButtonDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	protected void refreshStatus(View view, EObject object) {
		EObject element = view.getElement();
		if (!(element instanceof Diagram)) {
			hideFigure();
			return;
		}
		DrawerStyle style = (DrawerStyle) view.getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
		boolean isCollapsed = style != null ? style.isCollapsed() : true;

		// if list is expanded, we always add a button, unless this is an inner list
		if (isCollapsed || isInnerList) {
			// if nothing in inner list, no button
			if (element instanceof Diagram && !hasDiagramItems((Diagram) element)) {
				hideFigure();
				return;
			}
		}
		addCollapsedDecoration(isCollapsed);
	}

	protected boolean hasDiagramItems(Diagram diagram) {
		return diagram.getChildren().size() > 0;
	}

	protected View getCompartmentView() {
		// look for the list compartment
		View view = (View) getDecoratorTarget().getAdapter(View.class);
		Iterator it = view.getPersistedChildren().iterator();
		while (it.hasNext()) {
			View child = (View) it.next();
			if (child.getType().equals(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT)) {
				return child;
			}
		}
		return null;
	}
}
