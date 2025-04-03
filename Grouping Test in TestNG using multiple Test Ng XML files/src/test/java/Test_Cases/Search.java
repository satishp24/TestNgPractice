package Test_Cases;

import org.testng.annotations.Test;

public class Search {
	
	@Test(priority = 1)
	public void SearchForValidProduct() {
		
		System.out.println("SearchForValidProduct-Search");
	}
	
	@Test(priority = 2)
	public void SearchForAnInValidProduct() {
		
		System.out.println("SearchForAnInValidProduct- Search");
	}
	
	@Test(priority = 3)
	public void SearchWithoutAnySearchTeams() {
		
		System.out.println("SearchWithoutAnySearchTeams- Search");
	}


}
