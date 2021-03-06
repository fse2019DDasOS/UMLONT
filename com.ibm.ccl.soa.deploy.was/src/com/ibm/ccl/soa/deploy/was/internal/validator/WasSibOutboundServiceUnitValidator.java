/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.ConfigurationUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundService;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * @author <a href="mailto:tianchen@cn.ibm.com">Tian Chen</a>
 */

public class WasSibOutboundServiceUnitValidator extends ConfigurationUnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWasSibOutboundServiceUnit();
	}

	public WasSibOutboundServiceUnitValidator() {
		super(WasPackage.eINSTANCE.getWasSibOutboundServiceUnit());

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSibOutboundService(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasSIBus(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasSibDestination(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.VALIDAT_WAS_SIB_OUTBOUNDSERVICE_WSDLLOCATION_002,
				WasPackage.Literals.WAS_SIB_OUTBOUND_SERVICE__WSDL_LOCATION, IStatus.ERROR));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);
		//wsdlLocation should be string end of '.wsdl'
		WasSibOutboundService outboundServiceCap = (WasSibOutboundService) ValidatorUtils
				.getCapability(unit, WasPackage.Literals.WAS_SIB_OUTBOUND_SERVICE);
		if ((outboundServiceCap != null) && (outboundServiceCap.getWsdlLocation() != null)) {
			if (!outboundServiceCap.getWsdlLocation().endsWith("wsdl")) { //$NON-NLS-1$
				String problemType = ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED;
				String unboundMessage = DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_invalid;
				Object[] bindings = new Object[] { outboundServiceCap,
						WasPackage.Literals.WAS_SIB_OUTBOUND_SERVICE__WSDL_LOCATION.getName() };
				IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE
						.createAttributeValueStatus(IStatus.ERROR,
								IWasValidatorID.VALIDAT_WAS_SIB_OUTBOUNDSERVICE_WSDLLOCATION_001,
								problemType, unboundMessage, bindings, outboundServiceCap,
								WasPackage.Literals.WAS_SIB_OUTBOUND_SERVICE__WSDL_LOCATION, "*.wsdl"); //$NON-NLS-1$
				reporter.addStatus(status);
			}
		}

	}

}
