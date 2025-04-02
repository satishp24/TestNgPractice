package TestNGAnnotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	@Parameters("url")
	
	@Test
	public void Test(String URL) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("URL");
	
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
			
	}

}
