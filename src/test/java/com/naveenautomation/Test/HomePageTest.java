package com.naveenautomation.Test;

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
import com.naveenautomation.Page.ProductReturnsPage;
import com.naveenautomation.Page.ProductReturnsSuccessPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class HomePageTest extends BaseTest {
	private AccountPage accountPage;
	private AccountLogoutPage accountLogoutPage;
	private LoginPage loginPage;
	private HomePage homePage;
	private ContactUsPage contactUsPage;
	private ProductReturnsPage productReturnsPage;
	private ProductReturnsSuccessPage productReturnsSuccessPage;

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		loginPage = new LoginPage();
		homePage = new HomePage();
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

	@Test
	public void validateIfUserCanReturnProduct() {
		productReturnsPage = homePage.clickReturnsLink();
		productReturnsPage.enterFirstName("Kiti");
		productReturnsPage.enterLastName("Eric");
		productReturnsPage.enterEmail("kiti@mailinator.com");
		productReturnsPage.enterTelephone("5647865432");
		productReturnsPage.enterOrderId("45234");
		sleep();
		// productReturnsPage.datePicker();
		productReturnsPage.enterProduct("Apple Watch");
		productReturnsPage.enterProductCode("8564");
		productReturnsPage.entetrQuantity("1");
		productReturnsPage.reasonforReturn();
		productReturnsPage.productIsOpened();
		productReturnsPage.faultyOrOtherDetails("Found Defect in the product not able to use");
		productReturnsSuccessPage = productReturnsPage.submitBtn();
		homePage = productReturnsSuccessPage.clickSubmitBtn();
		Assert.assertEquals(homePage.getfeaturedItemsText(), "Featured", "Logout not successful");
	}

	@Test
	public void validateIfUserCanReturnProductWithoutUnnecessaryFields() {
		productReturnsPage = homePage.clickReturnsLink();
		productReturnsPage.enterFirstName("Kiti");
		productReturnsPage.enterLastName("Eric");
		productReturnsPage.enterEmail("kiti@mailinator.com");
		productReturnsPage.enterTelephone("5647865432");
		productReturnsPage.enterOrderId("45234");
		productReturnsPage.enterProduct("Apple Watch");
		productReturnsPage.enterProductCode("8564");
		productReturnsPage.reasonforReturn();
		productReturnsPage.productIsOpened();
		productReturnsSuccessPage = productReturnsPage.submitBtn();
		homePage = productReturnsSuccessPage.clickSubmitBtn();
		Assert.assertEquals(homePage.getfeaturedItemsText(), "Featured", "Logout not successful");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
