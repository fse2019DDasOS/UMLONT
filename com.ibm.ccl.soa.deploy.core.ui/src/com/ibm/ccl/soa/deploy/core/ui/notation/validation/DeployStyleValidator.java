/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.notation.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface DeployStyleValidator {
	boolean validate();

	boolean validateExternalHostee(boolean value);
	boolean validateIsDuplicateCanvasView(boolean value);
	boolean validateAttachedViewList(EList<View> value);

	boolean validateFilterDupLinkList(EList<View> value);
	boolean validateDuplicateCanvasViewReference(View value);
	boolean validateDuplicateCanvasViewMaster(View value);

	boolean validateAutoDeleteOnMasterDelete(boolean value);

	boolean validateProxyHashCode(int value);

	boolean validateElementName(String value);

	boolean validateProxyName(String value);

	boolean validateImportView(View value);

	boolean validateElementCategory(String value);

	boolean validateContainState(int value);

	boolean validateImport(EObject value);

	boolean validateSnapParent(View value);

	boolean validateSnapChildren(EList<View> value);

	boolean validateRightAttachedView(View value);

	boolean validateBottomAttachedView(View value);

	boolean validateFilteredSemanticElements(EList<EObject> value);

	boolean validateFilteredDecorations(EList<String> value);

	boolean validateSnapStyle(int value);

	boolean validateCollapseWidth(int value);

	boolean validateCollapseHeight(int value);

	boolean validateExpandWidth(int value);

	boolean validateExpandHeight(int value);

	boolean validateContainedObjs(EList<EObject> value);

	boolean validateUncontainedObjs(EList<EObject> value);

	boolean validateProxyCategory(String value);

	boolean validateImportPath(String value);
}
