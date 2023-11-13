package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class ShoppingCart extends BaseTest {
	public ShoppingCart() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css="div[id='checkout-cart']>div")
	WebElement productOutOfStockMessage;
	

	public String getProductOutOfStockMessage() {
		return productOutOfStockMessage.getText();
	}
	
	
}
