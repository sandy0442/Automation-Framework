package vtiger.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createcontactLink;
	
	//Initialization
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCreatecontactLink() {
		return createcontactLink;
	}
	
	//Business libraries 
	
	public void contactCreate() {
		
		contactLink.click();
		createcontactLink.click();
	}
	
	
	

}
