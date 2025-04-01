package TestNg_XML_File_For_batch_execution;

import org.testng.annotations.Test;

public class ClassB {
	
	@Test(priority = 1)
	public void methodBOne() {
		System.out.println("ClassB - methodBOne");
			
	}
	
	@Test(priority = 2)
	public void methodBTwo() {
		System.out.println("ClassB - methodBTwo");
			
	}
	
	@Test(priority = 3)
	public void methodBThree() {
		System.out.println("ClassB - methodBThree");
			
	}
	
	@Test(priority = 4)
	public void methodBFour() {
		System.out.println("ClassB - methodBFour");
			
	}

}
