package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class AffiliateTrackingPage extends BaseTest {

	public AffiliateTrackingPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#id=input-generator")
	WebElement inputGenerator;

	@FindBy(css = "#input-link")
	WebElement inputLink;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement continueBtn;
	
	public void enterInputGenerator() {
		inputGenerator.click();
		dropDownSelection(inputGenerator, "Canon EOS 5D");
	}

	public void enterInputLink(String link) {
		inputLink.sendKeys(link);
	}
	
	public void clickCotinue() {
		continueBtn.click();
	}


}
