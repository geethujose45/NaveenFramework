package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class ProductPage extends BaseTest {
	public ProductPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//button[text()='Add to Cart']")
	WebElement addToCartBtn;
	
	@FindBy(css="div[id='cart']>button")
	WebElement cartDetailsBtn;
	
	
	@FindBy(css="div[id='cart']>ul>li:nth-of-type(2)>div>p>a:nth-of-type(2)")
	WebElement checkoutLink;

	public void clickAddToCartBtn() {
		addToCartBtn.click();
	}
	
	public void clickCartDetailsBtn() {
		cartDetailsBtn.click();
	}

	public ShoppingCart clickCheckoutLink() {
		checkoutLink.click();
		return new ShoppingCart() ;
	}
}
