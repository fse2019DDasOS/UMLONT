/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.j2ee.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.bindings.BindingsHelperManager;
import com.ibm.ccl.soa.deploy.j2ee.bindings.IBindingsHelper;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeConstraintUtils;

/**
 * Resolution to add a WAS security subject binding
 */
public class AddWasSecuritySubjectConstraintResolution extends DeployResolution {

	private final J2EESecurityRole _role;
	private final Unit _host;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator that created the resolution
	 * @param description
	 *           a description of the resolution
	 * @param module
	 *           the module on which the constraint should be added
	 * @param host
	 *           the WAS host of the module
	 */
	public AddWasSecuritySubjectConstraintResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description, J2EESecurityRole role, Unit host) {
		super(context, generator, description);
		_role = role;
		_host = host;
	}

	public IStatus resolve(IProgressMonitor monitor) {
		BindingsHelperManager bindingsManager = BindingsHelperManager.getInstance();
		IBindingsHelper[] helpers = bindingsManager.findEnabledBindingsHelpers(_host);
		IBindingsHelper helper = helpers.length == 0 ? bindingsManager.getDefault() : helpers[0];

		WasJ2eeConstraintUtils.addSecuritySubjectConstraint(_role, helper);

		return Status.OK_STATUS;
	}

}
