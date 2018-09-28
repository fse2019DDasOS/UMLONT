package com.ibm.ccl.soa.deploy.analysis.test;

/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.analysis.IAnalysisTemplateConstants;
import com.ibm.ccl.soa.deploy.analysis.LocationUnit;
import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;

/**
 * Tests that exercise the contents of the UML domain definition.
 * @since 1.0
 */
public class AnalysisDomainUMLIntegrationTest extends TestCase {

	private static final String PROJECT_NAME = "AnalysisDomainUMLIntegrationTest";
	
	private static final String UML_COMP_RESOURCE_ID = "uml.umlComponent";
	private static final String ANALYSIS_NODE_RESOURCE_ID = IAnalysisTemplateConstants.NODE_UNIT;
	private static final String ANALYSIS_LOCATION_RESOURCE_ID = IAnalysisTemplateConstants.LOCATION_UNIT;
	

	private IProject project;

	protected void setUp() throws Exception {
		super.setUp();
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
	}
	protected void tearDown() throws Exception{
		super.tearDown();
		project.delete(true,new NullProgressMonitor());
	}
	/**
	 * @throws IOException
	 */
	public void testUMLComponentHosting() throws IOException {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/analysisUMLIntegration.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Analysis Topology");

		root.setTopology(top);
		
		// create Component
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		DeployModelObject dmo = rts.createFromTemplate(UML_COMP_RESOURCE_ID);
		assert dmo instanceof SoftwareComponent;
		SoftwareComponent umlComp = (SoftwareComponent)dmo;
		top.getUnits().add(umlComp);

		// Create  Location 
		dmo = rts.createFromTemplate( ANALYSIS_LOCATION_RESOURCE_ID );
		assert dmo instanceof LocationUnit;
		LocationUnit location = (LocationUnit)dmo;
		top.getUnits().add( location );
		
		// Create  node 
		dmo = rts.createFromTemplate( ANALYSIS_NODE_RESOURCE_ID );
		assert dmo instanceof NodeUnit;
		NodeUnit node = (NodeUnit)dmo;
		top.getUnits().add( node );
	
		
		// Host deployment unit on  node
		ValidatorTestUtils.hosts(node, umlComp);
		
		//add node as member to location
		ValidatorTestUtils.member(location, node);		
		
		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);
		assert topology.getUnits().size() > 0;

		res.unload();
		


	}


}
