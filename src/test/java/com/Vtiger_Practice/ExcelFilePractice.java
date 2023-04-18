package com.Vtiger_Practice;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelFilePractice {
	/**
	 * 
	 * @param args
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step1:load the file in java readable format.
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\VtigerOrg.xlsx");
		
		//step2:create a workbook.
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3:get control over the sheet.
		
		Sheet sh = wb.getSheet("Organization");
		
		//step4:get control over the row.
		
		Row row = sh.getRow(1);
		
		//step5:get control over the cell.
		
		Cell cell = row.getCell(2);
		Cell cl = row.getCell(1);
		
		//step6:read the data inside the cell.
		
		String value = cell.getStringCellValue();
		System.out.println(value);
		
		String value1 = cl.getStringCellValue();
		System.out.println(value1);
		
	}

}
