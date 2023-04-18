package com.Vtiger_Practice;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	//Step1:load the file into java readable format using file input stream.
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\VtigerOrg.xlsx");
		
		//step2:create the workbook.
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3:get the sheet.
		
		Sheet sheet = wb.getSheet("Organization");
		
		//step4:get the row.
		Row row = sheet.getRow(1);
		
		//step5:get the column.
		
		Cell cell = row.createCell(7);
		
		//step6:write the data
		
		cell.setCellValue("Sandeep");
		
		//open the using file output stream.
		
		FileOutputStream fos=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\VtigerOrg.xlsx");
		wb.write(fos);
		System.out.println("data added");
		wb.close();
	}

}
