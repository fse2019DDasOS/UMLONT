/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.mq.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.mq.MQMessageListnerServicePortUnit;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * Validates {@link MQMessageListnerServicePortUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class MQMessageListnerServicePortUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link MQMessageListnerServicePortUnit} instance validator.
	 */
	public MQMessageListnerServicePortUnitValidator() {
		this(MqPackage.eINSTANCE.getMQMessageListnerServicePortUnit());

	}

	/**
	 * Construct a {@link MQMessageListnerServicePortUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link MQMessageListnerServicePortUnit}.
	 */
	protected MQMessageListnerServicePortUnitValidator(EClass unitType) {
		super(unitType);
		assert MqPackage.eINSTANCE.getMQMessageListnerServicePortUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
		//addCapabilityTypeConstraint(MqPackage.eINSTANCE.getMQMessageListnerServicePort(),
				//CapabilityLinkTypes.ANY_LITERAL, 1, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validate(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);
	}
}
