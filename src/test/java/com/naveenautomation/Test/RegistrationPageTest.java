package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Page.ReigistrationPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class RegistrationPageTest extends BaseTest {
	private LoginPage loginPage;
	private ReigistrationPage reigistrationPage;

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		loginPage = new LoginPage();
	}

	@Test
	public void ValidateUserCannotRegisterwithoutCheckingAgreeCheckbox() {
		reigistrationPage = loginPage.clickContinueRegisterBtn();
		reigistrationPage.enterFirstName("Kidisti");
		reigistrationPage.enterLastName("Roy");
		reigistrationPage.enteremail("kidistiroy@mailinator.com");
		reigistrationPage.enterTelePhone("45645645");
		reigistrationPage.enterPassword("test");
		reigistrationPage.enterConfirmPassword("test");
		reigistrationPage.clickContinueBtn();
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",
				reigistrationPage.getprivacyPolicyAgreeCheckBoxValidationMessage());
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
