package com.vtiger.genericUtilties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class consist methods related to Excel sheet
 * @author User
 *
 */

public class ExcelUtility {
	/**
	 * this method helps us to read data from sheet
	 * @param sheetname
	 * @param rowNo
	 * @param celNo
	 * @param Value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetname,int rowNo,int celNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(IcontactUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(celNo,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
		wb.close();
		return value;
		
	}
	
	/**
	 * 
	 * @param sheetname
	 * @param rowNo
	 * @param celNo
	 * @param Value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetname,int rowNo,int celNo,String Value) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(IcontactUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.createRow(rowNo);
		Cell cl = rw.createCell(celNo);
		cl.setCellValue(Value);
		
		FileOutputStream fos=new FileOutputStream(IcontactUtility.excelfilepath);
		wb.write(fos);
		System.out.println("data added");
		wb.close();
	
	
	}	
	/**
	 * This method read data from excel sheet and give it to Dataprovider
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][]readDataFromExcelToDataProvider(String sheetname) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis= new FileInputStream(IcontactUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(lastRow).getLastCellNum();
		
		Object [][] data=new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) {
			
			for(int j=0;j<lastCell;j++) {
				
				data[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
		
	}

}
