package com.naveenautomation.Page;

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

}
