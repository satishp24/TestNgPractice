package wish_List;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wish_List_Test {
	WebDriver driver;
	
	@Test
	public void userLogin() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		//click on My account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		//Email id text field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pariharsatish32@gmail.com");
		
		//Password text field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		
		//Click on Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	
	@Test (dependsOnMethods ={"userLogin"})
	public void AddProductTowishListandViewWishList() {
		
		//Enter search box and type HP
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("HP",Keys.ENTER);
		
		//Click on wishlist
		driver.findElement(By.xpath("//button[@type='button']//i[@class='fa fa-heart']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement wishlistelement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='wish list']")));
		wishlistelement.click();
		
		Assert.assertTrue(driver.getTitle().equals("My Wish List"));
		
		
	}
	
	@Test (dependsOnMethods ={"userLogin","AddProductTowishListandViewWishList"})
	public void removeProductFromWishList() {
		
		//click on wishlist remove button
		driver.findElement(By.xpath("//a[@class='btn btn-danger']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText().equals("Your wish list is empty."));
		
	}

}
