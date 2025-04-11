package TutorialsNinja_Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.Base;

public class Search extends Base {
	
	public Search() {
		
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
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		//Click on Search Box
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("HP", Keys.ENTER);
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
		
		
	}
	
	
	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		
		//Click on Search Box
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Satish", Keys.ENTER);
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText().contains("There is no product that matches the search criteria."));
		
	}
	
	@Test(priority = 3)
	public void verifySearchWithWithoutAnyProduct() {
		
		//Click on Search Box
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("", Keys.ENTER);
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText().contains("There is no product that matches the search criteria."));
		
	}
	
	

}
