package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Utility;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public  Base() {
		
			prop=new Properties();
			File propfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\config\\config.properties");
			
			dataProp =new Properties();
			File dataPropfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\testdata.properties");
			
			try {
			FileInputStream fis2=new FileInputStream(dataPropfile);
			dataProp.load(fis2);
			}catch(Throwable e) {
				e.printStackTrace();
			}
			
			
			
			try {
			FileInputStream fis=new FileInputStream(propfile);
			prop.load(fis);
			}catch(Throwable e){
				
				e.printStackTrace();
			
			
		}
	}
	
	
	public WebDriver initializeBrowserAndOpenApplication(String browsername) {
		
		
		
		if (browsername.equals("chrome")) {
			
			driver=new ChromeDriver();
			
		}else if(browsername.equals("firefox")) {
			
			driver=new FirefoxDriver();
			
		}else if(browsername.equals("edge")) {
			
			driver=new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}

}
