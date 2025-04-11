package TutorialsNinja_Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.Base;
import utils.Utility;

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
		
		driver=initializeBrowserAndOpenApplication(prop.getProperty("browsername"));
	}
	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryField() {
		
		//Click on My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Register
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
		
		//Enter First Name
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Satish");
		
		//Enter Last Name
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Parihar");
		
		//Enter Mail Id
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utility.generateEmailWithTimeStamp());
		
		//Enter Telephone
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567");
		
		//Enter Password
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234");
		
		//Confirm Password
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234");
		
		//Click on Privacy Policy
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		//Click on Continue
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText().contains("Your Account Has Been Created!"));
		
		
		
		
	}
	
	
	@Test(priority = 2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		
		//Click on My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
				
		//Click on Register
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
				
		//Enter First Name
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Satish");
				
		//Enter Last Name
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Parihar");
				
		//Enter Mail Id
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utility.generateEmailWithTimeStamp());
				
		//Enter Telephone
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567");
				
		//Enter Password
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234");
				
		//Confirm Password
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234");
				
		//Select newsletter
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
				
		//Click on Privacy Policy
		driver.findElement(By.xpath("//input[@name='agree']")).click();
				
		//Click on Continue
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
				
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText().contains("Your Account Has Been Created!"));
				
		
		
	}
	
	@Test(priority = 3)
	public void verifyRegisteringAccountwithExistingEmail() {
		
		//Click on My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
						
		//Click on Register
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
						
		//Enter First Name
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Satish");
						
		//Enter Last Name
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Parihar");
						
		//Enter Mail Id
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pariharsatish32@gmail.com");
						
		//Enter Telephone
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567");
						
		//Enter Password
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234");
						
		//Confirm Password
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234");
						
		//Select newsletter
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
						
		//Click on Privacy Policy
		driver.findElement(By.xpath("//input[@name='agree']")).click();
						
		//Click on Continue
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
						
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: E-Mail Address is already registered!"));
																																																								
																																																				
																																																		
	}
	
	
	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		
		//Click on My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
								
		//Click on Register
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
								
		//Enter First Name
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(" ");
								
		//Enter Last Name
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(" ");
								
		//Enter Mail Id
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(" ");
								
		//Enter Telephone
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(" ");
								
		//Enter Password
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(" ");
								
		//Confirm Password
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(" ");
								
		//Select newsletter
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
								
		//Click on Privacy Policy
		driver.findElement(By.xpath("//input[@name='agree']")).click();
								
		//Click on Continue
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
								
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'If you already have an account with us, please log')]")).getText().contains("If you already have an account with us, please login at the"));
												
		
	}
	
	


}
