package listners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.Base;
import utility.Extent_Report_Generator;

public class My_listner extends Base implements ITestListener {
	
	ExtentReports report=Extent_Report_Generator.getExtentReport();
	ExtentTest etest;

	@Override
	public void onTestStart(ITestResult result) {
		
		String testname=result.getName();
		etest=report.createTest(testname);
		etest.log(Status.INFO, testname+"execution started ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname=result.getName();
		etest.log(Status.PASS, testname+"got successfully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testname=result.getName();
		etest.log(Status.FAIL, testname+"got failed");
		
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		etest.addScreenCaptureFromPath(takeScreenshot(testname,driver),testname);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testname=result.getName();
		etest.log(Status.SKIP, testname+"Test Skipped");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
		report.flush();
		
	}

	
	
}
