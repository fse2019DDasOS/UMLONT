/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.tds.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.provider.UnitItemProvider;
import com.ibm.ccl.soa.deploy.tds.TdsBaseSystemUnit;
import com.ibm.ccl.soa.deploy.tds.TdsFactory;
import com.ibm.ccl.soa.deploy.tds.TdsPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.tds.TdsBaseSystemUnit} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TdsBaseSystemUnitItemProvider
	extends UnitItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TdsBaseSystemUnitItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns TdsBaseSystemUnit.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TdsBaseSystemUnit")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((TdsBaseSystemUnit)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_TdsBaseSystemUnit_type") : //$NON-NLS-1$
			getString("_UI_TdsBaseSystemUnit_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.UNIT__CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.UNIT__CAPABILITIES,
					 TdsFactory.eINSTANCE.createTdsBaseSystem())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.UNIT__CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(TdsPackage.Literals.TDS_ROOT__CAPABILITY_TDS_BASE_SYSTEM,
					 TdsFactory.eINSTANCE.createTdsBaseSystem())));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature, Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		if (childFeature instanceof EStructuralFeature && FeatureMapUtil.isFeatureMap((EStructuralFeature)childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry)childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify =
			childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE ||
			childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR ||
			childFeature == CorePackage.Literals.UNIT__CAPABILITIES ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__SERVICE ||
			childFeature == CorePackage.Literals.UNIT__REQUIREMENTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REFERENCE ||
			childFeature == CorePackage.Literals.UNIT__UNIT_LINKS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return TdsEditPlugin.INSTANCE;
	}

}
