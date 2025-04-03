package Test_Cases;

import org.testng.annotations.Test;

public class Login {
	@Test(priority = 1, groups = {"smoke","sanity","regression","login","all"})
	public void loginWithValidCredentials() {
		
		System.out.println("loginWithValidCredentials-Login");
	}
	
	@Test(priority = 2, groups = {"sanity","regression","login","all"})
	public void loginWithValidEmailAndInvalidPassword() {
		
		System.out.println("loginWithValidEmailAndInvalidPassword- Login");
	}
	
	@Test(priority = 3, groups = {"sanity","regression","login","all"})
	public void loginWithInvalidEmailAndValidPassword() {
		
		System.out.println("loginWithInvalidEmailAndValidPassword- Login");
	}
	
	@Test(priority = 4, groups = {"smoke", "sanity","regression","login","all"})
	public void loginWithInvalidCredentaials() {
		
		System.out.println("loginWithInvalidCredentaials- Login");
	}
	
	@Test(priority = 5, groups = {"sanity","regression","login","all"})
	public void loginWithoutProvidingCredentials() {
		
		System.out.println("loginWithoutProvidingCredentials- Login");
	}

}
