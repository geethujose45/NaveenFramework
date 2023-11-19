package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.ContactUsPage;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class ContactUsPageTest extends BaseTest {
	private LoginPage loginPage;
	private ContactUsPage contactUsPage;

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		loginPage = new LoginPage();
	}

	@Test(enabled = false)
	public void validateUserCanSubmitContactUsFormWithoutValues() {
		contactUsPage = loginPage.clickContactUsLink();
		Assert.assertEquals(contactUsPage.getContactUsPageText(), "Contact Us", "Navigation to contact us failed");
		contactUsPage.clickSubmitBtn();
		sleep();
		Assert.assertEquals(contactUsPage.getNameAlertMessage(), "Name must be between 3 and 32 characters!",
				"Failed to display name alert message");
		sleep();
		Assert.assertEquals(contactUsPage.getEmailAddressAlert(), "E-Mail Address does not appear to be valid!",
				"Failed to display name alert message");
		sleep();
		Assert.assertEquals(contactUsPage.getEnquiryAlertMessage(), "Enquiry must be between 10 and 3000 characters!",
				"Failed to display name alert message");
		contactUsPage.clickSubmitBtn();

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
