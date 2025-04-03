package Test_Cases;
import org.testng.annotations.Test;

public class Login {
	
	@Test(priority = 1)
	public void loginWithValidCredentials() {
		
		System.out.println("loginWithValidCredentials-Login");
	}
	
	@Test(priority = 2)
	public void loginWithValidEmailAndInvalidPassword() {
		
		System.out.println("loginWithValidEmailAndInvalidPassword- Login");
	}
	
	@Test(priority = 3)
	public void loginWithInvalidEmailAndValidPassword() {
		
		System.out.println("loginWithInvalidEmailAndValidPassword- Login");
	}
	
	@Test(priority = 4)
	public void loginWithInvalidCredentaials() {
		
		System.out.println("loginWithInvalidCredentaials- Login");
	}
	
	@Test(priority = 5)
	public void loginWithoutProvidingCredentials() {
		
		System.out.println("loginWithoutProvidingCredentials- Login");
	}
	

}
