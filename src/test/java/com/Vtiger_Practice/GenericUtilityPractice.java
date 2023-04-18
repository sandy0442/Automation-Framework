package com.Vtiger_Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.genericUtilties.ExcelUtility;
import com.vtiger.genericUtilties.JavaUtility;
import com.vtiger.genericUtilties.PropertyFileUtility;
import com.vtiger.genericUtilties.WebdriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericUtilityPractice {
/**
 * 
 * @param args
 * @throws IOException
 * @throws InterruptedException 
 */
	public static void main(String[] args) throws IOException, InterruptedException {
	
		PropertyFileUtility pUtil= new PropertyFileUtility();
		String data1 = pUtil.ReadDataFromPropertyFile("browser");
		String data2 =pUtil.ReadDataFromPropertyFile("url");
		String data3 =pUtil.ReadDataFromPropertyFile("username");
		String data4 =pUtil.ReadDataFromPropertyFile("password");
		
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4);
		
		
		ExcelUtility eUtil = new ExcelUtility();
		String value = eUtil.readDataFromExcel("Organization", 1, 1);
		System.out.println(value);
		
		eUtil.writeDataIntoExcel("Organization", 1, 7, "sandeep");
		
		JavaUtility jUtil=new JavaUtility();
		int ran = jUtil.getrandomNumber();
		String date = jUtil.systemDate();
		String date1 = jUtil.SystemDateInFormat();
		
		System.out.println(ran);
		System.out.println(date);
		System.out.println(date1);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
		WebdriverUtilities wUtil=new WebdriverUtilities();
		wUtil.windowMaximize(driver);
		
		Thread.sleep(3000);
		
		wUtil.minimizeWindow(driver);
	}
	
	
	

}
