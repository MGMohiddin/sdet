package com.crme.vtiger.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgPage1 {
	
	@FindBy(name="accountname")
	private WebElement orgnamebtn;
	
	@FindBy(name="bill_street")
	private WebElement addressbtn;
	
	@FindBy(id="bill_pobox")
	private WebElement poboxbtn;
	
	@FindBy(id="bill_city")
	private WebElement citybtn;

	@FindBy(id="bill_state")
	private WebElement statebtn;
	
	@FindBy(id="bill_code")
	private WebElement pocodebtn;
	
	@FindBy(id="bill_country")
	private WebElement countrybtn;
	
	@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement billingbtn;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	public WebElement getOrgnamebtn() {
		return orgnamebtn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getAddressbtn() {
		return addressbtn;
	}

	public WebElement getPoboxbtn() {
		return poboxbtn;
	}

	public WebElement getCitybtn() {
		return citybtn;
	}

	public WebElement getStatebtn() {
		return statebtn;
	}

	public WebElement getPocodebtn() {
		return pocodebtn;
	}

	public WebElement getCountrybtn() {
		return countrybtn;
	}

	public WebElement getBillingbtn() {
		return billingbtn;
	}

	public CreateNewOrgPage1(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}
	
	public void enterBdetails(String baddress,String bpobox,String bcity,String bstate,String bpcode,String bcountry) {
	addressbtn.sendKeys(baddress);
	poboxbtn.sendKeys(bpobox);
	citybtn.sendKeys(bcity);
	statebtn.sendKeys(bstate);
	pocodebtn.sendKeys(bpcode);
	countrybtn.sendKeys(bcountry);
    }
	
	
}
