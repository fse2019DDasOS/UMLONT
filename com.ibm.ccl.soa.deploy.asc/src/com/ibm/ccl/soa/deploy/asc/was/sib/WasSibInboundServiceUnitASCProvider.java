/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was.sib;

import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibDestination;
import com.ibm.ccl.soa.deploy.was.WasSibInboundService;
import com.ibm.ccl.soa.deploy.was.WasSibInboundServiceUnit;

/**
 * UnitProvider Contribution: WasSibInboundServiceUnitASCProvider It creates
 * {@link ASCConstants#TASK_SET_INBOUNDSERVICE} asc task for {@link  WasSibInboundServiceUnit}
 * 
 * @see WasSibInboundService
 * @see WasSibInboundServiceUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasSibInboundServiceUnitASCProvider extends WASSibASCProvider {

	public void initTasks_Base() throws ASCException {
		super.ascTaskName = new String[] { ASCConstants.TASK_SET_INBOUNDSERVICE };
		super.ascProps = new Properties[] { this.createProperties_Base() };
	}

	/**
	 * profilehome busname inboundservname inboundservdestname inboundservurl inboundwsdlservname
	 * inboundwsdlservnamespace
	 */
	private Properties createProperties_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);

		super.setASCAgentProp(props);
		super.setAscProperty(props, "busname", ASCUtil.getSiBusNameFromHoster(unit)); //$NON-NLS-1$
		super.setAscProperty(props, "inboundservname", getInboundServiceName()); //$NON-NLS-1$
		super.setAscProperty(props, "inboundservdestname", getInboundServiceDestName()); //$NON-NLS-1$
		super.setAscProperty(props, "inboundservurl", getInboundServiceWSDLUrl()); //$NON-NLS-1$
		super.setAscProperty(props, "inboundwsdlservname", getInboundWsdlServiceName()); //$NON-NLS-1$
		super.setAscProperty(props, "inboundwsdlservnamespace", getInboundWsdlServiceNameSpace()); //$NON-NLS-1$
		// TODO no use now
		super.setAscProperty(props, "uddireference", "uddiReference"); //$NON-NLS-1$ //$NON-NLS-2$

		return props;
	}

	private String getInboundWsdlServiceNameSpace() {
		return ASCUtil.getAttribute(unit, "getWsdlServiceNamespace"); //$NON-NLS-1$
	}

	// TODO no use now
	private String getInboundWsdlServiceName() {
		return "inboundwsdlservname"; //$NON-NLS-1$
	}

	private String getInboundServiceWSDLUrl() {
		return ASCUtil.getAttribute(unit, "getWsdlLocation"); //$NON-NLS-1$
	}

	// _SYSTEM.Exception.Destination.ibm-zy-desktopNode04.server3-testbus
	private String getInboundServiceDestName() {
		Unit wassiboutservUnit = TopologyDiscovererService.INSTANCE.findTarget(unit,
				WasPackage.eINSTANCE.getWasSibOutboundService(), WasPackage.eINSTANCE
						.getWasSibOutboundServiceUnit(), unit.getTopology());
		Unit destUnit = TopologyDiscovererService.INSTANCE.findTarget(wassiboutservUnit,
				WasPackage.eINSTANCE.getWasSibDestination(), WasPackage.eINSTANCE
						.getWasSibDestinationUnit(), unit.getTopology());
		WasSibDestination dest = (WasSibDestination) ValidatorUtils.getCapability(destUnit,
				WasPackage.eINSTANCE.getWasSibDestination());

		return dest.getDestinationName();
	}

	private String getInboundServiceName() {
		return ASCUtil.getAttribute(unit, "getServiceName"); //$NON-NLS-1$
	}
}