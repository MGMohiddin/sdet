package testScript1;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crme.vtiger.Genericutils.BaseClass;
import com.crme.vtiger.Pom.CreateNewOrganisationPage;
import com.crme.vtiger.Pom.HomePage;
import com.crme.vtiger.Pom.OrganisationPage;

public class CreateOrganisation extends BaseClass{
	
	@Test(groups= {"smokeTest"})
	public void TC_16() throws Throwable {
	
	HomePage hp=new HomePage(driver);
	hp.getOrgbtn().click();
	
	OrganisationPage op=new OrganisationPage(driver);
	//op.organisationbutton();
	op.getOrganbtn().click();
	
	CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
	WebElement copyshippingbtn = cnop.getShippingbtn();
	
	if(copyshippingbtn.isEnabled()) {
		System.out.println("Pass: is enabled");
	}
	else
	{
		System.out.println("Fail: is not enabled");
	}
	
	hp.getAdmbtn().click();
	}
}
