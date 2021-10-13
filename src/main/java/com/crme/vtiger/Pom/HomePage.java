package com.crme.vtiger.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage

{
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orgbtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement admbtn;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signotbtn;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrgbtn() {
		return orgbtn;
	}

	public WebElement getAdmbtn() {
		return admbtn;
	}
	
	public WebElement getSignotbtn() {
		return signotbtn;
	}

	public void signout() {
		Actions a=new Actions(driver);
		a.moveToElement(admbtn).perform();
		signotbtn.click();
	}
	
}
