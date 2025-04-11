package test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Demo {

	public static void main(String[] args) throws IOException {
		
		ExtentReports extent = new ExtentReports();
		
		File file=new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReporter);
		
		ExtentTest eTest1 = extent.createTest("TestOne");
		
		//eTest1.pass("Test One Passed");
		eTest1.log(Status.PASS," Test One Passed");
		
		ExtentTest eTest2 = extent.createTest("TestTwo");
		
		//eTest2.fail("Test Two Fail");
		eTest2.log(Status.FAIL, "Test Two Failed");
		
		ExtentTest eTest3 = extent.createTest("TestThree");
		
		eTest3.skip("Test Three Skipped");
		
		extent.flush();
		
		Desktop.getDesktop().browse(file.toURI());

	}

}
