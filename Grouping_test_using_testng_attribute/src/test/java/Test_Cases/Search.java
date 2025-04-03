package Test_Cases;

import org.testng.annotations.Test;

public class Search {
	
	@Test(priority = 1, groups= {"smoke","sanity","regression","search","all"})
	public void SearchForValidProduct() {
		
		System.out.println("SearchForValidProduct-Search");
	}
	
	@Test(priority = 2,groups= {"sanity","regression","search","all"})
	public void SearchForAnInValidProduct() {
		
		System.out.println("SearchForAnInValidProduct- Search");
	}
	
	@Test(priority = 3,groups= {"sanity","regression","search","all"})
	public void SearchWithoutAnySearchTeams() {
		
		System.out.println("SearchWithoutAnySearchTeams- Search");
	}


}
