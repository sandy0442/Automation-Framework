package vtigerPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.vtiger.genericUtilties.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.Objectrepository.ContactPage;
import vtiger.Objectrepository.LoginPage;
import vtiger.Objectrepository.Organizationpage;

public class OrganizationpageTest extends JavaUtility {
	
	public static void main(String[] args)throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		
		JavaUtility jUtil=new JavaUtility();
		int value = jUtil.getrandomNumber();
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginApp("admin", "admin");
		
		Organizationpage op =new Organizationpage(driver);
		op.orgLink();
		op.createOrg("ccs"+value);
		
		ContactPage cp=new ContactPage(driver);
		cp.contactCreate();
		Thread.sleep(2000);
		//og.SignOut(driver);

	}

}
