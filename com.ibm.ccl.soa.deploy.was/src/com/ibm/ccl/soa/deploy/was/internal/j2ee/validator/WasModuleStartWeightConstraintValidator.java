/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.j2ee.validator;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class WasModuleStartWeightConstraintValidator extends ConstraintValidator {

	protected boolean isValidPlacement(DeployModelObject dmo) {
		if (!J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(dmo.getEObject().eClass())
				&& !J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(dmo.getEObject().eClass())) {
			return false;
		}

		return WasJ2eeValidatorUtils.isJ2eeHostedOnWas(dmo);
	}

	@Override
	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		return EMPTY_CONSTRAINT_LIST;
	}

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return WasPackage.Literals.WAS_MODULE_START_WEIGHT_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass());
	}

	@Override
	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		return null;
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {

		if (!WasPackage.Literals.WAS_MODULE_START_WEIGHT_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass())) {
			// we don't know how to validate this constraint
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// we know that it is a WasModuleStartWeightConstraint
		WasModuleStartWeightConstraint wasConstraint = (WasModuleStartWeightConstraint) constraint;

		// check that the constraint is on a valid {@link WebModule} or {@link EjbModule} and is hosted on was
		if (!isValidPlacement(context)) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE
					.createDeployStatus(
							IStatus.WARNING,
							IWasValidatorID.WAS_MODULE_START_WEIGHT_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001,
							IWASProblemType.WAS_MODULE_START_WEIGHT_CONSTRAINT_INVALID_CONTEXT,
							WasDomainMessages.WasJ2eeValidator_WasModuleStartWeightConstraint_In_Invalid_Context,
							new Object[] {}, wasConstraint);
			return status;
		}

		// TODO Auto-generated method stub
		return DeployCoreStatusFactory.INSTANCE.getOKStatus();
	}

}
