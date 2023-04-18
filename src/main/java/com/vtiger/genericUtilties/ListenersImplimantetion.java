package com.vtiger.genericUtilties;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimantetion implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		 test = report.createTest(methodName);
		 test.log(Status.INFO, methodName+"======Test script Exicution Started=======");
	} 

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName+"======Test script Exicution PASSED=======");
		test.log(Status.PASS, methodName+"======Test script Exicution PASSED=======");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName+"======Test script Exicution FAILED=======");
		test.log(Status.FAIL,methodName+"======Test script Exicution FAILED=======" );
		
		WebdriverUtilities wUtil=new WebdriverUtilities();
		JavaUtility jUtil=new JavaUtility();
		
		String screenShotName = methodName+"-"+jUtil.SystemDateInFormat();
		
		try {
			String path = wUtil.takeScreenShots(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);//go to the screenshot location and attach the
																//screenshot
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"======Test script Exicution SKIPPED=======");
		test.log(Status.SKIP, methodName+"======Test script Exicution SKIPPED=======");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("=====EXICUTION STARTED=======");
		
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(".\\Extent_Reports\\Report-"+new JavaUtility().SystemDateInFormat()+".html");
		htmlReporter.config().setDocumentTitle("Vtiger Extenssion Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Automation Execution Report");
		
	    report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("base URL", "http://localhost:8888/");
		report.setSystemInfo("base browser", "chrome");
		report.setSystemInfo("base platform", "windows");
		report.setSystemInfo("Reporter-Name", "Sandeep T");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("=====EXICUTION FINISHED=======");
		
		report.flush();
	}
	
	

}
