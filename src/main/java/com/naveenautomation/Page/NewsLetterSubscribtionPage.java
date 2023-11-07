package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class NewsLetterSubscribtionPage extends BaseTest {
	AccountPage accountPage;

	public NewsLetterSubscribtionPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[value='0']")
	WebElement unSubscribtionRadioBtn;

	@FindBy(css = "input[value='Continue']")
	WebElement submitContinueBtn;

	// Method to click the radio button to unsubscribe from the newsletter
	public void unSubscribeNewsletter() {
		clickOnNavigationLink(navigationLinks.NEWSLETTER);
	}

	// Method to click the 'Continue' button and navigate to the AccountPage
	public AccountPage clickContinueBtn() {
		submitContinueBtn.click();
		return new AccountPage();
	}

}
