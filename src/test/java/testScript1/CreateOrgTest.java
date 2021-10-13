package testScript1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crme.vtiger.Genericutils.ExcelUtility;
import com.crme.vtiger.Genericutils.FileUtility;
import com.crme.vtiger.Genericutils.JavaUtility;
import com.crme.vtiger.Genericutils.WebDriverUtility;
import com.crme.vtiger.Pom.CreateNewOrganisation1Page;
import com.crme.vtiger.Pom.HomePage;
import com.crme.vtiger.Pom.OrgInfoPage;
import com.crme.vtiger.Pom.OrganisationPage;
import com.crme.vtiger.Pom.VTigerLoginPage;

public class CreateOrgTest {
	public static void main(String[] args) throws Throwable {
		
		/*create Object*/
		FileUtility fLib=new FileUtility();
        ExcelUtility eLib=new ExcelUtility();
        JavaUtility jLib=new JavaUtility();
        WebDriverUtility wLib=new WebDriverUtility();
        WebDriver driver=null;

		/*read common data*/
	  String Browser = fLib.getPropertyKeyValue("browser");
	  String Url = fLib.getPropertyKeyValue("url");
	  String Username = fLib.getPropertyKeyValue("us");
	  String Password = fLib.getPropertyKeyValue("ps");
	  /*read test data */
	  String orgName = eLib.getExcelData("Sheet1", 1, 1)+ "_"+jLib.getRandomData();
	  
	  /* Step1: Launch the Browser*/
	  if(Browser.equals("Chrome")) {
		driver=new ChromeDriver();
	  }
	  else if(Browser.equals("Firefox")) {
		  driver=new FirefoxDriver();
	  }
	  else {
		  driver=new ChromeDriver();
	  }
	  driver.manage().window().maximize();
	  /* Login to app*/
	  driver.get(Url);
	  VTigerLoginPage vtlp=new VTigerLoginPage(driver);
	  vtlp.loginToApp(Username, Password);
	  vtlp.getLgnbtn().click();
	  
	  /*step3:navigate to org*/
	  HomePage hp=new HomePage(driver);
	  hp.getOrgbtn().click();
	  
	  /*Step4: Navigate to create org Page*/
	  OrganisationPage op=new OrganisationPage(driver);
	  op.getOrganbtn().click();
	  
	  /*Step5:Create org*/
	  
	  CreateNewOrganisation1Page cnop=new CreateNewOrganisation1Page(driver);
	  cnop.organisationbutton(orgName);
	  
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
	  hp.getSignotbtn().click();
	  
	  /*Step 8:close the browser */
	  driver.close();
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	}


	
	
}
