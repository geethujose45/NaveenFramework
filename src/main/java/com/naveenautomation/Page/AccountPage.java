package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

import io.qameta.allure.Step;

public class AccountPage extends BaseTest {
	EditAccountInfoPage editAccountInfoPage;
	NewsLetterSubscribtionPage newsLetterSubscribtionPage;
	AccountLogoutPage accountLogoutPage;

	public AccountPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountText;

	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement updateSuccessAlert;

	@FindBy(css = "div[class='alert alert-success alert-dismssible']")
	WebElement subscribtionUpdateMessage;

	// Method to get the text of 'My Account'
	@Step("Get My Account Text")
	public String getMyAccountText() {
		return myAccountText.getText();
	}

	// Method to get the text of info update success message
	@Step("Get Update Success Alert")
	public String getInfoUpdateSucessMessage() {
		return updateSuccessAlert.getText();
	}

	// Method to click 'Edit your account information' link and navigate to the edit
	// page
	public EditAccountInfoPage clickEditInfoLink() {
		clickOnNavigationLink(navigationLinks.EDIT_ACCOUNT);
		return new EditAccountInfoPage();
	}

	// Method to click 'Change your password' link and navigate to the change
	// password page
	public ChangePasswordPage clickChangePasswordLink() {
		clickOnNavigationLink(navigationLinks.PASSWORD);
		return new ChangePasswordPage();
	}

	// Method to click 'Subscribe / unsubscribe to newsletter' link and navigate to
	// the subscription page
	public NewsLetterSubscribtionPage clickSubscribtionLink() {
		clickOnNavigationLink(navigationLinks.NEWSLETTER);
		return new NewsLetterSubscribtionPage();
	}

	// Method to get the text of subscription update message
	public String getSubscribtionUpdateMessage() {
		return subscribtionUpdateMessage.getText();
	}

	// Method to click 'Logout' link and navigate to the logout page
	public AccountLogoutPage clickLogoutLink() {
		clickOnNavigationLink(navigationLinks.LOGOUT);
		return new AccountLogoutPage();

	}

	// Method to click 'View your return requests' link and navigate to the return
	// requests page
	public ProductReturnsPage clickReturnRequestLink() {
		clickOnNavigationLink(navigationLinks.RETURNS);
		return new ProductReturnsPage();
	}

	public AddressBookPage clickAddressBookLink() {
		clickOnNavigationLink(navigationLinks.ADDRESS_BOOK);
		return new AddressBookPage();
	}

}
