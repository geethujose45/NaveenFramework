package com.naveenautomation.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.AccountLogoutPage;
import com.naveenautomation.Page.AccountPage;
import com.naveenautomation.Page.ContactUsPage;
import com.naveenautomation.Page.HomePage;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class HomePageTest extends BaseTest {
	AccountPage accountPage;
	AccountLogoutPage accountLogoutPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactUsPage contactUsPage;

	public HomePageTest() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserLoggedOutSucsessfully() {
		// Log in and navigate to the Account Page
		accountPage = loginPage.submitLogin("zotitad@mailinator.com", "test");
		// Log out and verify the logout confirmation message
		accountLogoutPage = accountPage.clickLogoutLink();
		Assert.assertEquals(accountLogoutPage.getlogoutConfirmationMessage(),
				"You have been logged off your account. It is now safe to leave the computer.",
				"Logout not successful");
		// Click 'Continue' and verify that the user is on the Home Page
		homePage = accountLogoutPage.clickContinueBtn();
		Assert.assertEquals(homePage.getfeaturedItemsText(), "Featured", "Logout not successful");

	}

	@Test
	public void validateIfUserCanContactStore() {
		contactUsPage = loginPage.clickContactUsLink();
		Assert.assertEquals(contactUsPage.getContactUsPageText(), "Contact Us", "Navigation to contact us failed");
		contactUsPage.enterName("Kidisti");
		contactUsPage.enterEmail("Kidisti@gmail.com");
		contactUsPage.enterEnquiry("Et fugit incidunt ");
		contactUsPage.clickSubmitBtn();
		Assert.assertEquals(contactUsPage.getcontactSuccessMessage(),
				"Your enquiry has been successfully sent to the store owner!", "Contacting store failed");
		homePage = contactUsPage.clickContinueBtn();
		Assert.assertEquals(homePage.getfeaturedItemsText(), "Featured", "Logout not successful");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
