package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Page.ReigistrationPage;
import com.naveenautomation.Utils.Enum.Browsers;

public class RegistrationPageTest extends BaseTest {
	private LoginPage loginPage;
	private ReigistrationPage reigistrationPage;

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		loginPage = new LoginPage();
	}

	@Test
	public void ValidateUserCannotRegisterwithoutCheckingAgreeCheckbox() {
		reigistrationPage = loginPage.clickContinueRegisterBtn();
		reigistrationPage.enterFirstName("xely");
		reigistrationPage.enterLastName("ryt");
		reigistrationPage.enteremail("xelyryt@mailinator.com");
		reigistrationPage.enterTelePhone("5177483421");
		reigistrationPage.enterPassword("test");
		reigistrationPage.enterConfirmPassword("test");
		reigistrationPage.clickContinueBtn();
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",
				reigistrationPage.getprivacyPolicyAgreeCheckBoxValidationMessage());
	}

	@Test
	public void ValidateUserCannotRegisterIfPasswordAndConfirmPasswordMismach() {
		reigistrationPage = loginPage.clickContinueRegisterBtn();
		reigistrationPage.enterFirstName("Adara");
		reigistrationPage.enterLastName("Roy");
		reigistrationPage.enteremail("jojem@mailinator.com");
		reigistrationPage.enterTelePhone("45645645");
		reigistrationPage.enterPassword("test");
		reigistrationPage.enterConfirmPassword("Test");
		reigistrationPage.clickContinueBtn();
		Assert.assertEquals("Password confirmation does not match password!",
				reigistrationPage.getPasswordAndConfirmPasswordMismatchMessage());
	}

	@Test
	public void ValidateUserCannotRegisterIfFirstNameIsEmpty() {
		reigistrationPage = loginPage.clickContinueRegisterBtn();
		reigistrationPage.enterFirstName("Adara");
		reigistrationPage.enteremail("jojem@mailinator.com");
		reigistrationPage.enterTelePhone("45645645");
		reigistrationPage.enterPassword("test");
		reigistrationPage.enterConfirmPassword("Test");
		reigistrationPage.clickContinueBtn();
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",
				reigistrationPage.getLastNamefieldRequiredAlert());
	}

	@Test
	public void ValidateUserCannotRegisterIfLastNameIsEmpty() {
		reigistrationPage = loginPage.clickContinueRegisterBtn();
		reigistrationPage.enterLastName("Roy");
		reigistrationPage.enteremail("jojem@mailinator.com");
		reigistrationPage.enterTelePhone("45645645");
		reigistrationPage.enterPassword("test");
		reigistrationPage.enterConfirmPassword("Test");
		reigistrationPage.clickContinueBtn();
		Assert.assertEquals("First Name must be between 1 and 32 characters!",
				reigistrationPage.getFirstNamefieldRequiredAlert());
	}

	@Test
	public void ValidateUserCannotRegisterIfEmailFieldIsEmpty() {
		reigistrationPage = loginPage.clickContinueRegisterBtn();
		reigistrationPage.enterFirstName("Adara");
		reigistrationPage.enterLastName("Roy");
		reigistrationPage.enterTelePhone("45645645");
		reigistrationPage.enterPassword("test");
		reigistrationPage.enterConfirmPassword("Test");
		reigistrationPage.clickContinueBtn();
		Assert.assertEquals("E-Mail Address does not appear to be valid!",
				reigistrationPage.getemailfieldRequiredAlert());
	}

	@Test
	public void ValidateUserCannotRegisterIfTelephoneNumberFieldIsEmpty() {
		reigistrationPage = loginPage.clickContinueRegisterBtn();
		reigistrationPage.enterFirstName("Adara");
		reigistrationPage.enterLastName("Roy");
		reigistrationPage.enteremail("jojem@mailinator.com");
		reigistrationPage.enterPassword("test");
		reigistrationPage.enterConfirmPassword("Test");
		reigistrationPage.clickContinueBtn();
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				reigistrationPage.gettelephoneNumberRequiredFieldAlert());
	}

	@Test
	public void ValidateUserCannotRegisterIfPasswordFieldIsEmpty() {
		reigistrationPage = loginPage.clickContinueRegisterBtn();
		reigistrationPage.enterFirstName("Adara");
		reigistrationPage.enterLastName("Roy");
		reigistrationPage.enteremail("jojem@mailinator.com");
		reigistrationPage.enterConfirmPassword("Test");
		reigistrationPage.clickContinueBtn();
		Assert.assertEquals("Password must be between 4 and 20 characters!",
				reigistrationPage.getpasswordRequieldFieldAlert());
	}

	@Test
	public void validateUniqueEmailRegistration() {
		reigistrationPage = loginPage.clickContinueRegisterBtn();
		reigistrationPage.enterFirstName("Kidisti");
		reigistrationPage.enterLastName("Roy");
		reigistrationPage.enteremail("kidistiroy@mailinator.com");
		reigistrationPage.enterTelePhone("45645645");
		reigistrationPage.enterPassword("test");
		reigistrationPage.enterConfirmPassword("test");
		reigistrationPage.clickAgreeCheckBox();
		reigistrationPage.clickContinueBtn();
		Assert.assertEquals("Warning: E-Mail Address is already registered!",
				reigistrationPage.getUserAldreadyRegisteredAlert());
	}

	@Test
	public void validateIfPrivadyPolicyIsAvailableOnClicking() {
		reigistrationPage = loginPage.clickContinueRegisterBtn();
		reigistrationPage.clickPrivacyPolicyLink();
		Assert.assertEquals("Privacy Policy", reigistrationPage.getPrivacyPolicyPopUpHeadingText());
		Assert.assertEquals("Register Account", reigistrationPage.getRegisterAccountTitleText());

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
