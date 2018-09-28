/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms.validation;

import java.util.Map;

import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecificationUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSProviderUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestinationUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestinationUnit;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot}. This
 * doesn't really do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can
 * be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface JMSDeployRootValidator {
	boolean validate();

	boolean validateMixed(FeatureMap value);

	boolean validateXMLNSPrefixMap(Map value);

	boolean validateXSISchemaLocation(Map value);

	boolean validateCapabilityJMSActivationSpecification(JMSActivationSpecification value);

	boolean validateCapabilityJMSConnectionFactory(JMSConnectionFactory value);

	boolean validateCapabilityJMSDestination(JMSDestination value);

	boolean validateCapabilityJMSProvider(JMSProvider value);

	boolean validateCapabilityJMSQueueConnectionFactory(JMSQueueConnectionFactory value);

	boolean validateCapabilityJMSQueueDestination(JMSQueueDestination value);

	boolean validateCapabilityJMSTopicConnectionFactory(JMSTopicConnectionFactory value);

	boolean validateCapabilityJMSTopicDestination(JMSTopicDestination value);

	boolean validateUnitJMSActivationSpecificationUnit(JMSActivationSpecificationUnit value);

	boolean validateUnitJMSConnectionFactoryUnit(JMSConnectionFactoryUnit value);

	boolean validateUnitJMSProviderUnit(JMSProviderUnit value);

	boolean validateUnitJMSQueueConnectionFactoryUnit(JMSQueueConnectionFactoryUnit value);

	boolean validateUnitJMSQueueDestinationUnit(JMSQueueDestinationUnit value);

	boolean validateUnitJMSTopicConnectionFactoryUnit(JMSTopicConnectionFactoryUnit value);

	boolean validateUnitJMSTopicDestinationUnit(JMSTopicDestinationUnit value);
}
