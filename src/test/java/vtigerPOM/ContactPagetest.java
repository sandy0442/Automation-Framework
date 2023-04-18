package vtigerPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.genericUtilties.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.Objectrepository.ContactPage;
import vtiger.Objectrepository.ContactPageInfo;
import vtiger.Objectrepository.LoginPage;
import vtiger.Objectrepository.Organizationpage;

public class ContactPagetest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		JavaUtility jUtil=new JavaUtility();
		int value = jUtil.getrandomNumber();
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginApp("admin", "admin");
		
		Organizationpage op=new Organizationpage(driver);
		op.orgLink();
		op.createOrg("cpt55");
		
		ContactPage cp=new ContactPage(driver);
		cp.contactCreate();
		
		ContactPageInfo cnp=new ContactPageInfo(driver);
		cnp.createContactInfo(driver, "patil", "cpt55");

	}

}
