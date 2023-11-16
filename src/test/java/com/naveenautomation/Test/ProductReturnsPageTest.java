package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.HomePage;
import com.naveenautomation.Page.ProductReturnsPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class ProductReturnsPageTest extends BaseTest {

	private ProductReturnsPage productReturnsPage;
	private HomePage homePage;

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		homePage = new HomePage();
	}

	@Test
	public void validateIfUserCannotReturnProductWithoutMantatoryFirstNameField() {
		productReturnsPage = homePage.clickReturnsLink();
		productReturnsPage.enterLastName("Eric");
		productReturnsPage.enterEmail("kiti@mailinator.com");
		productReturnsPage.enterTelephone("5647865432");
		productReturnsPage.enterOrderId("45234");
		productReturnsPage.enterProduct("Apple Watch");
		productReturnsPage.enterProductCode("8564");
		productReturnsPage.reasonforReturn();
		productReturnsPage.productIsOpened();
		productReturnsPage.submitBtn();
		Assert.assertEquals(productReturnsPage.getFirstNameRequiredAlertMessage(),
				"First Name must be between 1 and 32 characters!", "User sucessfully returned item");
	}

	@Test
	public void validateIfUserCannotReturnProductWithoutMantatoryLastNameField() {
		productReturnsPage = homePage.clickReturnsLink();
		productReturnsPage.enterFirstName("Kiti");
		productReturnsPage.enterEmail("kiti@mailinator.com");
		productReturnsPage.enterTelephone("5647865432");
		productReturnsPage.enterOrderId("45234");
		productReturnsPage.enterProduct("Apple Watch");
		productReturnsPage.enterProductCode("8564");
		productReturnsPage.reasonforReturn();
		productReturnsPage.productIsOpened();
		productReturnsPage.submitBtn();
		Assert.assertEquals(productReturnsPage.getLastNameRequiredAlertMessage(),
				"Last Name must be between 1 and 32 characters!");
	}

	@Test
	public void validateIfUserCannotReturnProductWithoutMantatoryEmailField() {
		productReturnsPage = homePage.clickReturnsLink();
		productReturnsPage.enterFirstName("Kiti");
		productReturnsPage.enterLastName("Eric");
		productReturnsPage.enterTelephone("5647865432");
		productReturnsPage.enterOrderId("45234");
		productReturnsPage.enterProduct("Apple Watch");
		productReturnsPage.enterProductCode("8564");
		productReturnsPage.reasonforReturn();
		productReturnsPage.productIsOpened();
		productReturnsPage.submitBtn();
		Assert.assertEquals(productReturnsPage.getemailRequiredAlertMessage(),
				"E-Mail Address does not appear to be valid!");
	}

	@Test
	public void validateIfUserCannotReturnProductWithoutMantatoryTelephoneNumberField() {
		productReturnsPage = homePage.clickReturnsLink();
		productReturnsPage.enterFirstName("Kiti");
		productReturnsPage.enterLastName("Eric");
		productReturnsPage.enterEmail("kiti@mailinator.com");
		productReturnsPage.enterOrderId("45234");
		productReturnsPage.enterProduct("Apple Watch");
		productReturnsPage.enterProductCode("8564");
		productReturnsPage.reasonforReturn();
		productReturnsPage.productIsOpened();
		productReturnsPage.submitBtn();
		Assert.assertEquals(productReturnsPage.getTelephoneRequiredAlertMessage(),
				"Telephone must be between 3 and 32 characters!");
	}

	@Test
	public void validateIfUserCannotReturnProductWithoutMantatoryOrderIdField() {
		productReturnsPage = homePage.clickReturnsLink();
		productReturnsPage.enterFirstName("Kiti");
		productReturnsPage.enterLastName("Eric");
		productReturnsPage.enterEmail("kiti@mailinator.com");
		productReturnsPage.enterTelephone("5647865432");
		productReturnsPage.enterProduct("Apple Watch");
		productReturnsPage.enterProductCode("8564");
		productReturnsPage.reasonforReturn();
		productReturnsPage.productIsOpened();
		productReturnsPage.submitBtn();
		Assert.assertEquals(productReturnsPage.getOrderIdRequiredAlertMessage(),
				"Order ID required!");
	}

	@Test
	public void validateIfUserCannotReturnProductWithoutMantatoryProductNameField() {
		productReturnsPage = homePage.clickReturnsLink();
		productReturnsPage.enterFirstName("Kiti");
		productReturnsPage.enterLastName("Eric");
		productReturnsPage.enterEmail("kiti@mailinator.com");
		productReturnsPage.enterTelephone("5647865432");
		productReturnsPage.enterOrderId("45234");
		productReturnsPage.enterProductCode("8564");
		productReturnsPage.reasonforReturn();
		productReturnsPage.productIsOpened();
		productReturnsPage.submitBtn();
		Assert.assertEquals(productReturnsPage.getProductNameRequiredAlertMessage(),
				"Product Name must be greater than 3 and less than 255 characters!");
	}

	@Test
	public void validateIfUserCannotReturnProductWithoutMantatoryProductCodeField() {
		productReturnsPage = homePage.clickReturnsLink();
		productReturnsPage.enterFirstName("Kiti");
		productReturnsPage.enterLastName("Eric");
		productReturnsPage.enterEmail("kiti@mailinator.com");
		productReturnsPage.enterTelephone("5647865432");
		productReturnsPage.enterOrderId("45234");
		productReturnsPage.enterProduct("Apple Watch");
		productReturnsPage.reasonforReturn();
		productReturnsPage.productIsOpened();
		productReturnsPage.submitBtn();
		Assert.assertEquals(productReturnsPage.getProductCodeRequiredAlertMessage(),
				"Product Model must be greater than 3 and less than 64 characters!");
	}

	@Test
	public void validateIfUserCannotReturnProductWithoutMantatoryReturnReasonField() {
		productReturnsPage = homePage.clickReturnsLink();
		productReturnsPage.enterFirstName("Kiti");
		productReturnsPage.enterLastName("Eric");
		productReturnsPage.enterEmail("kiti@mailinator.com");
		productReturnsPage.enterTelephone("5647865432");
		productReturnsPage.enterOrderId("45234");
		productReturnsPage.enterProduct("Apple Watch");
		productReturnsPage.enterProductCode("8564");
		productReturnsPage.submitBtn();
		Assert.assertEquals(productReturnsPage.getProductReturnReasonRequiredAlertMessage(),
				"You must select a return product reason!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
