package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.HomePage;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Page.ProductSearchResultPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class ProductSearchResultPageTest extends BaseTest {
	private LoginPage loginPage;
	private ProductSearchResultPage productSearchResultPage;
	private HomePage homePage;

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		loginPage = new LoginPage();
		homePage= new HomePage();
	}

	@Test
	public void validateIfUserCanSearchProduct() {
		productSearchResultPage = homePage.inputItemAndclickSearchBtn("Iphone");
		Assert.assertEquals("Products meeting the search criteria", productSearchResultPage.getProductSearchMessage());
	}

	@Test
	public void validateIfUserCanAddProductToTheCart() {
		productSearchResultPage = homePage.inputItemAndclickSearchBtn("Iphone");
		Assert.assertEquals("Products meeting the search criteria", productSearchResultPage.getProductSearchMessage());
		productSearchResultPage.clickAddToCartBtn();
		Assert.assertEquals("1 item(s) - $123.20",productSearchResultPage.getCartTextAfterAddingItem());
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
