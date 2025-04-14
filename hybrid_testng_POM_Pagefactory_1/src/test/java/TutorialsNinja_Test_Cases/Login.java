package TutorialsNinja_Test_Cases;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClass.Base;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
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
	
	@Test(priority = 1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, int password) {
		
		HomePage homepage=new HomePage(driver);
		//homepage.clickOnMyAccount();
		//Click on My Account
		//POM
		homepage.clickOnMyAccount();
		//driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Login
		homepage.selectLogin();
		
		//driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		LoginPage loginpage=new LoginPage(driver);
		
		//Enter email field
		loginpage.enterEmailAddress(email);
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		
		//Enter password field
		loginpage.enterPassword(password);
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(String.valueOf(password));
		
		//Click on Login
		loginpage.loginButtonFields();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		
		AccountPage accountpage=new AccountPage(driver);
		
		Assert.assertTrue(accountpage.getDisplayStatusOfEditYourAccountInformationOption(),"Edit Your Account Information Option is not displayed");
		
		
		
	}
	
	/*@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyData() {
		
		Object [][] data= {{"pariharsatish32@gmail.com","12345"},{"pariharsatish321@gmail.com","12345"},{"pariharsatish322@gmail.com","12345"},{"pariharsatish323@gmail.com","12345"}};
		return data;
		
		
	}*/
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyData() {
		
		Object [][] data= Utility.getTestDataFromExcel("Login");
		return data;
		
		
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
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty(""));
		
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
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(dataProp.getProperty("validEmail"));
		
		//Enter password field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidpassword"));
		
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
