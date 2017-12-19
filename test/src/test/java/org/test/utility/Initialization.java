package org.test.utility;

import java.lang.reflect.Method;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Initialization extends GenericConfigClass {
	
	//Initializing the global variable
	
			
	//Starting of Before Test
	@BeforeTest
	public static void setUp() {
		
		System.out.println("Initializing the Browser for testing");
		System.setProperty("webdriver.chrome.driver", configPropertyReader.chromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(configPropertyReader.url());
		htmlReporter.loadXMLConfig("src/test/resources/extentReportConfig.xml");
		report.attachReporter(htmlReporter);
		
		//==========================================================================
		
		report.setSystemInfo("Environment", "RUBIK SIT");
		report.setSystemInfo("Execution Date", df.format(date));
		report.setSystemInfo("Author", System.getProperty("user.name"));
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
	}
	
		
	

	/*------------------------------------------------------------------------------------------------*/
	
	
	
	@Test
	public static void mainTest() {
		
		//stepLogger = report.createTest("TC1", "Verify the Title"); | Creating individual test Cases name, but now we use the getName() to get the method names for testCases
		stepLogger.log(Status.INFO, "Trying to verify the Title");
		
		System.out.println("Main test");
		Assert.assertEquals(driver.getTitle(),"Qvantel");
		stepLogger.pass("Title Verification Passed");
		
	}
	

	/*------------------------------------------------------------------------------------------------*/
	@Test
	public static void secondTest() {
		
		System.out.println("Starting second method");
		//stepLogger = report.createTest("TC2", "Getting Current URL");
		stepLogger.log(Status.INFO, "Getting Current URL");
		
	}
	
	
	/*------------------------------------------------------------------------------------------------*/
	
	//After Test has been run
	@AfterMethod
	public void tearDown(ITestResult result) throws Throwable {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			//stepLogger.log(Status.PASS, "The Test case " + result.getName()+ " has Passed"); | Another way to add using log
			stepLogger.pass(MarkupHelper.createLabel(result.getName() + " has Passed", ExtentColor.GREEN));
			stepLogger.info(MarkupHelper.createLabel("Email Sent", ExtentColor.TEAL));
		
		}
		
		else if(result.getStatus()==ITestResult.FAILURE) {
			
			stepLogger.fail(MarkupHelper.createLabel(result.getName() + " has Failed with below error message", ExtentColor.RED));
			stepLogger.fail(MarkupHelper.createCodeBlock("Error Message: " + result.getThrowable()));
			TakeScreenshot.captureScreenshot();
			//stepLogger.fail("Snapshot added: " + stepLogger.addScreenCaptureFromPath(TakeScreenshot.captureScreenshot())); | Adding screenshot to the html report
			//stepLogger.fail("Snapshot added. Click <a href='http://github.com'>HERE</a> to view the snapshot" ); | Adding url to html reposrt
			stepLogger.fail("Error Snapshot added. Click <a href='C://Screenshots/'><b>HERE</b></a> to open parent folder<b>@Help:</b> Search for screenshot using name as Screenshot_" + df.format(date));
			stepLogger.info(MarkupHelper.createLabel("Email Sent", ExtentColor.TEAL));
			
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			
			stepLogger.skip(MarkupHelper.createLabel(result.getName() + " has been skipped", ExtentColor.YELLOW));
			//stepLogger.log(Status.SKIP, "The Test case " + result.getName() + " has been Skipped"); | Another way to add using log
			stepLogger.info(MarkupHelper.createLabel("Email Sent", ExtentColor.TEAL));
			
		}
		
		stepLogger.log(Status.INFO, "Closing the Test Run");
		report.flush();
		driver.quit();
		System.out.println("Script executed and Browser Closed");
		
		
	}
	
	
	@BeforeMethod
	public void getMethodName(Method method) {
		String testName = method.getName();
		stepLogger=report.createTest(testName);
	}
	
	
	@AfterClass
	public void finalizeTest() throws EmailException {
		SendEmail.email();
	}
	

}
 