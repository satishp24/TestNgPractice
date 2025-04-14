package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//objects
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginoption;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	//Actions
	public void clickOnMyAccount() {
		
		myAccountDropMenu.click();
		
	}
	
	public void selectLogin() {
		
		loginoption.click();
	}

}
