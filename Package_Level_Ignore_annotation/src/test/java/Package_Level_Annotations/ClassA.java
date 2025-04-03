package Package_Level_Annotations;

import org.testng.annotations.Test;

public class ClassA {
	
	@Test(priority = 1)
	public void methodAOne() {
		System.out.println("methodAOne Test");
		
	}
	
	@Test(priority = 2)
	public void methodATwo() {
		
		System.out.println("methodATwo Test");
	}
	
	@Test(priority = 3)
	public void methodAThree() {
		
		System.out.println("methodAThree Test");
	}

}
