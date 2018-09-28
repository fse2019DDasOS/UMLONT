/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class Was5DistributedCellUnitValidator extends WasGenericCellUnitValidator {

	public Was5DistributedCellUnitValidator() {
		super();

		//this covers only the distributed version 5 case!
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasClusterUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 0, 1);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		assert unit instanceof WasCellUnit;
		WasCellUnit wasCellUnit = (WasCellUnit) unit;
		Topology top = unit.getTopology();
		if (top == null) {
			return;
		}

		WasCell wasCellCap = (WasCell) ValidatorUtils.getCapability(unit, WasPackage.eINSTANCE
				.getWasCell());
		if (wasCellCap == null || !wasCellCap.isIsDistributed()) {
			return;
		}

		String wasCellVersion = wasCellCap.getWasVersion();
		if (wasCellVersion == null || wasCellVersion.length() <= 0) {
			return;
		}
		if (!wasCellVersion.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			return;
		}

		// Core Unit validation		
		super.validateUnit(unit, context, reporter);

		List nodeCapL = WasUtil.getWasNodeCapsFromCellUnit(wasCellUnit, top);
		if (nodeCapL == null) {
			return;
		}

		if (nodeCapL.size() < 1) {
			IDeployStatus message = DeployWasMessageFactory
					.createMissingDmgrNodeInDistributedCellStatus(wasCellUnit);
			reporter.addStatus(message);
			return;
		}

		//check for dmgrNode, 1st is dmgrNode, from 2nd and on are other Nodes
		List dmgrCapL = new ArrayList();
		assert nodeCapL.get(0) instanceof WasNode;
		WasNode dmgrNode = (WasNode) nodeCapL.get(0);

		if (!dmgrNode.getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {//add a status for missing dmgr node to cell
			IDeployStatus message = DeployWasMessageFactory
					.createMissingDmgrNodeInDistributedCellStatus(wasCellUnit);
			reporter.addStatus(message);
			//check this nodeCap
			checkWas5CellNonDmgrNodeMembers(dmgrNode, reporter, wasCellUnit);
		} else {
			dmgrCapL.add(dmgrNode);
			//check cellversion equals to dmgrNode.wasVersion
			if (!wasCellVersion.equals(dmgrNode.getWasVersion())) {
				IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidSourceValueStatus(
						IStatus.ERROR, IWasValidatorID.VALIDAT_WAS_CELL_WASVERSION_001, wasCellCap,
						WasPackage.eINSTANCE.getWasCell_WasVersion(), dmgrNode, WasPackage.eINSTANCE
								.getWasNode_WasVersion());
				reporter.addStatus(message);
			}
		}

		Iterator nodeit = nodeCapL.iterator();
		nodeit.next();

		while (nodeit.hasNext()) {
			WasNode wasNodeCap = (WasNode) nodeit.next();
			if (wasNodeCap.getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {
				dmgrCapL.add(wasNodeCap);
			} else {
				checkWas5CellNonDmgrNodeMembers(wasNodeCap, reporter, wasCellUnit);
			}
		}

		if (dmgrCapL.size() > 1) {
			IDeployStatus message = DeployWasMessageFactory
					.createWasListOFInvalidMemberUnitInGroupUnitStatus(
							dmgrCapL,
							wasCellUnit,
							IWasValidatorID.VALIDAT_WAS_DISTRIBUTED_CELL_DMGR_NODE_MEMBER_CARDINALITY_002,
							DeployNLS
									.bind(
											WasDomainMessages.Validator_WAS_DisCellUnit_0_With_Invalid_DmgrNode_Unit_Member_Cardinality,
											wasCellUnit));
			reporter.addStatus(message);
		}
	}

	/**
	 * add validations need to be done in version 5 Cell
	 * 
	 * nodeCap.wasVersion should no more than the cell.wasVersion, this had been checked in each Node
	 * isManaged attribute will be checked in each Node
	 * 
	 * @param nodeCap
	 * @param reporter
	 * @param wasCellUnit
	 */
	private void checkWas5CellNonDmgrNodeMembers(WasNode nodeCap, IDeployReporter reporter,
			WasCellUnit wasCellUnit) {
		//nodeCap.wasVersion should >= 5 and <6, cause WAS 4 do not have Node concept, use : Validator_Was_5_Cell_0_Was_Node_Member_1_wasVersion_2
		String nodeVersion = nodeCap.getWasVersion();
		if (nodeVersion == null) {
			return;
		}
		if (nodeVersion.length() <= 0) {
			return;
		}

		int compareWith5 = WasUtil.compare2VersionString(nodeVersion, WasUtil.WAS_5_MAIN_VERSION);
		int compareWith6 = WasUtil.compare2VersionString(nodeVersion, WasUtil.WAS_6_MAIN_VERSION);
		if (compareWith6 >= 0 || compareWith5 < 0) {
			IDeployStatus status = DeployWasMessageFactory
					.createWasInvalidMemberUnitInGroupUnitStatus(
							(Unit) nodeCap.getParent(),
							wasCellUnit,
							IWasValidatorID.VALIDAT_WAS_5_DISTRIBUTED_CELL_NON_DMGR_NODE_MEMBERS_VERSION,
							DeployNLS
									.bind(
											WasDomainMessages.Validator_Was_Node_0_Invalid_with_Was_Cell_1_NodewasVersion_2,
											new Object[] { nodeCap.getNodeName(), wasCellUnit,
													nodeCap.getWasVersion() }));
			reporter.addStatus(status);
		}
	}
}
