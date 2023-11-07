package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class ContactUsPage extends BaseTest {

	public ContactUsPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h1[text()='Contact Us']")
	WebElement contactUsPageText;

	@FindBy(css = "#input-name")
	WebElement inputName;

	@FindBy(css = "#input-email")
	WebElement inputEmail;

	@FindBy(css = "#input-enquiry")
	WebElement inputEnquiry;

	@FindBy(css = "input[value='Submit']")
	WebElement submitBtn;

	@FindBy(css = "div[id='content']>p")
	WebElement contactSuccessMessage;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//div[text()='Name must be between 3 and 32 characters!']")
	WebElement nameAlertMessage;
	
	@FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
	WebElement emailAddressAlert;
	
	@FindBy(xpath="//div[text()='Enquiry must be between 10 and 3000 characters!']")
	WebElement enquiryAlertMessage;

	public void enterName(String name) {
		inputName.sendKeys(name);
	}

	public void enterEmail(String email) {
		inputEmail.sendKeys(email);
	}

	public void enterEnquiry(String enquiry) {
		inputEnquiry.sendKeys(enquiry);
	}

	public void clickSubmitBtn() {
		submitBtn.click();
	}

	public String getContactUsPageText() {
		return contactUsPageText.getText();
	}

	public String getNameAlertMessage() {
		return nameAlertMessage.getText();
	}
	public String getEmailAddressAlert() {
		return emailAddressAlert.getText();
	}

	public String getEnquiryAlertMessage() {
		return enquiryAlertMessage.getText();
	}

	public String getcontactSuccessMessage() {
		return contactSuccessMessage.getText();
	}


	public HomePage clickContinueBtn() {
		continueBtn.click();
		return new HomePage();
	}
}
