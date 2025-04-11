package extent_Report_Screenshots_for_all_testcases;

import java.sql.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	public WebDriver driver;
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
	}
	
	@Test(priority = 1)
	public void loginWithValidCredentials() {
		
		
		
		//click on My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Email Text field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pariharsatish32@gmail.com");
		
		//Password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		//Click Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void loginWithInvalidCredentials() {
		
		
			
			
			//click on My Account
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			
			//Click on login
			driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
			
			//Email Text field
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pariharsatish32@gmail.com");
			
			//Password field
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345789");
			
			//Click Login
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	
	@Test(priority = 3)
	public void loginWithWithoutProvideCredentials() {
		
		
		
		//click on My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Email Text field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
		
		//Password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
		
		//Click Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	
	public String generateTimeStamp() {
		
		Date date=new Date(0);
		return date.toString().replace(" ", "_").replace(":","_");
		
		
	}

}
