package Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Params {
	
	
	@Test
	@Parameters({"url","email","password"})
	public void Login(String URL, String Email, String Password) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
		
		//Click on MyAccount
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
		
		//Email Text field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Email);
		
		//Password Text field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(Password);
		
		//Click on Login Button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}

}

//140..option parameter mainly use for if any url is not declare in xml. if you got erro that time you can use.
//syn : public void Login(@options(URL)String URL, String Email, String Password)

//141.Enable & disable test cases- bydefault its true
//disable-><test thread-count="5" name="Test" enabled="false">
