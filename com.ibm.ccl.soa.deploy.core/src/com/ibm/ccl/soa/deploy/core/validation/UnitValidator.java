/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validation;

import java.util.List;

import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.PublishIntent;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.core.Unit}. This doesn't really
 * do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can
 * be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface UnitValidator {
	boolean validate();

	boolean validateCapabilityGroup(FeatureMap value);

	boolean validateCapabilities(List value);

	boolean validateRequirementGroup(FeatureMap value);

	boolean validateRequirements(List value);

	boolean validateUnitLinksGroup(FeatureMap value);

	boolean validateUnitLinks(List value);

	boolean validateConstraintLinks(List value);

	boolean validateRealizationLinks(List value);

	boolean validateBuildVersion(String value);

	boolean validateConceptual(boolean value);

	boolean validateConfigurationUnit(boolean value);

	boolean validateGoalInstallState(InstallState value);

	boolean validateInitInstallState(InstallState value);

	boolean validateOrigin(String value);

	boolean validatePublishIntent(PublishIntent value);
}
