package com.crme.vtiger.Genericutils;
/**
 * @author MD G MOHIDDIN
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crme.vtiger.Pom.HomePage;
import com.crme.vtiger.Pom.VTigerLoginPage;

public class BaseClass {
	 public WebDriver driver;
     public	WebDriverUtility wLib=new WebDriverUtility();
	 public FileUtility fLib=new FileUtility();
	 public JavaUtility jLib=new JavaUtility();
	 public ExcelUtility eLib=new ExcelUtility();
	
	@BeforeSuite (groups= {"smokeTest","regression"})
	public void connectDB() {
		System.out.println("=========Db connection estlabished sucessfull======");
	}
	
	@BeforeClass(groups= {"smokeTest","regression"})
	public void launchBrowser() throws Throwable {
		
		/*read data from property file*/
		String BROWSER = fLib.getPropertyKeyValue("browser");	
		String URL = fLib.getPropertyKeyValue("url");
		
		if(BROWSER.equals("Chrome")) {
			driver=new ChromeDriver();
		  }
		  else if(BROWSER.equals("Firefox")) {
			  driver=new FirefoxDriver();
		  }
		  else
		  {
			  System.out.println("Invalid browser name");
		  }
		driver.manage().window().maximize();
		driver.get(URL);
		wLib.waitUntilPageLoad(driver);
		System.out.println("======== browser opened  successfull=======");
	}
		
	@BeforeMethod(groups= {"smokeTest","regression"})
	public void loginToApp() throws Throwable {
		
		/*read data from property file*/
	   String USERNAME = fLib.getPropertyKeyValue("us");
	   String PASSWORD = fLib.getPropertyKeyValue("ps");
	
	/* login to app*/
	VTigerLoginPage vtlp=new VTigerLoginPage(driver);
	vtlp.loginToApp(USERNAME, PASSWORD);
	System.out.println("========Login successfull=======");
	
	}
	
	@AfterMethod(groups= {"smokeTest","regression"})
	public void logoutOfApp() {
	 /*Signout of home page*/
		
		HomePage hp=new HomePage(driver);
		hp.getSignotbtn().click();
		System.out.println("=========logOut successfull========");
	}
	
	@AfterClass(groups= {"smokeTest","regression"})
	public void closeBrowser() {
		driver.close();
		System.out.println("======== browser closed  successfull=======");
	}
	
	@AfterSuite(groups= {"smokeTest","regression"})
	public void closeDB() {
		System.out.println("=========Db connection closed sucessfull======");
	}

}
