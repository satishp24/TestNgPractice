package utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report_Generator {

	
	public static ExtentReports getExtentReport() {
		
		ExtentReports report=new ExtentReports();
		
		File extentReportFile=new File(System.getProperty("user.dir")+"\\ExtentReport\\eReport.html");
		
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
		
		report.attachReporter(sparkReporter);
		
		return report;
		
	}
}
