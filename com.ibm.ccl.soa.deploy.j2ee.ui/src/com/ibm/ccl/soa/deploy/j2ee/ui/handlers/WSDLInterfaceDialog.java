/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.j2ee.ui.handlers;

import java.util.List;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.j2ee.ui.Messages;

public class WSDLInterfaceDialog extends TrayDialog {

	private String displayName;
	private String description;
	private Text txtDisplayName;
	private Text txtDescription;
	private Combo theCombo;
	private Button buttonOpen;
	private String typeUri;
	private final String defaultTypeUri;
	private boolean isOpenWSDL = false;
	private DeployModelObject nubDmo = null;
	private boolean isService = false;

	protected WSDLInterfaceDialog(Shell parentShell, String defaultTypeUri, DeployModelObject nubDmo) {
		super(parentShell);
		this.defaultTypeUri = defaultTypeUri;
		this.nubDmo = nubDmo;
		isService = nubDmo != null && nubDmo instanceof Service;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(isService ? Messages.WSDLService_Title : Messages.WSDLInterface_Title);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		if (isService) {
			addDmoSection(composite);
		}
		addTypeUriSection(composite);

		initializeControls();

		applyDialogFont(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_EDIT_WSDL_INTERFACE);

		return composite;
	}

	private void addDmoSection(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);

		Group group = new Group(composite, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		group.setLayout(new GridLayout());
		group.setText(Messages.Service);

		Label promptName = new Label(group, SWT.NONE);
		promptName.setText(Messages.DisplayName);
		txtDisplayName = new Text(group, SWT.BORDER);
		txtDisplayName.setLayoutData(gd);

		Label promptDesc = new Label(group, SWT.NONE);
		promptDesc.setText(Messages.Description);
		txtDescription = new Text(group, SWT.BORDER);
		txtDescription.setLayoutData(gd);
	}

	private void addTypeUriSection(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		Group group = new Group(composite, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		group.setLayout(new GridLayout());
		group.setText(Messages.Interface);

		Label typeUriLabel = new Label(group, SWT.NONE);
		typeUriLabel.setText(Messages.TypeUri_Label);

		theCombo = new Combo(group, SWT.SIMPLE | SWT.V_SCROLL | SWT.BORDER);
		GridData gdCombo = new GridData(GridData.FILL_BOTH);
		gdCombo.horizontalSpan = 1;
		gdCombo.widthHint = 300;
		gdCombo.heightHint = 10 * theCombo.getItemHeight();
		theCombo.setLayoutData(gdCombo);
		theCombo.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				String name = theCombo.getItem(theCombo.getSelectionIndex());
				theCombo.setText(name + "#[port type | interface]"); //$NON-NLS-1$
			}
		});

		addButtons(group);
	}

	private void addButtons(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout = new GridLayout(3, false);
		composite.setLayout(layout);

		Label spacer = new Label(composite, SWT.NULL);
		spacer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		buttonOpen = new Button(composite, SWT.PUSH | SWT.CENTER);
		buttonOpen.setText(Messages.OpenWSDL_Label);
		setButtonLayoutData(buttonOpen);
		buttonOpen.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				openWSDL();
			}
		});

	}

	protected void openWSDL() {
		isOpenWSDL = true;
		okPressed();
	}

	private void initializeControls() {
		if (isService) {
			txtDisplayName.setText(nubDmo.getDisplayName() != null ? nubDmo.getDisplayName() : ""); //$NON-NLS-1$
			txtDescription.setText(nubDmo.getDescription() != null ? nubDmo.getDescription() : ""); //$NON-NLS-1$
		}
		List values = ResourceUtils.findFilesWithExtension("wsdl"); //$NON-NLS-1$
		theCombo.setItems((String[]) values.toArray(new String[0]));
		if (defaultTypeUri == null || defaultTypeUri.length() == 0) {
			theCombo.setText("[wsdl location]#[port type | interface]"); //$NON-NLS-1$
		} else {
			theCombo.setText(defaultTypeUri);
		}
	}

	public String getTypeUri() {
		return typeUri;
	}

	protected void okPressed() {
		if (isService) {
			displayName = txtDisplayName.getText().trim();
			description = txtDescription.getText().trim();
		}
		typeUri = theCombo.getText().trim();
		super.okPressed();
	}

	public boolean isOpenWSDL() {
		return isOpenWSDL;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getDescription() {
		return description;
	}

	public boolean isService() {
		return isService;
	}

}