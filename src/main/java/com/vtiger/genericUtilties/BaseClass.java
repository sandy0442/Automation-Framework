package com.vtiger.genericUtilties;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.Objectrepository.HomePage;
import vtiger.Objectrepository.LoginPage;

public class BaseClass {
	
	
	public ExcelUtility eUtil=new ExcelUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebdriverUtilities wUtil=new WebdriverUtilities();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	
	public WebDriver driver=null;
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("------Database connection Established------ ");
	}
	
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig() throws IOException {
		String Browser = pUtil.ReadDataFromPropertyFile("browser");
		String Url = pUtil.ReadDataFromPropertyFile("url");
		
		if(Browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			
			System.out.println("-----"+Browser+" Launched Successfully------");
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
			System.out.println("-----"+Browser+" Launched Successfully------");
		}
		else {
			System.out.println("invalid browser name");
		}
		
		sDriver=driver;
		wUtil.windowMaximize(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(Url);;
		
	}
	
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void bmconfig() throws IOException {
		String Username = pUtil.ReadDataFromPropertyFile("username");
		String Password = pUtil.ReadDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginApp(Username, Password);
		System.out.println("----LOgin to App Succsseful-----");	
	}
	
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void amconfig() {
		HomePage hp=new HomePage(driver);
		hp.SignOut(driver);
		System.out.println("-----------signOut Successfully-------------");
		
	}
	
	//@AfterTest
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void acConfig() {
		
		driver.quit();
		System.out.println("--------Browser closed Successfully-------");
		
	}
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void asConfig() {
		System.out.println("--------Database Connection closed-----");
	}

}
