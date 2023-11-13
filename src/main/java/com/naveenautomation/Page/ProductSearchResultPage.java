package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class ProductSearchResultPage extends BaseTest {
	public ProductSearchResultPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h2[text()='Products meeting the search criteria']")
	WebElement productSearchMessage;

	@FindBy(xpath = "//span[text()='Add to Cart']")
	WebElement addToCartBtn;

	@FindBy(css = "div[id='product-search']>div")
	WebElement productAddedToCartSucessMessage;

	@FindBy(xpath = "//span[text()=' 1 item(s) - $123.20']")
	WebElement cartTextAfterAddingItem;

	@FindBy(css = "div[class='caption']>h4>a")
	WebElement productLink;

	public String getProductSearchMessage() {
		return productSearchMessage.getText();
	}

	public void clickAddToCartBtn() {
		addToCartBtn.click();
	}

	public String getProductAddedToCartSucessMessage() {
		return productAddedToCartSucessMessage.getText();
	}

	public String getCartTextAfterAddingItem() {
		return cartTextAfterAddingItem.getText();
	}

	public ProductPage clickProductLink() {
		productLink.click();
		return new ProductPage();
	}

	
}
