/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.MultiplicityChecker;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.MultiplicityConstraint;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator to validate 'GroupCardinalityConstraint' constrait type.
 */
public class GroupCardinalityConstraintValidator extends ConstraintValidator {

	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		GroupCardinalityConstraint theConstraint = (GroupCardinalityConstraint) constraint;
		Requirement req = (Requirement) theConstraint.getParent();

		if (context == null) {
			return ConstraintUtil.createNullContextStatus(theConstraint);
		}
		Unit target;
		if (context instanceof Unit) {
			target = (Unit) context;
		} else {
			return ConstraintUtil.createInvalidContextStatus(theConstraint, context);
		}

		// we can not report errors from MultiplicityChecker
		// check that 'minValue' and 'maxValue' are well formed
		String minValue = theConstraint.getMinValue();
		int min = 0;
		boolean fail = false;
		if (minValue != null && !minValue.trim().equals("")) { //$NON-NLS-1$
			try {
				min = Integer.parseInt(minValue);
				if (min < 0) {
					fail = true;
				}
			} catch (NumberFormatException e) {
				fail = true;
			}
		}
		if (fail) {
			// report malformed attribute 'minValue'
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
					.eClass().getName(), ICoreProblemType.CONSTRAINT_MALFORMED,
					DeployCoreMessages.Validator_cardinality_interpreter_invalid_range_0_to_1,
					new Object[] { theConstraint.getMinValue(), theConstraint.getMaxValue() },
					constraint);
		}

		String maxValue = theConstraint.getMaxValue();
		int max = Integer.MAX_VALUE;
		fail = false;
		if (maxValue != null && !maxValue.trim().equals("") //$NON-NLS-1$
				&& !maxValue.trim().equals(MemberCardinalityConstraintValidator.UNBOUNDED_LITERAL)) {
			try {
				max = Integer.parseInt(maxValue);
				if (max < 0) {
					fail = true;
				}
			} catch (NumberFormatException e) {
				fail = true;
			}
		}
		if (fail) {
			// report malformed attribute 'maxValue'
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
					.eClass().getName(), ICoreProblemType.CONSTRAINT_MALFORMED,
					DeployCoreMessages.Validator_cardinality_interpreter_invalid_range_0_to_1,
					new Object[] { theConstraint.getMinValue(), theConstraint.getMaxValue() },
					constraint);
		}
		if (min > max) {
			// report malformed range
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
					.eClass().getName(), ICoreProblemType.CONSTRAINT_MALFORMED,
					DeployCoreMessages.Validator_cardinality_interpreter_invalid_range_0_to_1,
					new Object[] { theConstraint.getMinValue(), theConstraint.getMaxValue() },
					constraint);
		}

		EClass ecSource = MultiplicityChecker.getRequirementTypeFilter(req);
		MultiplicityConstraint multiplicityConstraint = MultiplicityChecker.getConstraint(ecSource,
				target);

		// If the target doesn't specify cardinality, it implicity accepts being target of anyone
		if (multiplicityConstraint == null) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		int inMultiplicity = MultiplicityChecker.calculateTargetMultiplicity(target, ecSource,
				monitor);
		if (multiplicityConstraint.validTargetMultiplicity(inMultiplicity)) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// Oh no, multiplicity failed!
		int severity;
		if (target.isConceptual()) {
			severity = IStatus.INFO;
		} else if (target.getInitInstallState() == InstallState.INSTALLED_LITERAL) {
			severity = IStatus.WARNING;
		} else {
			severity = IStatus.ERROR;
		}
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
				IDeployCoreValidators.CARDINALITY_IN_001,
				ICoreProblemType.GROUP_IN_CARDINALITY_INVALID,
				DeployCoreMessages.Validator_unit_0_must_be_member_of_group_1_with_cardinality_2,
				new Object[] { target, req.getDmoEType(), getConstraintRepresentation(theConstraint) },
				theConstraint);
		return status;
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// don't allow child constraints
		return EMPTY_CONSTRAINT_LIST;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof GroupCardinalityConstraint) {
			return true;
		}
		return false;
	}

	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		// don't allow child constraints
		return null;
	}

	public String title(Constraint constraint) {
		GroupCardinalityConstraint gcc = (GroupCardinalityConstraint) constraint;
		StringBuffer sb = new StringBuffer();
		sb.append("GroupCardinality ("); //$NON-NLS-1$
		sb.append(getConstraintRepresentation(gcc));
		sb.append(')');
		return sb.toString();
	}

	private String getConstraintRepresentation(GroupCardinalityConstraint constraint) {
		StringBuffer sb = new StringBuffer();
		String str = constraint.getMinValue();
		sb.append(str == null || str.trim().equals("") ? 0 : str.trim()); //$NON-NLS-1$
		sb.append(".."); //$NON-NLS-1$
		str = constraint.getMaxValue();
		sb.append((str == null
				|| str.trim().equals(MemberCardinalityConstraintValidator.UNBOUNDED_LITERAL)
				|| str.trim().equals("") ? "*" : str.trim())); //$NON-NLS-1$ //$NON-NLS-2$
		return sb.toString();
	}
}
