package vtigerPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.Objectrepository.ContactPage;
import vtiger.Objectrepository.LoginPage;

public class HomePage {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginApp("admin", "admin");

		vtiger.Objectrepository.HomePage hp = new vtiger.Objectrepository.HomePage(driver);
		hp.calenderPage();
		hp.homePage();
		
	
	}
	
}
