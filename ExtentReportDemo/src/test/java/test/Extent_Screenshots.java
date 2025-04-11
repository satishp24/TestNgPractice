package test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_Screenshots {

	public static void main(String[] args) throws IOException {

		
		ExtentReports extent = new ExtentReports();
		
		File file=new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReporter);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		File srcScreenshots=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destinationScreenshotsPath= System.getProperty("user.dir")+"\\Screenshots\\TutorialsninjaHome.png";
		
		FileUtils.copyFile(srcScreenshots, new File(destinationScreenshotsPath));
		
		ExtentTest eTest1 = extent.createTest("Test One");
		
		eTest1.log(Status.INFO, "Test One Execution Started");
		eTest1.log(Status.INFO, "Test One Execution is in Progress");
		eTest1.addScreenCaptureFromPath(destinationScreenshotsPath);
		eTest1.log(Status.INFO, "Test One Execution is Completed");
		
		extent.flush();
		
		Desktop.getDesktop().browse(file.toURI());
		
		driver.quit();
		

	}

}
