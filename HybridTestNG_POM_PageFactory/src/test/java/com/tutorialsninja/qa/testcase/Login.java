package com.tutorialsninja.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;
import com.tutorialsninja.qa.utils.Utilities;





public class Login extends Base {
	
	public Login() {
		
		super();
		
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		//Calling browser initialize method from base class
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		//Click on MyAccount Tab
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyLoginWithValidCredentials() {
		
		
		
		
		//Email Address Text field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		
		//Password Text Field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		
		//Click on Login Button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		
		
		
	}
	
	@Test(priority=2)
	public void verifyLoginwithInvalidCredentials() {
		
				
		//Email Address Text field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
				
		//Password Text Field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidPassword"));
				
		//Click on Login Button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualwarningmessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//System.out.println(actualwarningmessage);
		String expectedwarningmessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected warning message is not displayed");
		
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		
				
		//Email Address Text fieldgenerateEmailWithTimeStamp
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(dataProp.getProperty("invalidEmail"));
				
		//Password Text Field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
				
		//Click on Login Button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualwarningmessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//System.out.println(actualwarningmessage);
		String expectedwarningmessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected warning message is not displayed");
		
		
	}
	
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		
				
		//Email Address Text field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
				
		//Password Text Field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidPassword"));
				
		//Click on Login Button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualwarningmessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//System.out.println(actualwarningmessage);
		String expectedwarningmessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected warning message is not displayed");
		
		
	}
	
	@Test(priority=5)
	public void verifyLoginWithWithoutProvideCredentials() {
		
				
		//Email Address Text field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
				
		//Password Text Field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
				
		//Click on Login Button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualwarningmessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//System.out.println(actualwarningmessage);
		String expectedwarningmessage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected warning message is not displayed");
		
		
	}
	
	
}
