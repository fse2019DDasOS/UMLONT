/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.edithelpers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ConfigureBaseCommand;

/**
 * 
 * @since 1.0
 * 
 */
public class CapabilityEditHelper extends ContainerEditHelper {

	protected ICommand getConfigureCommand(final ConfigureRequest req) {
		return new ConfigureBaseCommand(req, CorePackage.eINSTANCE.getCapability()) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
				Capability service = (Capability) req.getElementToConfigure();
				return CommandResult.newOKCommandResult(service);
			}
		};
	}
}
