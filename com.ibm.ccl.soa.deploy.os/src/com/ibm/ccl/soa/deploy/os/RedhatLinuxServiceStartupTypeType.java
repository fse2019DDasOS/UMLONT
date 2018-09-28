/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Redhat Linux Service Startup Type Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxServiceStartupTypeType()
 * @model extendedMetaData="name='RedhatLinuxServiceStartupTypeType'"
 * @generated
 */
public final class RedhatLinuxServiceStartupTypeType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Automatic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Automatic</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUTOMATIC_LITERAL
	 * @model name="Automatic"
	 * @generated
	 * @ordered
	 */
	public static final int AUTOMATIC = 0;

	/**
	 * The '<em><b>Boot</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Boot</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOT_LITERAL
	 * @model name="Boot"
	 * @generated
	 * @ordered
	 */
	public static final int BOOT = 1;

	/**
	 * The '<em><b>System</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>System</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_LITERAL
	 * @model name="System"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM = 2;

	/**
	 * The '<em><b>Manual</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Manual</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANUAL_LITERAL
	 * @model name="Manual"
	 * @generated
	 * @ordered
	 */
	public static final int MANUAL = 3;

	/**
	 * The '<em><b>Disabled</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Disabled</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISABLED_LITERAL
	 * @model name="Disabled"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLED = 4;

	/**
	 * The '<em><b>Automatic</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #AUTOMATIC
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxServiceStartupTypeType AUTOMATIC_LITERAL = new RedhatLinuxServiceStartupTypeType(
			AUTOMATIC, "Automatic", "Automatic"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Boot</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #BOOT
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxServiceStartupTypeType BOOT_LITERAL = new RedhatLinuxServiceStartupTypeType(
			BOOT, "Boot", "Boot"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>System</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SYSTEM
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxServiceStartupTypeType SYSTEM_LITERAL = new RedhatLinuxServiceStartupTypeType(
			SYSTEM, "System", "System"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Manual</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #MANUAL
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxServiceStartupTypeType MANUAL_LITERAL = new RedhatLinuxServiceStartupTypeType(
			MANUAL, "Manual", "Manual"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Disabled</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #DISABLED
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxServiceStartupTypeType DISABLED_LITERAL = new RedhatLinuxServiceStartupTypeType(
			DISABLED, "Disabled", "Disabled"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Redhat Linux Service Startup Type Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final RedhatLinuxServiceStartupTypeType[] VALUES_ARRAY = new RedhatLinuxServiceStartupTypeType[] {
			AUTOMATIC_LITERAL, BOOT_LITERAL, SYSTEM_LITERAL, MANUAL_LITERAL, DISABLED_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Redhat Linux Service Startup Type Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Redhat Linux Service Startup Type Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxServiceStartupTypeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatLinuxServiceStartupTypeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Linux Service Startup Type Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxServiceStartupTypeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatLinuxServiceStartupTypeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Linux Service Startup Type Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxServiceStartupTypeType get(int value) {
		switch (value)
		{
		case AUTOMATIC:
			return AUTOMATIC_LITERAL;
		case BOOT:
			return BOOT_LITERAL;
		case SYSTEM:
			return SYSTEM_LITERAL;
		case MANUAL:
			return MANUAL_LITERAL;
		case DISABLED:
			return DISABLED_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private RedhatLinuxServiceStartupTypeType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RedhatLinuxServiceStartupTypeType
