/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.foo.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.foo.FooBaseSystem;
import com.ibm.ccl.soa.deploy.foo.FooPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.foo.impl.FooBaseSystemImpl#getInstallLocation <em>Install Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.foo.impl.FooBaseSystemImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.foo.impl.FooBaseSystemImpl#getWonderful <em>Wonderful</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FooBaseSystemImpl extends CapabilityImpl implements FooBaseSystem {
	/**
	 * The default value of the '{@link #getInstallLocation() <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALL_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallLocation() <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallLocation()
	 * @generated
	 * @ordered
	 */
	protected String installLocation = INSTALL_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getWonderful() <em>Wonderful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWonderful()
	 * @generated
	 * @ordered
	 */
	protected static final String WONDERFUL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWonderful() <em>Wonderful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWonderful()
	 * @generated
	 * @ordered
	 */
	protected String wonderful = WONDERFUL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FooBaseSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return FooPackage.Literals.FOO_BASE_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallLocation() {
		return installLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallLocation(String newInstallLocation) {
		String oldInstallLocation = installLocation;
		installLocation = newInstallLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FooPackage.FOO_BASE_SYSTEM__INSTALL_LOCATION, oldInstallLocation, installLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FooPackage.FOO_BASE_SYSTEM__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWonderful() {
		return wonderful;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWonderful(String newWonderful) {
		String oldWonderful = wonderful;
		wonderful = newWonderful;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FooPackage.FOO_BASE_SYSTEM__WONDERFUL, oldWonderful, wonderful));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FooPackage.FOO_BASE_SYSTEM__INSTALL_LOCATION:
				return getInstallLocation();
			case FooPackage.FOO_BASE_SYSTEM__VERSION:
				return getVersion();
			case FooPackage.FOO_BASE_SYSTEM__WONDERFUL:
				return getWonderful();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FooPackage.FOO_BASE_SYSTEM__INSTALL_LOCATION:
				setInstallLocation((String)newValue);
				return;
			case FooPackage.FOO_BASE_SYSTEM__VERSION:
				setVersion((String)newValue);
				return;
			case FooPackage.FOO_BASE_SYSTEM__WONDERFUL:
				setWonderful((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case FooPackage.FOO_BASE_SYSTEM__INSTALL_LOCATION:
				setInstallLocation(INSTALL_LOCATION_EDEFAULT);
				return;
			case FooPackage.FOO_BASE_SYSTEM__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case FooPackage.FOO_BASE_SYSTEM__WONDERFUL:
				setWonderful(WONDERFUL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FooPackage.FOO_BASE_SYSTEM__INSTALL_LOCATION:
				return INSTALL_LOCATION_EDEFAULT == null ? installLocation != null : !INSTALL_LOCATION_EDEFAULT.equals(installLocation);
			case FooPackage.FOO_BASE_SYSTEM__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case FooPackage.FOO_BASE_SYSTEM__WONDERFUL:
				return WONDERFUL_EDEFAULT == null ? wonderful != null : !WONDERFUL_EDEFAULT.equals(wonderful);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (installLocation: ");
		result.append(installLocation);
		result.append(", version: ");
		result.append(version);
		result.append(", wonderful: ");
		result.append(wonderful);
		result.append(')');
		return result.toString();
	}

} //FooBaseSystemImpl
