/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.j2ee.validator.resolution;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Generator for resolution to add a class loader policy constraint.
 */
public class AddWasClassloaderPolicyConstraintResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		// sanity check
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		String description = WasDomainMessages.Resolution_add_ClassloaderPolicyConstraint;

		Unit unit = (Unit) context.getDeployStatus().getDeployObject();
		return new IDeployResolution[] { new AddWasClassloaderPolicyConstraintResolution(context,
				this, description, unit) };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (!(status instanceof WasDeployStatus)) {
			return false;
		}

		if (!IWASProblemType.OPTIONAL_CONSTRAINT_NOT_PRESENT.equals(status.getProblemType())) {
			return false;
		}

		// to add a constraint, the object must be public
		DeployModelObject object = status.getDeployObject();
//		if (object.getTopology() != object.getEditTopology()) {
//			if (!object.getTopology().getConfigurationContract().isPublic(object)) {
//				return false;
//			}
//		}
		if (!object.isPublic()) {
			return false;
		}

		// this resolution works on units only
		EClass constraintType = (EClass) ((WasDeployStatus) status)
				.getAttribute(WasValidationUtil.CONSTRAINT_TYPE);

		if (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(object.getEObject().eClass())
				&& WasPackage.Literals.WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT
						.isSuperTypeOf(constraintType)) {
			return true;
		}

		if (J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(object.getEObject().eClass())
				&& WasPackage.Literals.WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT
						.isSuperTypeOf(constraintType)) {
			return true;
		}

		return false;
	}

}
