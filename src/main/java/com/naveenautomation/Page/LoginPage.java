package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

import io.qameta.allure.Step;

public class LoginPage extends BaseTest {

	public LoginPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(id = "input-password")
	WebElement pwdInput;

	@FindBy(css = "input[value='Login']")
	WebElement clickBtn;

	@FindBy(css = ".alert-danger")
	WebElement loginFailedAlert;

	@FindBy(xpath = "//div[text()=' Warning: No match for E-Mail Address and/or Password.']")
	WebElement credentialWarningMessage;

	@FindBy(css = "div[id='content']>div>div:nth-of-type(2)>div>form>div:nth-of-type(2)>a")
	WebElement forgottenPwdLink;

	@FindBy(css = "div[id='top-links']>ul>li:nth-of-type(2)>a")
	WebElement myAccountTopNavigation;

	@FindBy(css = "div[id='account-login']>div>aside>div>a:nth-of-type(2)")
	WebElement clickRegister;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement continueRegister;
	

	// Method to enter an email in the email input field
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	// Method to enter a password in the password input field
	public void enterpwd(String password) {
		pwdInput.sendKeys(password);
	}

	// Method to submit the login form with provided email and password and navigate
	// to the AccountPage
	@Step("Login with email{0} and password{1}")
	public AccountPage submitLogin(String email, String password) {
		enterEmail(email);
		enterpwd(password);
		clickBtn.click();
		return new AccountPage();
	}

	// Method to get the text of the login failed alert message
	public String loginFailedAlertMessage() {
		return loginFailedAlert.getText();
	}

	// Method to click the 'Forgotten Password' link and navigate to the
	// ForgotPasswordPage
	public ForgotPasswordPage clickForgottenPwdLink() {
		forgottenPwdLink.click();
		return new ForgotPasswordPage();
	}

	public String getcredentialWarningMessage() {
		return credentialWarningMessage.getText();
	}

	public ContactUsPage clickContactUsLink() {
		clickOnNavigationLink(navigationLinks.CONTACT_US);
		return new ContactUsPage();

	}

	public ReigistrationPage clickRegister() {
		myAccountTopNavigation.click();
		dropDownSelection(clickRegister, "Register");
		return new ReigistrationPage();
	}
	
	public ReigistrationPage clickContinueRegisterBtn() {
		continueRegister.click();
		return new ReigistrationPage();
	}
	
}
