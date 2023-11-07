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

	public String getProductSearchMessage() {
		return productSearchMessage.getText();
	}
}
