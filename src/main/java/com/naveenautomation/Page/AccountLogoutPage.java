package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class AccountLogoutPage extends BaseTest {
	public AccountLogoutPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//p[text()='You have been logged off your account. It is now safe to leave the computer.']")
	WebElement logoutConfirmationMessage;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement submitContinueBtn;

	// Method to get the text of the logout confirmation message
	public String getlogoutConfirmationMessage() {
		return logoutConfirmationMessage.getText();
	}
	

	// Method to click the 'Continue' button and navigate to the HomePage
	public HomePage clickContinueBtn() {
		submitContinueBtn.click();
		return new HomePage();
	}

}
