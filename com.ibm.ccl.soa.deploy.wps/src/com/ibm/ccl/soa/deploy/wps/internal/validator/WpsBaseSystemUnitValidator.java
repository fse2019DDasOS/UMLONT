/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.wps.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.wps.WpsBaseSystemUnit;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * Validates {@link WpsBaseSystemUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class WpsBaseSystemUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link WpsBaseSystemUnit} instance validator.
	 */
	public WpsBaseSystemUnitValidator() {
		this(WpsPackage.eINSTANCE.getWpsBaseSystemUnit());

	}

	/**
	 * Construct a {@link WpsBaseSystemUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link WpsBaseSystemUnit}.
	 */
	protected WpsBaseSystemUnitValidator(EClass unitType) {
		super(unitType);
		assert WpsPackage.eINSTANCE.getWpsBaseSystemUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
		addCapabilityTypeConstraint(WpsPackage.eINSTANCE.getWpsBaseSystem(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
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
