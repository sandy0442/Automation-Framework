package vtiger.Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtilties.WebdriverUtilities;

public class ContactPageInfo extends WebdriverUtilities {
	
	//declaration
	
	@FindBy(name="lastname")
	private WebElement lastnameFld;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orglookUpIcon;
	
	@FindBy(name="search_text")
	private WebElement childwindowsearchtextField;
	
	@FindBy(name="search")
	private WebElement childwindowsearchbtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initilization
	
	public ContactPageInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	
	public WebElement getLastnameFld() {
		return lastnameFld;
	}

	public WebElement getChildwindowsearchtextField() {
		return childwindowsearchtextField;
	}


	public WebElement getChildwindowsearchbtn() {
		return childwindowsearchbtn;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public void setSaveBtn(WebElement saveBtn) {
		this.saveBtn = saveBtn;
	}


	public WebElement getOrglookUpIcon() {
		return orglookUpIcon;
	}
	
	//Business Libraries
	public void createContactInfo(WebDriver driver,String lastname,String OrgName) {
		lastnameFld.sendKeys(lastname);
		orglookUpIcon.click();
		switchWindow(driver, "Accounts");
		childwindowsearchtextField.sendKeys(OrgName);
		childwindowsearchbtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchWindow(driver, "Contacts");
		saveBtn.click();
		
	}
	

}
