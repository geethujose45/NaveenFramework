package com.naveenautomation.Page;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class ReigistrationPage extends BaseTest {

	public ReigistrationPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[name='firstname']")
	WebElement inputFirstName;

	@FindBy(css = "input[name='lastname']")
	WebElement inputLastName;

	@FindBy(css = "input[name='email']")
	WebElement inputEmail;

	@FindBy(css = "input[name='telephone']")
	WebElement inputTelePhone;

	@FindBy(css = "input[name='password']")
	WebElement inputPassword;

	@FindBy(css = "input[name='confirm']")
	WebElement inputConfirmPassword;

	@FindBy(css = "input[name='agree']")
	WebElement checkAgreeCheckBox;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//div[text()=' Warning: You must agree to the Privacy Policy!']")
	WebElement privacyPolicyAgreeCheckBoxValidationMessage;

	@FindBy(xpath = "//div[text()='Password confirmation does not match password!']")
	WebElement passwordAndConfirmPasswordMismatchMessage;

	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	WebElement firstNamefieldRequiredAlert;

	@FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	WebElement lastNamefieldRequiredAlert;

	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	WebElement emailfieldRequiredAlert;

	@FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
	WebElement telephoneNumberRequiredFieldAlert;

	@FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
	WebElement passwordRequieldFieldAlert;

	@FindBy(css = "div[id='account-register']>div")
	WebElement userAldreadyRegisteredAlert;

	@FindBy(xpath = "//h4[text()='Privacy Policy']")
	WebElement privacyPolicyPopUpHeadingText;

	@FindBy(css = "button[class='close']")
	WebElement closeBtnOfPrivacyPolicyPopUp;

	@FindBy(xpath = "//b[text()='Privacy Policy']")
	WebElement privacyPolicyLink;

	@FindBy(xpath = "//h1[text()='Register Account']")
	WebElement registerAccountTitleText;

	public void enterFirstName(String firstName) {
		inputFirstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		inputLastName.sendKeys(lastName);
	}

	public void enteremail(String email) {
		inputEmail.sendKeys(email);
	}

	public void enterTelePhone(String telephoneNumber) {
		inputTelePhone.sendKeys(telephoneNumber);
	}

	public void enterPassword(String pwd) {
		inputPassword.sendKeys(pwd);
	}

	public void enterConfirmPassword(String confirmPwd) {
		inputConfirmPassword.sendKeys(confirmPwd);
	}

	public RegistratonSucessMessagePage clickContinueBtn() {
		continueBtn.click();
		return new RegistratonSucessMessagePage();
	}

	public void clickAgreeCheckBox() {
		checkAgreeCheckBox.click();
	}

	public String getprivacyPolicyAgreeCheckBoxValidationMessage() {
		return privacyPolicyAgreeCheckBoxValidationMessage.getText();
	}

	public String getPasswordAndConfirmPasswordMismatchMessage() {
		return passwordAndConfirmPasswordMismatchMessage.getText();
	}

	public String getFirstNamefieldRequiredAlert() {
		return firstNamefieldRequiredAlert.getText();
	}

	public String getLastNamefieldRequiredAlert() {
		return lastNamefieldRequiredAlert.getText();
	}

	public String getemailfieldRequiredAlert() {
		return emailfieldRequiredAlert.getText();
	}

	public String gettelephoneNumberRequiredFieldAlert() {
		return telephoneNumberRequiredFieldAlert.getText();
	}

	public String getpasswordRequieldFieldAlert() {
		return passwordRequieldFieldAlert.getText();
	}

	public String getUserAldreadyRegisteredAlert() {
		return userAldreadyRegisteredAlert.getText();
	}

	public String getPrivacyPolicyPopUpHeadingText() {
		return privacyPolicyPopUpHeadingText.getText();
	}

	public void clickCloseBtnOfPrivacyPolicyPopUp() {
		closeBtnOfPrivacyPolicyPopUp.click();
	}

	public void clickPrivacyPolicyLink() {

		String mainWindowHandle = wd.getWindowHandle();
		privacyPolicyLink.click();
		Set<String> windowHandles = wd.getWindowHandles();

		// Switch to the new window
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(mainWindowHandle)) {
				wd.switchTo().window(windowHandle);
				break;
			}
		}
		wd.switchTo().window(mainWindowHandle);
	}

	public String getRegisterAccountTitleText() {
		return registerAccountTitleText.getText();
	}
}
