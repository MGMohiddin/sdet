package com.crme.vtiger.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganisationPage {
	
	@FindBy(name="accountname")
	private WebElement acntbtn;
	
	@FindBy(xpath="//input[@onclick='return copyAddressLeft(EditView)']")
	private WebElement shippingbtn;
	
	@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement billingbtn;
	
	@FindBy(name="ship_street")
	private WebElement addressbtn;

	@FindBy(id="ship_pobox")
	private WebElement pobtn;
	
	@FindBy(id="ship_city")
	private WebElement citybtn;
	
	@FindBy(id="ship_state")
	private WebElement statebtn;
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	@FindBy(id="ship_code")
	private WebElement pcodebtn;
	
	@FindBy(id="ship_country")
	private WebElement countrybtn;
	
	
	@FindBy(xpath="//[@class='lvtHeaderText']")
	private WebElement headerbtn;
	
	@FindBy(name="button")
	private WebElement savebtn;

	public WebElement getHeaderbtn() {
		return headerbtn;
	}

	public WebElement getAcntbtn() {
		return acntbtn;
	}

	public WebElement getShippingbtn() {
		return shippingbtn;
	}

	public WebElement getBillingbtn() {
		return billingbtn;
	}

	public WebElement getAddressbtn() {
		return addressbtn;
	}

	public WebElement getPobtn() {
		return pobtn;
	}

	public WebElement getCitybtn() {
		return citybtn;
	}

	public WebElement getStatebtn() {
		return statebtn;
	}

	public WebElement getPcodebtn() {
		return pcodebtn;
	}

	public WebElement getCountrybtn() {
		return countrybtn;
	}

	
	public CreateNewOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterdetails(String address,String poBox,String city,String state,String posCode,String country) {
		addressbtn.sendKeys(address);
		pobtn.sendKeys(poBox);
		citybtn.sendKeys(city);
		statebtn.sendKeys(state);
		pcodebtn.sendKeys(posCode);
		countrybtn.sendKeys(country);
	}
}
