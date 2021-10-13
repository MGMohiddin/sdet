package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crme.vtiger.Genericutils.ExcelUtility;
import com.crme.vtiger.Genericutils.FileUtility;
import com.crme.vtiger.Genericutils.JavaUtility;
import com.crme.vtiger.Genericutils.WebDriverUtility;

public class TC_18CreateOrganisationWithShippingAddress {
	
	@Test
	public void createOrganisationWithShippingAddress() throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		FileUtility fis=new FileUtility();
		ExcelUtility exl=new ExcelUtility();	
		String browser = fis.getPropertyKeyValue("url");
		driver.get(browser);
		WebDriverUtility wsu=new WebDriverUtility();
		wsu.waitUntilPageLoad(driver);
		String username = fis.getPropertyKeyValue("us");
		driver.findElement(By.name("user_name")).sendKeys(username);
		String password = fis.getPropertyKeyValue("ps");
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		String oname = exl.getExcelData("Sheet1", 1, 1);
		String SAdd = exl.getExcelData("Sheet1", 1, 2);
	    String Spbox= exl.getExcelData("Sheet1", 1, 3);
	    String Scity = exl.getExcelData("Sheet1", 1, 4);
	    String Sstate = exl.getExcelData("Sheet1", 1, 5);
	    String Scde = exl.getExcelData("Sheet1", 1, 6);
	    String Scon = exl.getExcelData("Sheet1", 1, 7);
	    
		driver.findElement(By.name("accountname")).sendKeys(oname+JavaUtility.getRandomData());
		driver.findElement(By.name("ship_street")).sendKeys(SAdd);
		driver.findElement(By.id("ship_pobox")).sendKeys(Spbox);
		driver.findElement(By.id("ship_city")).sendKeys(Scity);
		driver.findElement(By.id("ship_state")).sendKeys(Sstate);
		driver.findElement(By.id("ship_code")).sendKeys(Scde);
		driver.findElement(By.id("ship_country")).sendKeys(Scon);
		//driver.findElement(By.name("cpy")).click();
		driver.findElement(By.name("button")).click();
		Thread.sleep(3000);
		WebElement ele3 = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		wsu.mouseHover(driver, ele3);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    String title = driver.getTitle();
	    System.out.println(title);
	    SoftAssert a= new SoftAssert();
	    a.assertEquals(true, "vtiger CRM 5 - Commercial Open Source CRM");
		driver.quit();
	 
	   
		
		
		
	}

}
