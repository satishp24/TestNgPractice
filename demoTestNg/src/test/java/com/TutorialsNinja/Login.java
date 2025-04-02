package com.TutorialsNinja;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Login {
	
	@Test(priority = 1)
	public void VerifyLoginWithValidCredentials() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("pariharsatish32@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}
	
	
	@Test(priority = 2)
	public void VerifyLoginWithInvalidCredentials() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("pariharsatish32@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		
		driver.quit();
	}
	
	
	public String generateEmailTimeStamp() {
		
		Date date=new Date();
		return date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		
	}

}
