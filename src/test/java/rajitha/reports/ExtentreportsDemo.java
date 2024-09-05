package rajitha.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportsDemo {
	
	public static ExtentReports getReportObject() {
		
		ExtentReports extent;
			
			String path="C:\\Rajitha\\Mobile Testing\\MobileFramework\\reports\\index.html";
			ExtentSparkReporter reporter=new ExtentSparkReporter(path);
			reporter.config().setReportName("Mobile Automation Results");
			reporter.config().setDocumentTitle("Test Results");
			
			 extent=new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Rajitha Banoth");
			return extent;
		}


}
