package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Base {
	
	public String takeScreenshot(String testname,WebDriver driver) {
		
		File srcScreenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationScreenshotFile=new File(System.getProperty("user.dir")+"\\Screenshots\\"+testname+".png");
		try {
			FileUtils.copyFile(destinationScreenshotFile, srcScreenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destinationScreenshotFile.getAbsolutePath();
		
	}

}
