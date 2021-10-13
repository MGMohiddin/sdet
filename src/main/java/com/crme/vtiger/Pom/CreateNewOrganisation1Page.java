package com.crme.vtiger.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganisation1Page {
	
	@FindBy(name="accountname")
	private WebElement orgbtn;
	
	
	@FindBy(name="button")
	private WebElement savebtn;


	public WebElement getAcntbtn() {
		return orgbtn;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}

	
	public CreateNewOrganisation1Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void organisationbutton(String orgname) {
		orgbtn.sendKeys(orgname);
		savebtn.click();
	}
}
