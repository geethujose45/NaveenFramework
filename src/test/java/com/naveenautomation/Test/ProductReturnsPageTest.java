package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.HomePage;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Page.ProductReturnsPage;
import com.naveenautomation.Page.ProductReturnsSuccessPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class ProductReturnsPageTest extends BaseTest {
	

	private ProductReturnsPage productReturnsPage;
	private HomePage homePage;
	private ProductReturnsSuccessPage productReturnsSuccessPage;
	
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
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
