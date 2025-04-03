package Package_Level_Annotations;

import org.testng.annotations.Test;

public class ClassB {
	
	@Test(priority = 1)
	public void methodBOne() {
		System.out.println("methodBOne Test");
		
	}
	
	@Test(priority = 2)
	public void methodBTwo() {
		
		System.out.println("methodBTwo Test");
	}

}
