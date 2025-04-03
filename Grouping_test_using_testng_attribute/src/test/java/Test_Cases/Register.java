package Test_Cases;

import org.testng.annotations.Test;

public class Register {
	
	@Test(priority = 1, groups={"smoke","sanity","regression","register","all"})
	public void RegisterByProvidingMandatoryFields() {
		
		System.out.println("RegisterByProvidingMandatoryFields-Register");
	}
	
	@Test(priority = 2, groups={"sanity","regression","register","all"})
	public void RegisterByProvidingAllFields() {
		
		System.out.println("RegisterByProvidingAllFields- Register");
	}
	
	@Test(priority = 3, groups={"sanity","regression","register","all"})
	public void RegisterByNotProvidingAnyFields() {
		
		System.out.println("RegisterByNotProvidingAnyFields- Register");
	}
	
	@Test(priority = 4,groups={"sanity","regression","register","all"})
	public void RegisterByProvidingDuplicateEmailAddress() {
		
		System.out.println("RegisterByProvidingDuplicateEmailAddress- Register");
	}

}
