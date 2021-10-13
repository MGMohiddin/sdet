package testScript1;

import org.testng.annotations.Test;

import com.crme.vtiger.Genericutils.BaseClass;
import com.crme.vtiger.Pom.CreateNewOrganisationPage;
import com.crme.vtiger.Pom.HomePage;
import com.crme.vtiger.Pom.OrgInfoPage;
import com.crme.vtiger.Pom.OrganisationPage;

public class CreateorgWithShippingAddress extends BaseClass {
	
	@Test(groups= {"regression"})
	public void Tc_18() throws Throwable {
	  /*read test data */
	 String orgName = eLib.getExcelData("Sheet1", 1, 1)+ "_"+jLib.getRandomData();
	    String addName = eLib.getExcelData("Sheet1", 1, 2);
	    String poBox= eLib.getExcelData("Sheet1", 1, 3);
	    String cityName = eLib.getExcelData("Sheet1", 1, 4);
	    String stateName = eLib.getExcelData("Sheet1", 1, 5);
	    String poCode = eLib.getExcelData("Sheet1", 1, 6);
	    String country = eLib.getExcelData("Sheet1", 1, 7);
	  
	  /*step3:navigate to org*/
	  HomePage hp=new HomePage(driver);
	  hp.getOrgbtn().click();
	  
	  /*Step4: Navigate to create org Page*/
	  OrganisationPage op=new OrganisationPage(driver);
	  op.getOrganbtn().click();
	  
	  /*Step5:Create org*/
		CreateNewOrganisationPage cnp=new CreateNewOrganisationPage(driver);
		cnp.enterdetails(addName, poBox, cityName, stateName, poCode, country);
		cnp.getAcntbtn().sendKeys(orgName);
		cnp.getSavebtn().click();
		
		  /*Step 6:Verify */
		 OrgInfoPage oip=new OrgInfoPage(driver);
	      wLib.waitForElementVisibility(driver, oip.getOrginfobtn());
		  String actlMsg = oip.getOrginfobtn().getText();
		  if(actlMsg.contains(orgName)) {
			  System.out.println("Org is created sucessfully==> Pass");
			  
		  }
		  else {
			  System.out.println("Org is not created sucessfully==> Fail");
		  }
		
		 /*Step 7: logout */
		 hp.getAdmbtn().click();	
	}

}
