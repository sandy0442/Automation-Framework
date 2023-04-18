package vtiger.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//rule1:creating the pom class
public class LoginPage {
	
	//rule2:locate the web Element with annotations.
	@FindBy(name="user_name")
	private  WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submittBtn;
	
	//rule3:initialize the web Element with constructor.
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	//rule4:use the getters to call the methods.
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmittBtn() {
		return submittBtn;
	}
	
	//rule5:create business library-generic methods
	public void LoginApp(String Username, String Password) {
		userNameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		submittBtn.click();
	}

	
	

}
