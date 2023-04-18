package com.Vtiger_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = com.vtiger.genericUtilties.RetryAnalyserImplementation.class)
	public void sample() {
		
		Assert.fail();
		System.out.println("hello");
	}

}
