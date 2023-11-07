package com.naveenautomation.Page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class AddressBookPage extends BaseTest {
	public AddressBookPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h2[text()='Address Book Entries']")
	WebElement addressBookPageText;

	@FindBy(xpath = "//a[text()='New Address']")
	WebElement newAddressBtn;

	@FindBy(css = "#input-firstname")
	WebElement inputFirstName;

	@FindBy(css = "#input-lastname")
	WebElement inputLastName;

	@FindBy(css = "#input-address-1")
	WebElement inputAddress;

	@FindBy(css = "#input-city")
	WebElement inputCity;

	@FindBy(css = "#input-postcode")
	WebElement inputPostcode;

	@FindBy(css = "#input-country")
	WebElement inputCountry;

	@FindBy(css = "#input-zone")
	WebElement inputZone;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")
	WebElement addressAddedSuccessMsg;

	@FindBy(xpath = "//a[text()='Delete']")
	WebElement deleteDefaultAddress;

	@FindBy(xpath = "//div[text()=' Warning: You can not delete your default address!']")
	WebElement deleteDefaultAddessAlertMessage;
	
	@FindBy(xpath="//div[text()=' Your address has been successfully deleted']")
	WebElement deleteSucessMessage;

	public String getAddressBookPageText() {
		return addressBookPageText.getText();
	}

	public void clickAddNewAddress() {
		newAddressBtn.click();
	}

	public void enterFirstName(String firstName) {
		inputFirstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		inputLastName.sendKeys(lastName);
	}

	public void enterAddress(String address) {
		inputAddress.sendKeys(address);
	}

	public void enterCity(String city) {
		inputCity.sendKeys(city);
	}

	public void enterPostcode(String postalCode) {
		inputPostcode.sendKeys(postalCode);
	}

	public void enterCountry(String visibleText) {
		dropDownSelection(inputCountry, visibleText);
	}

	public void enterZone(String visibleText) {
		dropDownSelection(inputZone, visibleText);
	}

	public void clickContinueBtn() {
		continueBtn.click();
	}

	public String getAddressAddedSuccessMsg() {
		return addressAddedSuccessMsg.getText();
	}

	public void deleteDefaultAddress() {
		deleteDefaultAddress.click();
		Alert alert = wd.switchTo().alert();
		alert.accept();
	}

	public String getdeleteDefaultAddessAlertMessage() {
		return deleteDefaultAddessAlertMessage.getText();
	}
	
	public String getDeleteSucessMessage() {
		return deleteSucessMessage.getText();
	}
	
	
}
