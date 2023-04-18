package com.VtigerOrganization.Tests;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericUtilties.BaseClass;
import com.vtiger.genericUtilties.ExcelUtility;
import com.vtiger.genericUtilties.JavaUtility;
import com.vtiger.genericUtilties.PropertyFileUtility;
import com.vtiger.genericUtilties.WebdriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.Objectrepository.LoginPage;
import vtiger.Objectrepository.Organizationpage;

@Listeners(com.vtiger.genericUtilties.ListenersImplimantetion.class)
public class OrgTestWithMultipleValue extends BaseClass {
	
	ExcelUtility eUtil=new ExcelUtility();
	
	@Test(dataProvider = "ORgNamewithIndustry")
	public void OrgMultipleTest(String ORGNAME, String INDUSTRY) throws IOException {
		
		//step5:navigate to Organization.
		Organizationpage op=new Organizationpage(driver);
		op.orgLink();
		
		//step6:create organization.
		op.createOrg(ORGNAME);
		WebElement industryType = driver.findElement(By.name("industry"));
		wUtil.handlingDropdown(industryType, INDUSTRY);
		
		//step9:validate the organization.
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(ORGNAME)) {
			
			System.out.println("---------"+orgHeader+"---Pass---------");
		}
		else {
			
			System.out.println("---------"+orgHeader+"----failed------");
			
		}
		
	}
	
	@DataProvider(name="ORgNamewithIndustry")
	public Object[][] getData(String ORGNAME, String INDUSTRY) throws EncryptedDocumentException, IOException{
		
		Object[][] data = eUtil.readDataFromExcelToDataProvider("DataProvider");
		return data;
		
	}	


}
