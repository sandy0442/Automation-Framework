package com.vtiger.genericUtilties;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	/**
	 * this method will read the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String ReadDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IcontactUtility.proprtyfilepath);
		Properties pObj=new Properties();
		pObj.load(fis);
	String value = pObj.getProperty(key);
		return value;
		
	}

}
