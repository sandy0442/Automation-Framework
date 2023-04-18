package com.Vtiger_Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.genericUtilties.ExcelUtility;

public class OrgnizationMultipleTest {
	
	ExcelUtility eUtil=new ExcelUtility();
	
	@Test
	public void orgMultipleTest() {
		
	}
	
	@DataProvider
	public Object[][]getData() throws EncryptedDocumentException, IOException{
		
		Object[][] data = eUtil.readDataFromExcelToDataProvider("DataProvider");
		return data;
		
	}

}
