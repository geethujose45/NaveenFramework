package com.naveenautomation.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.naveenautomation.Base.BaseTest;

public class WebDriverEvents extends BaseTest implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		logger.info("Before Accepting Alerts");

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		logger.info("After Accepting Alerts");

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		logger.info("After Dismissing Alerts");

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		logger.info("Before Dismissing Alerts");

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		logger.info("Before navigating to" +url);

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		logger.info("After navigating to" +url);
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		logger.info("Before navigating Back");

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		logger.info("After navigating Back");

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		logger.info("Before navigating Forward");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		logger.info("After navigating Forward");

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		logger.info("Page Refreshed");

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Finding Element Using" +by);

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Finding Element Using" +by);

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicking On" +element.getText());
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicked On" +element);

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		logger.info("Getting Text On" +element.getText());

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		logger.info("Got Text On" +element.getText());
	}

}
