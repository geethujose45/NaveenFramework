package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.HomePage;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Page.ProductPage;
import com.naveenautomation.Page.ProductSearchResultPage;
import com.naveenautomation.Page.ShoppingCart;
import com.naveenautomation.Utils.Enum.Browsers;

public class ShoppingCartPageTest extends BaseTest{
	
	private HomePage homePage;
	private ProductSearchResultPage productSearchResultPage;
	private ProductPage productPage;
	private ShoppingCart shoppingCart;

	
	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		homePage=new HomePage();
	}
	
	@Test(enabled = false)
	public void validateIfUserGetItemOutOfStockMessageForOutOfStockItems() {
		
		productSearchResultPage=homePage.clickProductPhonesAndPdas();
		productPage=productSearchResultPage.clickProductLink();
		productPage.clickAddToCartBtn();
		productPage.clickCartDetailsBtn();
		shoppingCart= productPage.clickCheckoutLink();
		Assert.assertEquals("Products marked with *** are not available in the desired quantity or not in stock!", shoppingCart.getProductOutOfStockMessage());
		
		
		
		
	}
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
