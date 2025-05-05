package com.tutorialsninja.qa.testcase;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;
import com.tutorialsninja.qa.utils.Utilities;



public class Register extends Base {
	
	WebDriver driver;
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@BeforeMethod
	public void setup() {
		
		//Calling browser initialize method from base class
		driver=initializeBrowserAndOpenApplicationURL("chrome");
		
		//Click on MyAccount Tab
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
				
		//Click on Register Tab
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	}
	
	@Test(priority=1)
	public void verifyRegisteringAccountWithMandatoryFields() {
		
		
		
		
		
		//First Name Text Field
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("satish");
		
		//Second NameText Field
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("parihar");
		
		//Email Text Field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		
		//Telephone Text Field
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9619033142");
		
		//Password Text Field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		
		//Password Confirm Text Field
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		
		//Privacy policy checkbox Field
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		//Click on Continue Button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualSuccessfulHeading=driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualSuccessfulHeading, "Your Account Has Been Created!", "Account Success Page Is Not Displayed");
		
		
		
	}
	
	@Test(priority=2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		
		
		//Click on MyAccount Tab
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Register Tab
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		//First Name Text Field
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("satish");
		
		//Second NameText Field
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("parihar");
		
		//Email Text Field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		
		//Telephone Text Field
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9619033142");
		
		//Password Text Field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		
		//Password Confirm Text Field
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		
		//Newsletter CheckBox Field
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		
		//Privacy policy checkbox Field
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		//Click on Continue Button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualSuccessfulHeading=driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualSuccessfulHeading, "Your Account Has Been Created!", "Account Success Page Is Not Displayed");
		
		
		
	}
	
	@Test(priority=3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
		
		
		
		//Click on MyAccount Tab
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Register Tab
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		//First Name Text Field
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("satish");
		
		//Second NameText Field
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("parihar");
		
		//Email Text Field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pariharsatish32@gmail.com");
		
		//Telephone Text Field
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9619033142");
		
		//Password Text Field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		
		//Password Confirm Text Field
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		
		//Newsletter CheckBox Field
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		
		//Privacy policy checkbox Field
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		//Click on Continue Button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualWarning=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(actualWarning.contains( "Warning: E-Mail Address is already registered!"));
		
		
	}
	
	@Test(priority=4)
	public void verifyRegisteringAccountWithoutFillingDetails() {
		
		
		
		//Click on MyAccount Tab
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Register Tab
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		//Click on Continue Button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualPrivacyPolicyWarning=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains( "Warning: You must agree to the Privacy Policy!"),"Privacy Policy Warning Message is not display");
		
		String actualFirstNameWarning=driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertEquals(actualFirstNameWarning,"First Name must be between 1 and 32 characters!","First Name Warning Message is not displayed.");
		
		String actualLastNameWarning=driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertEquals(actualLastNameWarning,"Last Name must be between 1 and 32 characters!","Last Name Warning Message is not displayed.");
		
		String actualEmailWarning=driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
		Assert.assertEquals(actualEmailWarning,"E-Mail Address does not appear to be valid!", "Email Address Warning Message is not displayed.");
		
		String actualTelephoneWarning=driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
		Assert.assertEquals(actualTelephoneWarning,"Telephone must be between 3 and 32 characters!", "Telephone Warning Message is not displayed.");
		
		String actualPasswordWarning=driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
		Assert.assertEquals(actualPasswordWarning,"Password must be between 4 and 20 characters!", "Password Warning Message is not displayed.");
	
		
		
	}
	

}
