package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crme.vtiger.Genericutils.FileUtility;
import com.crme.vtiger.Genericutils.WebDriverUtility;

public class TC_17CreateOrganisationCopyBillingAddressEnabledOrNot {
	
	@Test
     public void CreateOrganisationCopyBillingAddressEnabledOrNot() throws Throwable {	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		FileUtility fis=new FileUtility();
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
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']"));
		if(ele1.isEnabled()) {
			System.out.println("pass: is enabled");		
		}
		else
		{
			System.out.println("Fail:is not enabled");
		}
		WebElement ele2 = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		wsu.mouseHover(driver, ele2);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    String title = driver.getTitle();
	    System.out.println(title);
	    SoftAssert a= new SoftAssert();
	    a.assertEquals(true, "vtiger CRM 5 - Commercial Open Source CRM");
		driver.quit();
		
		
		
		
	}

}
