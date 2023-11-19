package com.naveenautomation.Base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.Utils.Enum.Browsers;
import com.naveenautomation.Utils.WebDriverEvents;

public class BaseTest {

	// WebDriver instance
	public static WebDriver wd;
	private final Browsers browser = Browsers.CHROME;
	private final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static Logger logger;
	public WebDriverEvents events;
	private static final boolean RUN_ON_GRID = false;

	@BeforeClass
	public void loggerSteup() {
		logger = Logger.getLogger(BaseTest.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}

	public void intilisation(Browsers browser) {

		if (RUN_ON_GRID) {
			try {
				wd = new RemoteWebDriver(new URL("http://10.144.104.1:3454"), getOptions());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			switch (browser) {
			case CHROME:
				wd = new ChromeDriver();
				break;
			case EDGE:
				wd = new EdgeDriver();
				break;
			case FIREFOX:
				wd = new FirefoxDriver();
				break;

			default:
				throw new IllegalArgumentException();
			}

			events = new WebDriverEvents();
			wd = new EventFiringDecorator<WebDriver>(events).decorate(wd);

			// Load page
			wd.get(URL);

			wd.manage().window().maximize();

			wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}
	}

	public void dropDownSelection(WebElement element, String visibleText) {
		Select sc = new Select(element);
		sc.selectByVisibleText(visibleText);
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public enum navigationLinks {
		MY_ACCOUNT(By.cssSelector("aside[id='column-right']>div>a:first-of-type")),
		EDIT_ACCOUNT(By.cssSelector("aside[id='column-right']>div>a:nth-of-type(2)")),
		ADDRESS_BOOK(By.cssSelector("aside[id='column-right']>div>a:nth-of-type(4)")),
		CONTACT_US(By.xpath("//a[text()='Contact Us']")),
		PASSWORD(By.cssSelector("aside[id='column-right']>div>a:nth-of-type(3)")),
		RETURNS(By.cssSelector("aside[id='column-right']>div>a:nth-of-type(10)")),
		NEWSLETTER(By.cssSelector("aside[id='column-right']>div>a:nth-of-type(12)")),
		LOGOUT(By.cssSelector("aside[id='column-right']>div>a:nth-of-type(13)"));

		private By cssSelector;

		navigationLinks(By cssSelector) {
			this.cssSelector = cssSelector;
		}

		public By getCssSelector() {
			return cssSelector;
		}
	}

	public void clickOnNavigationLink(navigationLinks item) {
		wd.findElement(item.getCssSelector()).click();
	}

	public void tearDown() {
		wd.close();
	}

	public MutableCapabilities getOptions() {
		return new ManageOptions().getOption(browser);

	}

	public static void failedTestScreenShot(String testMethodName) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		File screenShotFfile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShotFfile,
					new File("./FailedTestCasesScreenShot\\" + "_" + testMethodName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {

			System.out.println("................................The IO Exception is ...... " + e);
			e.printStackTrace();
		}

	}
}
