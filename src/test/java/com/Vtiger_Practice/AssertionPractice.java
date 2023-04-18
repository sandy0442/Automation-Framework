package com.Vtiger_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void practice() {
		
		System.out.println("step1");
		Assert.assertEquals(true,true);
		
		System.out.println("step2");
		Assert.assertTrue(true);// hard assert
		System.out.println("step3");
		System.out.println("step4");
	}
	
	@Test
	public void practice1() {
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(true,true);//fail
		
		System.out.println("step1-Passed");
		sa.assertEquals("A","A");//soft assert 
		
		System.out.println("step2-Passed");
		Assert.assertTrue(true);
		System.out.println("step3-Passed");
		System.out.println("step4-Passed");
		sa.assertAll();
	}

}
