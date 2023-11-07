package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.AccountPage;
import com.naveenautomation.Page.AddressBookPage;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class AddressBookPageTest extends BaseTest {
	LoginPage loginPage;
	AccountPage accountPage;
	AddressBookPage addressBookPage;

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		wd.manage().deleteAllCookies();
		loginPage = new LoginPage();
	}

	@Test(priority = 2)
	public void validateUserCanDeleteAddress() {
		accountPage = loginPage.submitLogin("nykuny@mailinator.com", "test");
		addressBookPage = accountPage.clickAddressBookLink();
		Assert.assertEquals(addressBookPage.getAddressBookPageText(), "Address Book Entries",
				"Navigation to address book page failed");
		addressBookPage.deleteDefaultAddress();
		sleep();
		Assert.assertEquals(addressBookPage.getDeleteSucessMessage(), "Your address has been successfully deleted");
	}

	@Test(priority = 1)
	public void validateUserCanAddNewAddressBook() {
		// Log in and navigate to the Product Returns page
		accountPage = loginPage.submitLogin("nykuny@mailinator.com", "test");
		addressBookPage = accountPage.clickAddressBookLink();
		Assert.assertEquals(addressBookPage.getAddressBookPageText(), "Address Book Entries",
				"Navigation to address book page failed");

		addressBookPage.clickAddNewAddress();

		// Input values in address book fields
		addressBookPage.enterFirstName("Kidisti");
		addressBookPage.enterLastName("Maw");
		addressBookPage.enterAddress("23-34 Queen Street");
		addressBookPage.enterCity("Woodstock");
		addressBookPage.enterPostcode("1W1 3Z2");
		addressBookPage.enterCountry("Canada");
		sleep();
		addressBookPage.enterZone("Ontario");

		// Click 'Continue'
		addressBookPage.clickContinueBtn();
		Assert.assertEquals(addressBookPage.getAddressAddedSuccessMsg(), "Your address has been successfully added",
				"Adding new address failed");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
