package assertion_in_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion_In_TestNG {
	
	@Ignore
	public void sampleMethod() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		String actualtitle=driver.getTitle();
		String expectedtitle="Your Store";
		
		Assert.assertEquals(actualtitle, expectedtitle);
		driver.quit();
		
	}
	
	@Test(priority = 1)
	public void sampleMethod_1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.name("search")).sendKeys("HP", Keys.ENTER);
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
	}
	
}
