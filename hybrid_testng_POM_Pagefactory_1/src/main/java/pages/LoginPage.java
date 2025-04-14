package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordAddressField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButtonField;
	
	
public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	//Actions
	public void enterEmailAddress(String emailText) {
		
		emailAddressField.sendKeys(emailText);;
		
	}
	
	public void enterPassword(int passwordText) {
		
		passwordAddressField.sendKeys(String.valueOf(passwordText));
	}
	
	public void loginButtonFields() {
		loginButtonField.click();
		
	}

}
