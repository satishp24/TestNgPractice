package testNgParamaterization_DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Data_Driven {
	
	@Test(dataProvider="DataSupplier")
	public void verifyLogin(String Email, String Password) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		//My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Email Id
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Email);
		
		//passward
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(Password);
		
		//Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
		
		
		
		
	}
	
	@DataProvider
	public String[][] DataSupplier() {
		
		String[][] data= {{"pariharsatish32@gmail.com","12345"},{"pariharsatish123@gmail.com","12345"},{"pariharsatish1234@gmail.com","12345"}};
		
		return data;
		
	}

}
