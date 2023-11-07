package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class RegistratonSucessMessagePage extends BaseTest {
	public RegistratonSucessMessagePage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//p[text()='Congratulations! Your new account has been successfully created!']")
	WebElement registrationSucessMessage;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;

	public String getRegistrationSucessMessage() {
		return registrationSucessMessage.getText();
	}

	public AccountPage clickContinueBtn() {
		continueBtn.click();
		return new AccountPage();
	}
}
