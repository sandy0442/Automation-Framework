package vtiger.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtilties.WebdriverUtilities;

public class Organizationpage extends WebdriverUtilities{
	
	//step1:declaration 
	
	@FindBy(linkText="Organizations")
	private WebElement OrglinkBtn;
	

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrganization;
	

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrganizationName;
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement OrgSaveBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement LogOutBtn;
	
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutlink;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropDown;
	
	

	//Initialization
	public Organizationpage(WebDriver driver) {
		PageFactory.initElements(driver, this );
	}
	
	
	//Utilization
	
	


	public WebElement getOrglinkBtn() {
		return OrglinkBtn;
	}


	public WebElement getLogOutBtn() {
		return LogOutBtn;
	}


	public WebElement getSignOutlink() {
		return signOutlink;
	}


	public WebElement getCreateNewOrganization() {
		return createNewOrganization;
	}


	public WebElement getOrganizationName() {
		return OrganizationName;
	}


	public WebElement getOrgSaveBtn() {
		return OrgSaveBtn;
	}
	
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	
	
	//Business Libraries
	
	public void orgLink() {
		OrglinkBtn.click();
	}
	
	public void createOrg(String OrgName) {
		createNewOrganization.click();
		OrganizationName.sendKeys(OrgName );
		OrgSaveBtn.click();
	}
	
	public void createORgWithIndustry(String OrgName,String Industry) {
		createNewOrganization.click();
		OrganizationName.sendKeys(OrgName );
		industryDropDown.click();
		OrgSaveBtn.click();
		
		
	}
	
	public void SignOut(WebDriver driver) {
		
		mouseOverAction(driver, LogOutBtn);
		signOutlink.click();
	
		
	}
	
	
	
	
	
	

}
