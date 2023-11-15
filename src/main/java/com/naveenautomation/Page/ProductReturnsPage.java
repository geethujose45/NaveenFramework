package com.naveenautomation.Page;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class ProductReturnsPage extends BaseTest {

	public ProductReturnsPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-firstname")
	WebElement enterFirstName;

	@FindBy(css = "#input-lastname")
	WebElement enterLastName;

	@FindBy(css = "#input-email")
	WebElement enterEmail;

	@FindBy(css = "#input-telephone")
	WebElement enterTelephone;

	@FindBy(css = "#input-order-id")
	WebElement enterOrderId;

	@FindBy(css = "#input-date-ordered")
	WebElement enterOrderedDate;

	@FindBy(css = "#input-product")
	WebElement enterProduct;

	@FindBy(css = "#input-model")
	WebElement enterProductCode;

	@FindBy(css = "#input-quantity")
	WebElement entetrQuantity;

	@FindBy(css = "input[name='return_reason_id']")
	WebElement reasonforReturn;

	@FindBy(css = "label[class='radio-inline']>input")
	WebElement productIsOpened;

	@FindBy(css = "#input-comment")
	WebElement faultyOrOtherDetails;

	@FindBy(css = "input[value='Submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//a[text()='Back']")
	WebElement backBtn;
	
	@FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
	WebElement firstNameRequiredAlertMessage;

	public void enterFirstName(String firstName) {
		enterFirstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		enterLastName.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		enterEmail.sendKeys(email);
	}

	public void enterTelephone(String telephoneNumber) {
		enterTelephone.sendKeys(telephoneNumber);
	}

	public void enterOrderId(String orderId) {
		enterOrderId.sendKeys(orderId);
	}

	public void enterProduct(String productName) {
		enterProduct.sendKeys(productName);

	}

	public void enterProductCode(String productCode) {
		enterProductCode.sendKeys(productCode);
	}

	public void entetrQuantity(String quantity) {
		entetrQuantity.sendKeys(quantity);
	}

	public void reasonforReturn() {
		reasonforReturn.click();
	}

	public void productIsOpened() {
		productIsOpened.click();
	}

	public void faultyOrOtherDetails(String detailsOfReturn) {
		faultyOrOtherDetails.sendKeys(detailsOfReturn);
	}

	public ProductReturnsSuccessPage submitBtn() {
		submitBtn.click();
		return new ProductReturnsSuccessPage();
	}

	public void backBtn() {
		backBtn.click();

	}

	public void datePicker() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		enterOrderedDate.click();
		enterOrderedDate.sendKeys(dtf.format(localDate));
	}
	
	public String getFirstNameRequiredAlertMessage() {
		return firstNameRequiredAlertMessage.getText();
	}

}
