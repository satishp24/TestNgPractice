import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Partially_passing_data_from_DataProvider {
	
	@Test(dataProvider="supplier")
	public void sampleTest(String a) {
		
		System.out.println(a);
		
	}
	
	@DataProvider(name="supplier",indices = {0,2})
	 public Object[] dataSupplier() {
		 
		Object[] data= {"Satish","Anand","Tejas","Me"};
		
		return data;
	 }

}
