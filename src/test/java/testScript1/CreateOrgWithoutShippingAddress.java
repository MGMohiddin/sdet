package testScript1;

import org.testng.annotations.Test;

import com.crme.vtiger.Genericutils.BaseClass;
import com.crme.vtiger.Pom.CreateNewOrgPage1;
import com.crme.vtiger.Pom.HomePage;
import com.crme.vtiger.Pom.OrgInfoPage;
import com.crme.vtiger.Pom.OrganisationPage;

public class CreateOrgWithoutShippingAddress extends BaseClass {

	
	@Test(groups= {"regression"})
	public void createOrgWithoutShippingAddress() throws Throwable {
		  /*read test data */
		    String orgName = eLib.getExcelData("Sheet1", 2, 1)+ "_"+jLib.getRandomData();
		    String addName = eLib.getExcelData("Sheet1", 2, 2);
		    String poBox = eLib.getExcelData("Sheet1", 2, 3);
		    String cityName = eLib.getExcelData("Sheet1", 2, 4);
		    String stateName = eLib.getExcelData("Sheet1", 2, 5);
		    String pCode = eLib.getExcelData("Sheet1", 2, 6);
		    String bCountnry = eLib.getExcelData("Sheet1", 2, 7);
		   
		  /*step3:navigate to org*/
		  HomePage hp=new HomePage(driver);
		  hp.getOrgbtn().click();
		  
		  /*Step4: Navigate to create org Page*/
		  OrganisationPage op=new OrganisationPage(driver);
		  op.getOrganbtn().click();
		  
		  /*Step 5:Create Organisation Page*/
		  
		  CreateNewOrgPage1 cnop=new  CreateNewOrgPage1(driver);
		  cnop.enterBdetails(addName, poBox, cityName, stateName, pCode, bCountnry);
		  cnop.getBillingbtn().click();
		  cnop.getOrgnamebtn().sendKeys(orgName);
		  cnop.getSavebtn().click();
		
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
		  
		   /*Step 7:logout */
		   hp.getAdmbtn().click();
		   
		}
	}

