package com.Vtiger_Practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		//step1:load the file in java readable format using file input stream.
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2:create the object of properties  using java.util.
		
		Properties pObj= new Properties();
		
		
		//step3:load file input stream into properties.
				
		pObj.load(fis);	
		
		//step4:using the key read the value.
		
		String Browser = pObj.getProperty("browser");
		System.out.println(Browser);
		
		String URl = pObj.getProperty("url");
		System.out.println(URl);
		

		String USERNAME = pObj.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD = pObj.getProperty("password");
		System.out.println(PASSWORD);
		
		
	}


}
