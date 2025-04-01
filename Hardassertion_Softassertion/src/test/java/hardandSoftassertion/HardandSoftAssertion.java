package hardandSoftassertion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardandSoftAssertion {
	
	@Test
	public void sampleMethod() {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		SoftAssert softAssert=new SoftAssert();
		
		//get title
		String actualtitle=driver.getTitle();
		String expectedtitle="Your Store123";
		softAssert.assertEquals(actualtitle, expectedtitle);
		
		//get url
		String actualurl=driver.getCurrentUrl();
		String expectedurl="https://tutorialsninja.com/demo/as";
		softAssert.assertEquals(actualurl, expectedurl);
		
		driver.findElement(By.name("search")).sendKeys("HP", Keys.ENTER);
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
		
		
		driver.quit();
		softAssert.assertAll();
	}

}
