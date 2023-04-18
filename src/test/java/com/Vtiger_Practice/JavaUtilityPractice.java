package com.Vtiger_Practice;

import com.vtiger.genericUtilties.JavaUtility;

public class JavaUtilityPractice {

	public static void main(String[] args) {
		JavaUtility jUtil=new JavaUtility();
		String date = jUtil.systemDate();
		System.out.println(date);
		//jUtil.systemDateINFormat();
		String value = jUtil.SystemDateInFormat();
		System.out.println(value);
	}
}
