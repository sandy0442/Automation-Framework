package com.vtiger.genericUtilties;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author User
 *
 */

public class JavaUtility {
	/**
	 * this method return random number after every run.
	 * @return
	 */
	public int getrandomNumber() {
		
		Random r=new Random();
		return r.nextInt(1000);
		
	}
	/**
	 * this method return the system date.
	 * @return
	 */
	public String systemDate() {
		Date d = new Date();
		return d.toString();
		
	}
	/**
	 * this method return the date in given format.
	 * @return
	 */
	/*public String systemDateINFormat() { //mistake is there at date level
		
		Date d=new Date();
		String[] drr = d.toString().split("  ");
		String month=drr[1];
		String date=drr[2];
		String year=drr[5];
		String time=drr[3].replace(":", "-");
		String dateValue=date+"-"+month+"-"+year+"-"+time;
		return dateValue;
	}*/
	/**
	 * 
	 * @return
	 */
	public String SystemDateInFormat() {
		
		Date date = new Date();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		
		String resultValue = dateFormat.format(date);
		return resultValue;
		
	}

}
