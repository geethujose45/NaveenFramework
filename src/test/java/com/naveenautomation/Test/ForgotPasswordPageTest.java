package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.ForgotPasswordPage;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class ForgotPasswordPageTest extends BaseTest {

	private LoginPage loginPage;
	private ForgotPasswordPage forgetPasswordPage;

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserCanRetrivePassword() {
		// Navigate to the Forgot Password page
		forgetPasswordPage = loginPage.clickForgottenPwdLink();
		// Enter an invalid email address and click Continue
		forgetPasswordPage.enterEmail("t@gmail.");
		forgetPasswordPage.clickContinueBtn();
		// Verify the error message when the email address is not found
		Assert.assertEquals(forgetPasswordPage.getforgettenPwdFailedMessage(),
				"Warning: The E-Mail Address was not found in our records, please try again!",
				"Password send to your email");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
