package com.Vtiger_Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.genericUtilties.ExcelUtility;

public class DataProviderPractice {
	
	ExcelUtility eUtil =new ExcelUtility();
	
	@Test(dataProvider = "getdata")
	public void addtoCart(String name,int qty,int price,String colour,boolean IsAvailable) {
		
		System.out.println("------"+name+"---"+qty+"----"+price+"----"+colour+"---"+IsAvailable+"--");
		
		
		
	}
	
	@Test(dataProvider = "giveData")
	public void DumpToCart(String name,int qty,int price,String colour) {
		
		System.out.println("------"+name+"---"+qty+"----"+price+"----"+colour+"---");
		
	}
	
	/*@Test(dataProvider = "getdata1")
	public void data() {
		
		String[] data2 = null;
		System.out.println(data2);
	}*/
		
	
	@DataProvider
	public Object[][] getdata(){
		
		Object[][] data=new Object[2][5];
		
		data[0][0]="samsumng";
		data[0][1]=12;
		data[0][2]=1000;
		data[0][3]="black";
		data[0][4]=true;
		
		data[1][0]="Nokia";
		data[1][1]=15;
		data[1][2]=10000;
		data[1][3]="white";
		data[1][4]=true;
		return data;
	}
		
		@DataProvider
		public Object[][] giveData(){
		
			Object[][] data1=new Object[2][4];
			
			data1[0][0]="Lenevo";
			data1[0][1]=13;
			data1[0][2]=100000;
			data1[0][3]="Silver";
			
			data1[1][0]="Hp";
			data1[1][1]=15;
			data1[1][2]=20000;
			data1[1][3]="white";
			
			return data1;
			
			
		}
		
		//@DataProvider
		//public Object[][]getdata1() throws EncryptedDocumentException, IOException{
			
		      //Object[][] data2 = eUtil.readDataFromExcelToDataProvider("DataProvider");
			//return data2;
		//}
		
		
		
	}


