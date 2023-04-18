package com.Vtiger_Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	
	
	@Test
	public void test() {
		String BROWSER = System.getProperty("browser");//run time parameter
		System.out.println(BROWSER);
	}

}
