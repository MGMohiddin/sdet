package com.crme.vtiger.Genericutils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	/**
	 * @author MD G MOHIDDIN
	 */
		/**
		 * this method wait for 20 sec for page loading
		 * @param driver
		 */
		public void waitUntilPageLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
	/**
	 * This method wait for the element to be visible
	 * @param driver
	 * @param element
	 */
		
		public void waitForElementVisibility(WebDriver driver, WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
	/**
	 * This method wait element to be clicked
	 * @param element
	 * @param throwable 
	 * @throws InterruptedException 
	 */
		
		public void waitAndClick(WebElement element) throws InterruptedException {
			int count=0;
			while(count<40) {
				try {
					element.click();
					break;	
				}
				catch(Throwable e) {
					Thread.sleep(1000);
					count++;
				}
			}
		}
	/**
	 * This methods enables user to handle dropdown using index
	 * @param elemnt
	 * @param option
	 */	
	public void selectOption(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This methods enables user to handle dropdown using visible text
	 * @param elemnt
	 * @param option
	 */	

	public void selectOption(WebElement element, String option) {
		Select select=new Select(element);
		select.selectByValue(option);
	}

	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method will perform right click
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
		
	/**
	 * This method helps to switch from one Window to another
	 * @param driver
	 * @param partialWInTitle	
	 */
		public void switchToWindow(WebDriver driver, String partialWinTitle) {
			Set<String> window = driver.getWindowHandles();
			Iterator<String> it = window.iterator();
			while(it.hasNext()) {
				String winId = it.next();
				String title = driver.switchTo().window(winId).getTitle();
				if(title.contains(partialWinTitle)) {
					break;
				}
			}
		}
	/**
	 * Accept alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * cancel alert
	 * @param driver
	 */

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to scrolling action in webpage
	 * @param driver
	 * @param element 
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);	
	}
	 public void switchFrame(WebDriver driver,int index) {
		 driver.switchTo().frame(index);	 
	 }
		
	 public void switchFrame(WebDriver driver,WebElement element) {
		 driver.switchTo().frame(element);	 
	 }
	 
	 public void switchFrame(WebDriver driver,String idOrName) {
		 driver.switchTo().frame(idOrName);	 
	 }
	 
	 public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		 
		String screenshotPath = "./screenshot/"+screenshotName+JavaUtility.getCurrentDate()+".PNG";
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(screenshotPath);
		Files.copy(src, dest);
		return screenshotPath; 
	 }
	 
	 public void pressEntryKey() throws Throwable {
		 Robot rc=new Robot();
		 rc.keyPress(KeyEvent.VK_ENTER);
		 rc.keyRelease(KeyEvent.VK_ENTER);
	 }	
		
	}

