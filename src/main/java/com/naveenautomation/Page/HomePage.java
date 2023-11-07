package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class HomePage extends BaseTest {

	
	public HomePage() {
		PageFactory.initElements(wd, this);
	}
	

	@FindBy(xpath = "//h3[text()='Featured']")
	WebElement featuredItemsText;
	
	@FindBy(css="input[name='search']")
	WebElement searchItem;
	
	@FindBy(css="div[id='search']>span>button")
	WebElement searchBtn;

	// Method to get the text of the 'Featured' items section
	public String getfeaturedItemsText() {
		return featuredItemsText.getText();
	}
	
	public ProductSearchResultPage inputSearchItem(String itemSearch) {
		 searchItem.sendKeys(itemSearch);
		 return new ProductSearchResultPage();
	}
	
	public ProductSearchResultPage clickSearchBtn() {
		searchBtn.click();
		return new ProductSearchResultPage();
	}

}
