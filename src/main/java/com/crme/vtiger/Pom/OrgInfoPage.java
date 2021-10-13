package com.crme.vtiger.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Orginfobtn;

	public WebElement getOrginfobtn() {
		return Orginfobtn;
	}
	
        public OrgInfoPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
	
}
