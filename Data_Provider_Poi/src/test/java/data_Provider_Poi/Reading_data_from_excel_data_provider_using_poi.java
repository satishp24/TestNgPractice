package data_Provider_Poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Reading_data_from_excel_data_provider_using_poi {
	
	@Test(dataProvider = "supplier")
	public void loginTest(String username, String password) {
		
		
	}
	
	@DataProvider(name="supplier")
	public void dataSupplier() throws FileNotFoundException {
		
		String excelFilePath=System.getProperty("user.dir")+"\\files\\employees.xlsx";
		File excelFile=new File(excelFilePath);
		FileInputStream fis=new FileInputStream(excelFile);
		
		
	}

}
