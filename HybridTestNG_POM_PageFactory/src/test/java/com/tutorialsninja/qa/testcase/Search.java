package com.tutorialsninja.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;



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
		
		//Calling browser initialize method from base class
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		//Search Text box Field
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataProp.getProperty("searchValidData"));
		//Click on Search Button
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']")).isDisplayed(),"Valid Product of HP is not displayed in the search results.");
		
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		
		//Search Text box Field
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataProp.getProperty("searchInvalidData"));
		//Click on Search Button
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		String actucalSearchMessage=driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
		
		Assert.assertEquals(actucalSearchMessage, "There is no product that matches the search criteria.","No Product search result message is not displayed");
	}
	
	@Test(priority=3)
	public void searchWithoutAnyProduct() {
		
		//Search Text box Field
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataProp.getProperty("searchInvalidData"));
		//Click on Search Button
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
				
		String actucalSearchMessage=driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
				
		Assert.assertEquals(actucalSearchMessage, dataProp.getProperty("searchWarningMessage"),"No Product search result message is not displayed");
		
	}

}
