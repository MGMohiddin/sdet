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

public class TC_20CreateOrganisationWithBillingAddress {
	@Test
	public void createOrganisationWithBillingAddress() throws Throwable {
		
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
		String Orgname = exl.getExcelData("Sheet1", 2, 1);
		String Badd= exl.getExcelData("Sheet1", 2, 2);
		String Bpo = exl.getExcelData("Sheet1", 2, 3);
		String Bcity = exl.getExcelData("Sheet1", 2, 4);
		String Bstat = exl.getExcelData("Sheet1", 2, 5);
		String Bpc = exl.getExcelData("Sheet1", 2, 6);
		String Bcon = exl.getExcelData("Sheet1", 2, 7);
		driver.findElement(By.name("accountname")).sendKeys(Orgname+JavaUtility.getRandomData());
		driver.findElement(By.name("bill_street")).sendKeys(Badd);
		driver.findElement(By.name("bill_pobox")).sendKeys(Bpo);
		driver.findElement(By.id("bill_city")).sendKeys(Bcity);
		driver.findElement(By.id("bill_state")).sendKeys(Bstat);
		driver.findElement(By.id("bill_code")).sendKeys(Bpc);
		driver.findElement(By.id("bill_country")).sendKeys(Bcon);
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("//input[@onClick='return copyAddressLeft(EditView)']")).click();
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
