package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.AccountPage;
import com.naveenautomation.Page.AffiliateAccountPage;
import com.naveenautomation.Page.AffiliateTrackingPage;
import com.naveenautomation.Page.ChangePasswordPage;
import com.naveenautomation.Page.EditAccountInfoPage;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Page.NewsLetterSubscribtionPage;
import com.naveenautomation.Page.ReturnsPage;
import com.naveenautomation.Page.RegistratonSucessMessagePage;
import com.naveenautomation.Page.ReigistrationPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class AccountPageTest extends BaseTest {
	private AccountPage accountPage;
	private LoginPage loginPage;
	private EditAccountInfoPage editAccountInfoPage;
	private ChangePasswordPage changePasswordPage;
	private NewsLetterSubscribtionPage newsLetterSubscribtionPage;
	private ReturnsPage returnsPage;
	private ReigistrationPage registrationPage;
	private RegistratonSucessMessagePage registrationSucessMessagePage;
	private AffiliateAccountPage affiliateAccountPage;
	private AffiliateTrackingPage affiliateTrackingPage;
	private ReigistrationPage reigistrationPage;

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		loginPage = new LoginPage();
	}

	@Test(enabled = false)
	public void validateUserCanValidateLoginWithValidCredential() {
		// Log in with valid credentials and verify the 'My Account' text
		accountPage = loginPage.submitLogin("kelevocu@mailinator.com", "test");
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User Not Loggeg In");
	}

	@Test
	public void validateIfUserCanUpdateAccountInfo() {
		// Login and navigate to the Edit Account Information page
		accountPage = loginPage.submitLogin("pykus@mailinator.com", "test");
		editAccountInfoPage = accountPage.clickEditInfoLink();
		// Enter and submit updated information
		editAccountInfoPage.enterLastName("Kidisi");
		accountPage = editAccountInfoPage.clickContinue();
		// Verify the success message
		Assert.assertEquals(accountPage.getInfoUpdateSucessMessage(),
				"Success: Your account has been successfully updated.", "Message not as expected");

	}

	@Test(enabled = false)
	public void validateIfUserCanChangePassword() {
		// Log in and navigate to the Change Password page
		accountPage = loginPage.submitLogin("gakomuzod@mailinator.com", "Test");
		changePasswordPage = accountPage.clickChangePasswordLink();
		// Enter and confirm the new password
		changePasswordPage.enterPassword("Test");
		changePasswordPage.enterConfirmPassword("Test");
		accountPage = changePasswordPage.clickPasswordUpdateContinueBtn();
		// Verify the success message
		Assert.assertEquals(accountPage.getInfoUpdateSucessMessage(),
				"Success: Your password has been successfully updated.", "Password not changed");
	}

	@Test(enabled = false)
	public void validateIfUserUpdateSubscribtion() {
		// Log in and navigate to the Newsletter Subscription page
		accountPage = loginPage.submitLogin("wujex@mailinator.com", "test");
		newsLetterSubscribtionPage = accountPage.clickSubscribtionLink();
		// Unsubscribe from the newsletter and verify the success message
		newsLetterSubscribtionPage.unSubscribeNewsletter();
		accountPage = newsLetterSubscribtionPage.clickContinueBtn();
		Assert.assertEquals(accountPage.getSubscribtionUpdateMessage(),
				"Success: Your newsletter subscription has been successfully updated!",
				"Failed to update subscription");
	}

	@Test(enabled = false)
	public void validateNoProductToReturnMessage() {
		// Log in and navigate to the Product Returns page
		accountPage = loginPage.submitLogin("woqequn@mailinator.com", "test");
		returnsPage = accountPage.clickReturnRequestLink();
		// Verify the message indicating no previous returns
		Assert.assertEquals(returnsPage.getproductReturnText(), "You have not made any previous returns!",
				"Navigation to product returns page failed");
		// Click 'Continue'
		accountPage = returnsPage.clickContinueBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User navigation to my account page failed");

	}

	@Test(priority = 1,enabled = false)
	public void validateIfUserCanRegisterAffiliateAccount() {
		accountPage = loginPage.submitLogin("wujex@mailinator.com", "test");
		affiliateAccountPage = accountPage.clickRegisterForAffiliateAccountLink();
		affiliateAccountPage.enterCompanyName("Phases");
		affiliateAccountPage.enterWebsite("www.phases.com");
		affiliateAccountPage.enterTax("67428902834");
		affiliateAccountPage.selectCheque();
		affiliateAccountPage.enterChequeDetails("9734238798274");
		affiliateAccountPage.agreeCheckBox();
		accountPage = affiliateAccountPage.clickContinueBtn();
		Assert.assertEquals(accountPage.getAccountUpdatesMessage(),
				"Success: Your account has been successfully updated.");
	}

	@Test(priority = 2,enabled = false)
	public void validateIfUserCanEditAffiliateAccount() {
		accountPage = loginPage.submitLogin("wujex@mailinator.com", "test");
		affiliateAccountPage = accountPage.clickeditAffiliateInformationLink();
		affiliateAccountPage.selectCheque();
		affiliateAccountPage.enterChequeDetails("Tressa");
		accountPage = affiliateAccountPage.clickContinueBtn();
		Assert.assertEquals(accountPage.getAccountUpdatesMessage(),
				"Success: Your account has been successfully updated.");
	}

	@Test(priority = 3,enabled = false)
	public void validateIfUserCanCustomAffiliateTrackingCode() {
		accountPage = loginPage.submitLogin("wujex@mailinator.com", "test");
		affiliateTrackingPage = accountPage.clickCustomAffiliateTrackingCodeLink();
		affiliateTrackingPage.enterInputLink("www.google.com");
		affiliateTrackingPage.clickCotinue();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "Custom Affiliate Tracking Code No Sucess");
	}

	@Test(enabled = false)
	public void validateUserCanRegister() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.enterFirstName("Kidisti");
		registrationPage.enterLastName("Roy");
		registrationPage.enteremail("kidistiroy@mailinator.com");
		registrationPage.enterTelePhone("45645645");
		registrationPage.enterPassword("test");
		registrationPage.enterConfirmPassword("test");
		registrationPage.clickAgreeCheckBox();
		registrationSucessMessagePage = registrationPage.clickContinueBtn();
		Assert.assertEquals("Congratulations! Your new account has been successfully created!",
				registrationSucessMessagePage.getRegistrationSucessMessage());
		accountPage = registrationSucessMessagePage.clickContinueBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User Not registered");

	}

	@Test(enabled = false)
	public void validateUserCannotNavigateBackToRegistrationPageAfterRegistration() {
		reigistrationPage = loginPage.clickContinueRegisterBtn();
		reigistrationPage.enterFirstName("zamon");
		reigistrationPage.enterLastName("ywuz");
		reigistrationPage.enteremail("darimoji@mailinator.com");
		reigistrationPage.enterTelePhone("45645645");
		reigistrationPage.enterPassword("test");
		reigistrationPage.enterConfirmPassword("test");
		reigistrationPage.clickAgreeCheckBox();
		reigistrationPage.clickContinueBtn();
		wd.navigate().back();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User Not registered");

	}



	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
