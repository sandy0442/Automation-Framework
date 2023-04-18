package com.vtiger.genericUtilties;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*/
 * This is the Implementation class for IretryAnalyaser interface of TestNg
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	int count=0;
	int retryCount=4;

	@Override
	public boolean retry(ITestResult result) {
		
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}
	

}
