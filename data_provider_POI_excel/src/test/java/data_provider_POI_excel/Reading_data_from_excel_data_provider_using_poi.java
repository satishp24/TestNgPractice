package data_provider_POI_excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reading_data_from_excel_data_provider_using_poi {
	
	@Test(dataProvider = "supplier")
	public void loginTest(String Email, int Password) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		//Click on My Account
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		//Click on Login
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
				
		//Email id text field
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Email);
				
		//Password text field
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(String.valueOf(Password));
				
		//Click on Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
				
				
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		
		
	}
	
	@DataProvider(name="supplier", parallel = true)
	public Object[][] dataSupplier() throws IOException {
		
		String excelFilePath=System.getProperty("user.dir")+"\\file\\Sample.xlsx";
		File excelFile=new File(excelFilePath);
		FileInputStream fis=null;
		
		try {
			
			fis=new FileInputStream(excelFile);
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook=null;
		try {
		
		 workbook=new XSSFWorkbook(fis);
		}catch(IOException e){
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("Login");

		
		int rowsCount=sheet.getPhysicalNumberOfRows();
		int colsCount=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rowsCount-1][colsCount];
		
		for(int r=0;r<rowsCount-1;r++) {
			
			XSSFRow row = sheet.getRow(r+1);
			
			for(int c=0;c<colsCount;c++) {
				
				XSSFCell cell = row.getCell(c);
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				
				case STRING:
					data[r][c]=cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[r][c]=(int)cell.getNumericCellValue();
					break;
					
				case BOOLEAN:
					data[r][c]=cell.getBooleanCellValue();
					break;
					
				
				} 
				
				
			}
		}
		
		return data;
	}

}

