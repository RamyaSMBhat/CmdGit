package com.crm.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.crm.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	@BeforeMethod
	public void login() throws IOException
	{
		FileLib f=new FileLib();
		String url = f.getPropertyData("url");
		String un = f.getPropertyData("un");
		String pwd = f.getPropertyData("pwd");
		
		driver.get(url);	
		LoginPage l=new LoginPage(driver);
		driver.findElement(By.id("userName")).sendKeys(un);
		driver.findElement(By.id("passWord")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
	}
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//a[contains(text(),'Logout ')]")).click();
	}
}
