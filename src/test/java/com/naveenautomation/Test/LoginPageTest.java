package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.AccountPage;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Utils.Enum.Browsers;
import com.naveenautomation.Utils.ExcelUtil;

public class LoginPageTest extends BaseTest {
	private LoginPage loginPage;
	private AccountPage accountPage;
	

	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		loginPage = new LoginPage();
	}

	@Test(enabled = false)
	public void validateUserCannotValidateLoginWithInValidCredential() {
		accountPage = loginPage.submitLogin("liib@maintor.com", "test");
		Assert.assertEquals(loginPage.getcredentialWarningMessage(),
				"Warning: No match for E-Mail Address and/or Password.", "User loggin failed");
	}
	
	@Test(enabled = false)
	public void validateUserCannotValidateLoginWithEmptyField() {
		accountPage = loginPage.submitLogin("", "");
		Assert.assertEquals(loginPage.getcredentialWarningMessage(),
				"Warning: No match for E-Mail Address and/or Password.", "User loggin failed");
	}
	
	@Test(dataProvider = "User Credentials",enabled = false)
	private void validateLoginWithMultipleValidCredentials(String userName, String password) {
		accountPage = loginPage.submitLogin(userName, password);
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "Login Failed.");

	}
	
	@DataProvider(name = "User Credentials")
	private Object[][] getDataFromExcelSheel() throws Exception {
		String fileName = "C:\\Users\\geeth\\Downloads\\UserCredentials.xlsx";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtil.getRowCount(fileName, sheetName);
		int coloumnCount = ExcelUtil.getColoumnCount(fileName, sheetName, rowCount);

		String[][] virtualSheet = new String[rowCount][coloumnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < coloumnCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtil.getCellData(fileName, sheetName, i, j);

			}

		}
		return virtualSheet;

	}
	

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
