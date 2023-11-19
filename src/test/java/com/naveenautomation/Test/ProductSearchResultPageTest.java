package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.HomePage;
import com.naveenautomation.Page.ProductSearchResultPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class ProductSearchResultPageTest extends BaseTest {

	private ProductSearchResultPage productSearchResultPage;
	private HomePage homePage;

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		homePage = new HomePage();
	}

	@Test
	public void validateIfUserCanSearchProduct() {
		productSearchResultPage = homePage.inputItemAndclickSearchBtn("Iphone");
		Assert.assertEquals("Products meeting the search criteria", productSearchResultPage.getProductSearchMessage());
	}

	@Test(enabled = false)
	public void validateIfUserCanAddProductToTheCart() {
		productSearchResultPage = homePage.inputItemAndclickSearchBtn("Iphone");
		Assert.assertEquals("Products meeting the search criteria", productSearchResultPage.getProductSearchMessage());
		productSearchResultPage.clickAddToCartBtn();
		Assert.assertEquals("1 item(s) - $123.20", productSearchResultPage.getCartTextAfterAddingItem());
	}

	@Test(enabled = false)
	public void validateIfUserCanAddProductToWishList() {
		productSearchResultPage = homePage.clickProductPhonesAndPdas();
		productSearchResultPage.clickAddToWishListBtn();
		Assert.assertEquals(productSearchResultPage.getProductAddedToWishListMessage(), "Success: You have added HTC Touch HD to your wish list!","Product not added to wishlist");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
