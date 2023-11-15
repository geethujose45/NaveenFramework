package com.naveenautomation.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.BaseTest;
import com.naveenautomation.Page.LoginPage;
import com.naveenautomation.Utils.BrokenLinks;
import com.naveenautomation.Utils.Enum.Browsers;

public class BrokenLinksTest extends BaseTest{
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void launch() {
		intilisation(Browsers.CHROME);
		loginPage = new LoginPage();
	}
	
	@Test
    public void testCheckAllLinks() {
        BrokenLinks.checkAllLinks();
        // Add assertions or checks if needed
    }
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
