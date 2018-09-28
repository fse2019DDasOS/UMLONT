package com.ibm.ccl.soa.deploy.ide.ui.refactoring.wizards;

import org.eclipse.core.runtime.Assert;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * A TextInputWizardPage is a simple UserInputWizardPage with facilities to create a text input
 * field and validate its contents. The text is assumed to be a java identifier, hence CamelCase
 * word jumping is installed.
 */
public abstract class TextInputWizardPage extends UserInputWizardPage {

	private final String initialValue;
	private Text textField;

	public static final String PAGE_NAME = "TextInputPage";//$NON-NLS-1$

	/**
	 * Creates a new text input page.
	 * 
	 * @param isLastUserPage
	 *           <code>true</code> if this page is the wizard's last user input page. Otherwise
	 *           <code>false</code>.
	 */
	public TextInputWizardPage(String description, boolean isLastUserPage) {
		this(description, isLastUserPage, ""); //$NON-NLS-1$
	}

	/**
	 * Creates a new text input page.
	 * 
	 * @param isLastUserPage
	 *           <code>true</code> if this page is the wizard's last user input page. Otherwise
	 *           <code>false</code>
	 * @param initialValue
	 *           the initial value
	 */
	public TextInputWizardPage(String description, boolean isLastUserPage, String initialValue) {
		super(PAGE_NAME);
		Assert.isNotNull(initialValue);
		setDescription(description);
		this.initialValue = initialValue;
	}

	/**
	 * Returns whether the initial input is valid. Typically it is not, because the user is required
	 * to provide some information e.g. a new type name etc.
	 * 
	 * @return <code>true</code> iff the input provided at initialization is valid
	 */
	protected boolean isInitialInputValid() {
		return false;
	}

	/**
	 * Returns whether an empty string is a valid input. Typically it is not, because the user is
	 * required to provide some information e.g. a new type name etc.
	 * 
	 * @return <code>true</code> iff an empty string is valid
	 */
	protected boolean isEmptyInputValid() {
		return false;
	}

	/**
	 * Returns the content of the text input field.
	 * 
	 * @return the content of the text input field. Returns <code>null</code> if not text input
	 *         field has been created
	 */
	protected String getText() {
		if (textField == null) {
			return null;
		}
		return textField.getText();
	}

	/**
	 * Sets the new text for the text field. Does nothing if the text field has not been created.
	 * 
	 * @param text
	 *           the new value
	 */
	protected void setText(String text) {
		if (textField == null) {
			return;
		}
		textField.setText(text);
	}

	/**
	 * Returns the text entry field
	 * 
	 * @return the text entry field
	 */
	protected Text getTextField() {
		return textField;
	}

	/**
	 * Returns the initial value.
	 * 
	 * @return the initial value
	 */
	public String getInitialValue() {
		return initialValue;
	}

	/**
	 * Performs input validation. Returns a <code>RefactoringStatus</code> which describes the
	 * result of input validation. <code>Null<code> is interpreted
	 * as no error.
	 */
	protected RefactoringStatus validateTextField(String text) {
		return null;
	}

	protected Text createTextInputField(Composite parent) {
		return createTextInputField(parent, SWT.BORDER);
	}

	protected Text createTextInputField(Composite parent, int style) {
		textField = new Text(parent, style);
		textField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				textModified(getText());
			}
		});
		textField.setText(initialValue);
		return textField;
	}

	/**
	 * Checks the page's state and issues a corresponding error message. The page validation is
	 * computed by calling <code>validatePage</code>.
	 */
	protected void textModified(String text) {
		if (!isEmptyInputValid() && "".equals(text)) { //$NON-NLS-1$
			setPageComplete(false);
			setErrorMessage(null);
			restoreMessage();
			return;
		}
		if (!isInitialInputValid() && initialValue.equals(text)) {
			setPageComplete(false);
			setErrorMessage(null);
			restoreMessage();
			return;
		}

		RefactoringStatus status = validateTextField(text);
		if (status == null) {
			status = new RefactoringStatus();
		}
		setPageComplete(status);
	}

	/**
	 * Subclasses can override if they want to restore the message differently. This implementation
	 * calls <code>setMessage(null)</code>, which clears the message thus exposing the
	 * description.
	 */
	protected void restoreMessage() {
		setMessage(null);
	}

	/*
	 * (non-Javadoc) Method declared in IDialogPage
	 */
	public void dispose() {
		textField = null;
	}

	/*
	 * (non-Javadoc) Method declared in WizardPage
	 */
	public void setVisible(boolean visible) {
		if (visible) {
			textModified(getText());
		}
		super.setVisible(visible);
		if (visible && textField != null) {
			textField.setFocus();
		}
	}
}
