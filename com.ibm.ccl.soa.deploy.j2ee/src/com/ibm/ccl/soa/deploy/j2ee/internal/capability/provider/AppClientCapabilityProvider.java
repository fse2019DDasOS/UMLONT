/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jst.j2ee.client.ApplicationClient;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;

public class AppClientCapabilityProvider extends J2EEModuleCapabilityProvider {

	/**
	 * Return the array of requirements for a Connector Application
	 */
	public Object[] resolveRequirements(Object anObject, Unit aUnit) {
		if (anObject instanceof ApplicationClient) {
			Map requirements = new HashMap();
			ApplicationClient appClient = (ApplicationClient) anObject;
			int j2eeVersion = appClient.getVersionID();

			String key = KEY_BASE_J2EE + j2eeVersion;
			if (!requirements.containsKey(key)) {
				Requirement j2eeContainerReq = createJ2EEContainerReq(j2eeVersion);
				requirements.put(key, j2eeContainerReq);
			}

			//TODO add java version in ide provider; requires project facet

			return toReqArray(requirements.values());
		}

		return NO_REQS;
	}

	public Object[] resolveCapabilities(Object anObject) {
		return NO_CAPS;
	}

//	protected void addWebResourceRefs( Map reqs, WebApp webApp, List resourceRefs, Unit aUnit ) {
//		for (int j = 0; j < resourceRefs.size(); j++) {
//			ResourceRef ref = (ResourceRef) resourceRefs.get(j);
//			if (!checkForSQLType(ref)) {
//				continue;
//			}
//			String jndiName = bindingsHelper.getJNDINameForRef(webApp, ref);
//			Object key = null == jndiName ? new Object() : jndiName;
//			if (!reqs.containsKey(key)) {
//				reqs.put(key, createDataSourceReq( ref, jndiName ) );
//			}
//		}
//	}

}
