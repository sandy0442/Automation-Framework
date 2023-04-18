package com.Vtiger_Practice;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.vtiger.genericUtilties.IcontactUtility;

public class PracticeTest  {
	
	@Test
	public void practiceTest ()throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(IcontactUtility.excelfilepath);
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheetName = wb.getSheet("Organization");
		
		Row row = sheetName.getRow(7);
		
		Cell cell = row.getCell(3);
		
		String value = cell.getStringCellValue();
		
		System.out.println(value);
	}

}
