package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class ReturnsPage extends BaseTest{
	public ReturnsPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath="//p[text()='You have not made any previous returns!']")
	WebElement productReturnText;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement continueBtn;
	
	// Method to get the text indicating no previous returns
	public String getproductReturnText() {
		return productReturnText.getText();
	}
	
	// Method to click the 'Continue' button and navigate to the AccountPage
	public AccountPage clickContinueBtn() {
		continueBtn.click();
		return new AccountPage();
	}
}

