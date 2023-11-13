package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.BaseTest;

public class AffiliateAccountPage extends BaseTest {

	public AffiliateAccountPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-company")
	WebElement inputCompanyName;

	@FindBy(css = "#input-website")
	WebElement inputWebsite;

	@FindBy(css = "#input-tax")
	WebElement inputTax;

	@FindBy(css = "input[value='cheque']")
	WebElement selectCheque;

	@FindBy(css = "#input-cheque")
	WebElement inputCheque;

	@FindBy(css = "input[name='agree']")
	WebElement agreeCheckBox;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	public void enterCompanyName(String companyName) {
		inputCompanyName.sendKeys(companyName);
	}

	public void enterWebsite(String website) {
		inputWebsite.sendKeys(website);
	}

	public void enterTax(String tax) {
		inputTax.sendKeys(tax);
	}

	public void selectCheque() {
		selectCheque.click();
	}

	public void enterChequeDetails(String cheque) {
		inputCheque.sendKeys(cheque);
	}

	public void agreeCheckBox() {
		agreeCheckBox.click();
	}

	public AccountPage clickContinueBtn() {
		continueBtn.click();
		return new AccountPage();
	}

}
