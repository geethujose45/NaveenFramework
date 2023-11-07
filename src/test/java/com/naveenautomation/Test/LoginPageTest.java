package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.AccountPage;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class LoginPageTest extends BaseTest {
	private LoginPage loginPage;
	private AccountPage accountPage;
	

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		loginPage = new LoginPage();
	}

	@Test
	public void validateUserCannotValidateLoginWithInValidCredential() {
		accountPage = loginPage.submitLogin("liib@maintor.com", "test");
		Assert.assertEquals(loginPage.getcredentialWarningMessage(),
				"Warning: No match for E-Mail Address and/or Password.", "User loggin failed");
	}
	
	public void  tryingToExampleTest() {
		Assert.assertEquals("munni","munni");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
