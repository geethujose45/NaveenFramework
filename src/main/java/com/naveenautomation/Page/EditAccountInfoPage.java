package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class EditAccountInfoPage extends BaseTest {
	AccountPage accountPage;

	public EditAccountInfoPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-firstname")
	WebElement firstNameInput;

	@FindBy(css = "#input-lastname")
	WebElement lastNameInput;

	@FindBy(css = "#input-email")
	WebElement emailInput;

	@FindBy(css = "#input-telephone")
	WebElement telephoneNameInput;
	
	@FindBy(xpath="//h1[text()='My Account Information']")
	WebElement myAccountInfoText;
	
	@FindBy(css="input[value='Continue']")
	WebElement continueBtn;

	 // Method to enter the first name in the first name input field
	public void enterFirstName(String firstName) {
		firstNameInput.clear();
		firstNameInput.sendKeys(firstName);
	}

	// Method to enter the last name in the last name input field
	public void enterLastName(String lastName) {
		lastNameInput.clear();
		lastNameInput.sendKeys(lastName);
	}

	// Method to enter the email in the email input field
	public void enterEmailName(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
	}

	// Method to enter the telephone number in the telephone input field
	public void enterTelePhoneNumber(String telephoneNUmber) {
		telephoneNameInput.clear();
		telephoneNameInput.sendKeys(telephoneNUmber);
	}
	
	// Method to get the text of 'My Account Information'
	public String getmyAccountInfoText() {
		return myAccountInfoText.getText();
	}
	
	// Method to click the 'Continue' button and navigate to the AccountPage
	public AccountPage clickContinue() {
		continueBtn.click();
		return new AccountPage();
	}
}
