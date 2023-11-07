package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class ForgotPasswordPage extends BaseTest {
	public ForgotPasswordPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h1[text()='Forgot Your Password?']")
	WebElement forgetPwdPageText;

	@FindBy(css = "#input-email")
	WebElement emailInput;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	@FindBy(css = "div[id='account-forgotten']>div:first-of-type")
	WebElement forgettenPwdFailedMessage;
	
	// Method to get the text of 'Forgot Your Password?'
	public void getforgetPwdPageText() {
		forgetPwdPageText.getText();
	}

	// Method to enter an email in the email input field
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	// Method to click the 'Continue' button
	public void clickContinueBtn() {
		continueBtn.click();
	}

	// Method to get the text of the message for forgotten password failure
	public String getforgettenPwdFailedMessage() {
		return forgettenPwdFailedMessage.getText();
	}

}
