package TestNGAnnotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotations {
	
	WebDriver driver;
	
	
	
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
	public void verifyUserLoginwithValidCredentials() {
		
		
		//click on My Account
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Email id field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pariharsatish32@gmail.com");
		
		//Password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		
		//Click on Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
			
	}
	
	@Test(priority = 2)
	public void verifyUserLoginwithValidUserNameandInvalidPassword() {
		

		//click on My Account
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Email id field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pariharsatish32@gmail.com");
		
		//Password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456");
		
		//Click on Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText(), "Warning: No match for E-Mail Address and/or Password.");
		
		
;		
	}
	
	
	@Test(priority = 3)
	public void verifyUserLoginwithInvalidUserNameandValidPassword() {
		
		
		//click on My Account
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Email id field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pariharsatish321@gmail.com");
		
		//Password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456");
		
		//Click on Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText(), "Warning: No match for E-Mail Address and/or Password.");
		
		
;		
	}
	
	
	@Test(priority = 4)
	public void verifyUserLoginwithInValidCredentials() {
		
		
		//click on My Account
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Email id field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pariharsatish3234@gmail.com");
		
		//Password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234564677");
		
		//Click on Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText(), "Warning: No match for E-Mail Address and/or Password.");
		
		
;		
	}
	
	
	@Test(priority = 5)
	public void verifyUserLoginwithWithoutGivingCredentials() {
		
		
		//click on My Account
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Email id field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
		
		//Password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
		
		//Click on Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText(), "Warning: No match for E-Mail Address and/or Password.");
		
		
;		
	}

}
