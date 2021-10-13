package com.crme.vtiger.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VTigerLoginPage {
	
	@FindBy(name="user_name")
	private WebElement namebtn;
	
	@FindBy(name="user_password")
	private WebElement pswdbtn;
	
	@FindBy(id="submitButton")
	private WebElement lgnbtn;
	
	public VTigerLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getNamebtn() {
		return namebtn;
	}

	public WebElement getPswdbtn() {
		return pswdbtn;
	}
	
	public WebElement getLgnbtn() {
		return lgnbtn;
	}
	
	public void loginToApp(String userName, String password) {
		namebtn.sendKeys(userName);
		pswdbtn.sendKeys(password);
		lgnbtn.click();
	}
	
}
