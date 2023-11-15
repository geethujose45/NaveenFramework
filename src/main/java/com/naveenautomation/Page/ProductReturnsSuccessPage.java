package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class ProductReturnsSuccessPage extends BaseTest {
	public ProductReturnsSuccessPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h1[text()='Product Returns']")
	WebElement productReturnsSucessPageTitleText;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement submitBtn;
	
	public String getProductReturnsSucessPageTitleText() {
		return productReturnsSucessPageTitleText.getText();
	}
	
	public HomePage clickSubmitBtn() {
		submitBtn.click();
		return new HomePage();
	}
	

}
