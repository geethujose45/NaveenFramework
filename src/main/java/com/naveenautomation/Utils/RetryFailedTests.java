package com.naveenautomation.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomation.Base.BaseTest;


public class RetryFailedTests extends BaseTest implements IRetryAnalyzer {

	int cnt = 1;
	int maxCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying failed test : " + result.getMethod().getMethodName() + "for " + cnt);
		if (cnt < maxCount) {
			cnt++;
			return true;
		}

		return false;
	}

}