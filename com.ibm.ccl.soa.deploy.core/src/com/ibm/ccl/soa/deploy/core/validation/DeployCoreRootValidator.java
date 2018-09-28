/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validation;

import java.util.Map;

import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.Visibility;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot}. This
 * doesn't really do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can
 * be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface DeployCoreRootValidator {
	boolean validate();

	boolean validateMixed(FeatureMap value);

	boolean validateXMLNSPrefixMap(Map value);

	boolean validateXSISchemaLocation(Map value);

	boolean validateAnnotation(Annotation value);

	boolean validateArtifact(Artifact value);

	boolean validateArtifactFile(FileArtifact value);

	boolean validateCapability(Capability value);

	boolean validateCapabilityBundle(BundleCapability value);

	boolean validateCapabilityCommunication(CommunicationCapability value);

	boolean validateComponent(SoftwareComponent value);

	boolean validateUnit(Unit value);

	boolean validateConfigTopology(InstanceConfiguration value);

	boolean validateConstraint(Constraint value);

	boolean validateContractExplicit(ExplicitContract value);

	boolean validateContractTopology(ConfigurationContract value);

	boolean validateDeployModelObject(DeployModelObject value);

	boolean validateImport(Import value);

	boolean validateInstantiation(Instantiation value);

	boolean validateInterface(Interface value);

	boolean validateLinkConstraint(ConstraintLink value);

	boolean validateLinkConstraint(Constraint value);

	boolean validateLinkDependency(DependencyLink value);

	boolean validateLinkDeploy(DeployLink value);

	boolean validateLinkHosting(HostingLink value);

	boolean validateLinkUnit(UnitLink value);

	boolean validateLinkLogical(ConstraintLink value);

	boolean validateLinkMember(MemberLink value);

	boolean validateLinkRealization(RealizationLink value);

	boolean validateProperty(Property value);

	boolean validateReference(Reference value);

	boolean validateRequirement(Requirement value);

	boolean validateReqExpr(RequirementExpression value);

	boolean validateService(Service value);

	boolean validateTopology(Topology value);

	boolean validateUnitConceptualNode(ConceptualNode value);

	boolean validateVisibility(Visibility value);
}