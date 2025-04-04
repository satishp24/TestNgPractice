import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Jagger_Array_DataProviders {
	
	@Test(dataProvider = "supplier")
	public void sampleTest(Object[] a) {
		
		for(int i=0;i<a.length;i++) {
			
			System.out.print (a[i]+" ");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
	}
	
	@DataProvider(name="supplier")
	public Object[][] dataSupplier() {
		
		Object[][] data= {{"one","two","three","four"},
						  {"five","six","seven"},
						  {"eight","nine"}};
		
		return data;
		}
	
	
	}

