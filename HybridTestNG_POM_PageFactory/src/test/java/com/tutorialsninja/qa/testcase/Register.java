package com.tutorialsninja.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;
import com.tutorialsninja.qa.utils.Utilities;



public class Register extends Base {
	
	public Register() {
		
			super();
		
	}
	WebDriver driver;
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@BeforeMethod
	public void setup() {
		
		//Calling browser initialize method from base class
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		//Click on MyAccount Tab
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
				
		//Click on Register Tab
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	}
	
	@Test(priority=1)
	public void verifyRegisteringAccountWithMandatoryFields() {
		
		
		
		
		
		//First Name Text Field
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("firstName"));
		
		//Second NameText Field
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("lastName"));
		
		//Email Text Field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		
		//Telephone Text Field
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("telePhone"));
		
		//Password Text Field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		
		//Password Confirm Text Field
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		
		//Privacy policy checkbox Field
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		//Click on Continue Button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualSuccessfulHeading=driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualSuccessfulHeading, dataProp.getProperty("accountSuccessfullyCreatingHeading"), "Account Success Page Is Not Displayed");
		
		
		
	}
	
	@Test(priority=2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		
		
		//Click on MyAccount Tab
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Register Tab
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		//First Name Text Field
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("firstName"));
		
		//Second NameText Field
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("lastName"));
		
		//Email Text Field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		
		//Telephone Text Field
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("telePhone"));
		
		//Password Text Field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		
		//Password Confirm Text Field
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		
		//Newsletter CheckBox Field
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		
		//Privacy policy checkbox Field
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		//Click on Continue Button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualSuccessfulHeading=driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualSuccessfulHeading, dataProp.getProperty("accountSuccessfullyCreatingHeading"), "Account Success Page Is Not Displayed");
		
		
		
	}
	
	@Test(priority=3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
		
		
		
		//Click on MyAccount Tab
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Register Tab
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		//First Name Text Field
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("firstName"));
		
		//Second NameText Field
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("lastName"));
		
		//Email Text Field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		
		//Telephone Text Field
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("telePhone"));
		
		//Password Text Field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		
		//Password Confirm Text Field
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		
		//Newsletter CheckBox Field
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		
		//Privacy policy checkbox Field
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		//Click on Continue Button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualWarning=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarningMessage")));
		
		
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
		Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")),"Privacy Policy Warning Message is not display");
		
		String actualFirstNameWarning=driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertEquals(actualFirstNameWarning,dataProp.getProperty("firstNameWarning"),"First Name Warning Message is not displayed.");
		
		String actualLastNameWarning=driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertEquals(actualLastNameWarning,dataProp.getProperty("lastNameWarning"),"Last Name Warning Message is not displayed.");
		
		String actualEmailWarning=driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
		Assert.assertEquals(actualEmailWarning,dataProp.getProperty("emailWarning"), "Email Address Warning Message is not displayed.");
		
		String actualTelephoneWarning=driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
		Assert.assertEquals(actualTelephoneWarning,dataProp.getProperty("telePhoneWarning"), "Telephone Warning Message is not displayed.");
		
		String actualPasswordWarning=driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
		Assert.assertEquals(actualPasswordWarning,dataProp.getProperty("passwordWarning"), "Password Warning Message is not displayed.");
	
		
		
	}
	

}
