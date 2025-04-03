package Test_Cases;

import org.testng.annotations.Test;

public class Register {
	
	

	@Test(priority = 1)
	public void RegisterByProvidingMandatoryFields() {
		
		System.out.println("RegisterByProvidingMandatoryFields-Register");
	}
	
	@Test(priority = 2)
	public void RegisterByProvidingAllFields() {
		
		System.out.println("RegisterByProvidingAllFields- Register");
	}
	
	@Test(priority = 3)
	public void RegisterByNotProvidingAnyFields() {
		
		System.out.println("RegisterByNotProvidingAnyFields- Register");
	}
	
	@Test(priority = 4)
	public void RegisterByProvidingDuplicateEmailAddress() {
		
		System.out.println("RegisterByProvidingDuplicateEmailAddress- Register");
	}

}
