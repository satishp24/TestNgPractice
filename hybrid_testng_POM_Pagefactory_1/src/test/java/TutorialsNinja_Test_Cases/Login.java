package TutorialsNinja_Test_Cases;

import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.Base;
import utils.Utility;

public class Login extends Base {
	
	
	public Login() {
		
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
	public void verifyLoginWithValidCredentials() {
		
		//Click on My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Enter email field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pariharsatish32@gmail.com");
		
		//Enter password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		
		//Click on Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		
		
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		
		//Click on My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Enter email field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utility.generateEmailWithTimeStamp());
		
		//Enter password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		
		//Click on Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		
		
		
	}
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		
		//Click on My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Enter email field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utility.generateEmailWithTimeStamp());
		
		//Enter password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		
		//Click on Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		
		
		
	}
	
	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		
		//Click on My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Enter email field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pariharsatish32@gmails.com");
		
		//Enter password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345567");
		
		//Click on Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		
		
		
	}

	@Test(priority = 5)
	public void verifyLoginWithBlankCredentials() {
	
	//Click on My Account
	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	
	//Click on Login
	driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
	
	//Enter email field
	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
	
	//Enter password field
	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(""); 
	
	//Click on Login
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	
	
	
}
	
	



}
