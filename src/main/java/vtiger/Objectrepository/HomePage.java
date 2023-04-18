package vtiger.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtilties.WebdriverUtilities;

public class HomePage extends WebdriverUtilities{
	
	
	
	//step1:find the element and declare the element
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homebtn;
	
	@FindBy(linkText="Calendar")
	private WebElement calenderlink;
	
	@FindBy(linkText="Leads")
	private WebElement Leadslink;
	
	@FindBy(linkText="Organizations")
	private WebElement Organizationslink;
	
	@FindBy(linkText="Contacts")
	private WebElement Contactslink;
	
	@FindBy(linkText="Opportunities")
	private WebElement Opportunitieslink;
	
	@FindBy(linkText="Products")
	private WebElement Productslink;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement TroubleTicketslink;
	
	@FindBy(linkText="Email")
	private WebElement Emaillink;
	
	@FindBy(linkText="Documents")
	private WebElement Documentslink;
	
	@FindBy(linkText="Dashboard")
	private WebElement Dashboardlink;
	

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement LogOutBtn;
	
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutlink;
	
	//initialization using constructor
	
	public HomePage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
			
	}
	
	//Utilization using getters
	public WebElement getHomebtn() {
		return homebtn;
	}

	public WebElement getCalenderlink() {
		return calenderlink;
	}

	public WebElement getLeadslink() {
		return Leadslink;
	}

	public WebElement getOrganizationslink() {
		return Organizationslink;
	}

	public WebElement getContactslink() {
		return Contactslink;
	}

	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}

	public WebElement getProductslink() {
		return Productslink;
	}

	public WebElement getTroubleTicketslink() {
		return TroubleTicketslink;
	}

	public WebElement getEmaillink() {
		return Emaillink;
	}

	public WebElement getDocumentslink() {
		return Documentslink;
	}

	public WebElement getDashboardlink() {
		return Dashboardlink;
	}
	
	public WebElement getLogOutBtn() {
		return LogOutBtn;
	}

	public WebElement getSignOutlink() {
		return signOutlink;
	}

	
	
	//Business libraries-generic methods

	public void calenderPage() {
		calenderlink.click();
		
	}
	
	public void organizationPage() {
		Organizationslink.click();
		
	}
	
	public void contactsPage() {
		Contactslink.click();
		
	}
	
	public void homePage() {
		homebtn.click();
		
	}
	
public void SignOut(WebDriver driver) {
		
		mouseOverAction(driver, LogOutBtn);
		signOutlink.click();
	
	

	
	
	
	
	
}
}
