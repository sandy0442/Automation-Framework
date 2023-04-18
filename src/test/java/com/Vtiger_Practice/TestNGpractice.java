package com.Vtiger_Practice;



import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGpractice {
	
	@Test(priority = 1,invocationCount = -1)
	public void practiceTest() {
		System.out.println("welcome to testNG");
	}
	
	@Test(priority = 2,invocationCount = 1)
	public void userCreate() {
		System.out.println("hello user");//failed
		Assert.fail();
	}
	
	@Test(dependsOnMethods = "userCreate")
	public void userDeleted() {
		System.out.println("user deleted");
	}
	
	@Test(enabled = false)
	public void userModified() {
		System.out.println("user modified");
	}

}
