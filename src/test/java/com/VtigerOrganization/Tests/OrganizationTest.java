package com.VtigerOrganization.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger_Practice.OrgnizationMultipleTest;
import com.vtiger.genericUtilties.BaseClass;
import com.vtiger.genericUtilties.ExcelUtility;
import com.vtiger.genericUtilties.JavaUtility;
import com.vtiger.genericUtilties.PropertyFileUtility;
import com.vtiger.genericUtilties.WebdriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.Objectrepository.ContactPage;
import vtiger.Objectrepository.ContactPageInfo;
import vtiger.Objectrepository.LoginPage;
import vtiger.Objectrepository.Organizationpage;

@Listeners(com.vtiger.genericUtilties.ListenersImplimantetion.class)
public class OrganizationTest extends BaseClass {
	
	
	
	@Test(groups = "RegressionSuite")
	public void contactithOrganizationTest() throws IOException{
		
	
		
		String OrgName = eUtil.readDataFromExcel("Organization", 4, 2)+jUtil.getrandomNumber();
		System.out.println(OrgName);
		
		String LastName = eUtil.readDataFromExcel("Contact", 4, 2)+jUtil.getrandomNumber();
		
	    String date = jUtil.systemDate();
	    System.out.println(date);
	    
		
		//step5:navigate to Organization.
		Organizationpage op=new Organizationpage(driver);
		op.orgLink();
		
		//step6:create organization.
		op.createOrg(OrgName);
		
		//step9:validate the organization.
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		Assert.assertTrue(orgHeader.contains(OrgName));
		
		//step10:create contact with using organization.
		ContactPage cp=new ContactPage(driver);
		cp.contactCreate();
		
		//step11:create new contact 
		ContactPageInfo cip=new ContactPageInfo(driver);
		cip.createContactInfo(driver, LastName, OrgName);
		
		
		//step18:validate the organization.
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		Assert.assertTrue(ContactHeader.contains(LastName));
					
	}
	
	@Test
	public void demo() {
		Assert.fail();
		System.out.println("happy to see you");
	}



@DataProvider(name="ORgNamewithIndustry")
public Object[][] getData() throws EncryptedDocumentException, IOException{
	
	Object[][] data = eUtil.readDataFromExcelToDataProvider("DataProvider");
	return data;
	
}	
	
}
