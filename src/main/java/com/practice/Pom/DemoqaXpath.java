package com.practice.Pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DemoqaXpath {
	
	@Test
	public void demoqaXpath() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/tool-tips");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.id("toolTipButton"));
		
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	 //   Thread.sleep(3000);
        String  str= driver.findElement(By.xpath("//div[text()='You hovered over the Button']")).getText();
		driver.findElement(By.id("toolTipTextField")).sendKeys(str);
		System.out.println(str);
		driver.close();
	
		
		}

}
