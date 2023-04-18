package com.vtiger.genericUtilties;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author User
 *
 */

public class WebdriverUtilities {
	/**
	 * 
	 * @param driver
	 */
	public void windowMaximize(WebDriver driver) {
		
		driver.manage().window().maximize();//action	
	}
	
	/**
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		
		driver.manage().window().minimize();
	}
	
	/**
	 * this method will wait for 20 seconds 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	/**
	 * this method will wait until the particular web element is visible
	 * @param driver
	 * @param element
	 */
	public void  waitForElementToBeVisible(WebDriver driver ,WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method will wait until the particular web element to be clickable.
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver ,WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method ill help you to handle the dropdown by using index
	 * @param element
	 * @param index
	 */
	public void handlingDropdown(WebElement element,int index) {
		
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * this method ill help you to handle the dropdown by using String value.
	 * @param element
	 * @param value
	 */
	public void handlingDropdown(WebElement element, String value) {
		
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * this method will help you to handle the dropdown by using String Text.
	 * @param Text
	 * @param element
	 */
public void handlingDropdown(String Text,WebElement element ) {
		
		Select select=new Select(element);
		select.selectByValue(Text);
	}
	/**
	 * this method will help you to perform mouse over action on a web element.
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method will perform the right click action on perticuler element.
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.contextClick(element).perform();;
		
	}
	/**
	 * this method will perform the right click anywhere in the page.
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * this method will perform the double click action on particular element.
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();;
		
	}
	/**
	 * this method will perform the double click anywhere in the page.
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act= new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method helps to perform drag and drop from one element to another.
	 * @param driver
	 * @param srcelement
	 * @param dstelement
	 */
	public void dragAndDrop(WebDriver driver,WebElement srcelement,WebElement dstelement) {
		Actions act=new Actions(driver);
		act.dragAndDrop(srcelement, dstelement);
	}
	/**
	 * this method press the enter key
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		
	}
	/**
	 * this method press the release key
	 * @throws AWTException
	 */
	public void releseEnterKey() throws AWTException {
		Robot robot=new Robot();
		robot.keyRelease(KeyEvent.VK_ENTER);
	
	}
	/**
	 * this method will handle frame with index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
	}
	/**
	 * this method will handle frame with string name or Id.
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * this method will handle frame with web element.
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * this method will switch to the parent frame.
	 * @param driver
	 * @param element
	 */
	public void handleParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to the default content frame.
	 * @param driver
	 * @param element
	 */
	public void handleDefaultContentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * this method will accept the alert popUp.
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method will dismiss the alert popUp.
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method will get the text of alert popUp.
	 * @param driver
	 */
	public String getAlerText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	/**
	 * this method helps you take screenshots using screenshot name.
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShots(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("\\ScreenShots\\"+screenshotName+".png");
		FileUtils.copyFile(src, dst);// from common io
		
		return dst.getAbsolutePath();// Used when you content report
	}
	
	/**
	 * this method helps to get 
	 * @param driver
	 * @param partialWindowTitle
	 */
	//step1: get all the windows using get windowhandles method
	public void switchWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> winId = driver.getWindowHandles();
		
		//step2:use for each loop to navigate each window.
		for(String win:winId) {
			//step2:get the title of each window
			String currentTitle = driver.switchTo().window(win).getTitle();
			
			// step4:call the window using partial window title
			if(currentTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * this method will scroll Randomly down.
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
	}
	/**
	 * this method scrollDown until the element to be find.
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	
	
}
	
	
	
