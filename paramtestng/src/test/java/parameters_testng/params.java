package parameters_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class params {
	
	
	
	@Test
	@Parameters("url")
	public void Login(String URL) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("URL");
		
		//click on My account
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		
		//Email id field
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("tester@kaiizeninfotech.com");
		
		//Password field
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("Test@kaizen123");
		
		//click on login
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}
	


}
