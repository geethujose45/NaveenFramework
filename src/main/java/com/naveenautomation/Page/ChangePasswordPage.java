package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class ChangePasswordPage extends BaseTest {
	AccountPage accountPage;
	
	public ChangePasswordPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-password")
	WebElement pwd;

	@FindBy(css = "#input-confirm")
	WebElement confirmPwd;

	@FindBy(css = "input[value='Continue']")
	WebElement updatePasswordContinuebtn;
	
	// Method to enter a password in the password input field
	public void enterPassword(String password) {
		pwd.sendKeys(password);
	}

	 // Method to enter a confirm password in the confirm password input field
	public void enterConfirmPassword(String ConfirmPassword) {
		confirmPwd.sendKeys(ConfirmPassword);
	}

	// Method to click the 'Continue' button for updating the password and navigate to the AccountPage
	public AccountPage clickPasswordUpdateContinueBtn() {
		updatePasswordContinuebtn.click();
		return new AccountPage();
	}

}
