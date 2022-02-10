package extentListenerReport;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testClasses.BaseClass;
import utilitypackage.Screenshot;



public class ExtentReport extends BaseClass implements ITestListener {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	@Override
	public void onStart(ITestContext context) {
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String repName="Test-Report-"+timestamp+".html";
	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
	
	extent=new ExtentReports();
	
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Host name","localhost");
	extent.setSystemInfo("Environemnt","QA");
	extent.setSystemInfo("user","Rajat");
	
	htmlReporter.config().setDocumentTitle("GrowProjct11"); 
	htmlReporter.config().setReportName("Functional Test Automation Report"); 
	htmlReporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		logger=extent.createTest(result.getName()); 
		logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		logger=extent.createTest(result.getName()); 
		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		
		try {
			String scrpath=Screenshot.getScreenshot(driver, result.getName());
			logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(scrpath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		logger=extent.createTest(result.getName()); 
		logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	
	}

	
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

}
