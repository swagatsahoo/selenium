package org.test.utility;


import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Initialization {
	
	//Initializing the global variable
	
	public static WebDriver driver;
	
	public static ConfigPropertyReader configPropertyReader = new ConfigPropertyReader();
	
	public DropdownOptionSelector dropdownSelector = new DropdownOptionSelector();
	
	public static Date date = new Date();
	public static DateFormat df = new SimpleDateFormat("dd.MMM.YYY, EEE 'at' h.mm.ss a z");
	
	static String OutputReport = configPropertyReader.destinationReportFile()+"\\TestReport_" + df.format(date) + ".html";
	
	static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OutputReport);
	static ExtentReports report = new ExtentReports();
	public static ExtentTest stepLogger;
	
	static String testName, systemIp;
	
	
	
    @BeforeMethod
	public void getMethodName(Method method) {
		String testName = method.getName();
		stepLogger=report.createTest(testName);
	}
			
	//Starting of Before Class
	@BeforeClass
	public static void setUp() {
		
		
		//Initializing WebDriver==========================================
		System.out.println("Initializing the Browser for testing");
		System.setProperty("webdriver.chrome.driver", configPropertyReader.chromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(configPropertyReader.appUrl());
		htmlReporter.loadXMLConfig("src/test/resources/extentReportConfig.xml");
		report.attachReporter(htmlReporter);
		
		
		//Getting Ip adddress======================================================
		try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            systemIp= ipAddr.getHostAddress();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
		
		//Setting Report dashboard section=================================================
		report.setSystemInfo("Environment", "RUBIK SIT");
		report.setSystemInfo("Execution Date", df.format(date));
		report.setSystemInfo("Author", System.getProperty("user.name"));
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
		report.setSystemInfo("System IP", systemIp + "  (IPv4)");
		//report.setSystemInfo("Browser", browserName + browserVersion);  | Does not work with existing chromeDriver, need to deprecate.
		
		
	}
	
	/*----------------------------
	
	
	
	@Test
	public static void mainTest() {
		
		//stepLogger = report.createTest("TC1", "Verify the Title"); | Creating individual test Cases name, but now we use the getName() to get the method names for testCases
		stepLogger.log(Status.INFO, "Trying to verify the Title");
		
		System.out.println("Main test");
		Assert.assertTrue(driver.getTitle().contains("Welcome"));
		stepLogger.pass("Title Verification Passed");
		
	}
	

	@Test
	public static void secondTest() {
		
		System.out.println("Starting second method");
		//stepLogger = report.createTest("TC2", "Getting Current URL");
		stepLogger.log(Status.INFO, "Getting Current URL");
		
	}
	
	--------------------*/
	
	
	
	//After each test method has been run
	@AfterMethod
	public void reportGeneration(ITestResult result) throws Throwable {
		
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
			stepLogger.fail("Error Snapshot added. Click <a href='C://Screenshots/'><b>HERE</b></a> to open parent folder<b>:Hint-</b> Search for screenshot using name as: Screenshot_" + df.format(date));
			stepLogger.info(MarkupHelper.createLabel("Email Sent", ExtentColor.TEAL));
			
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			
			stepLogger.skip(MarkupHelper.createLabel(result.getName() + " has been skipped", ExtentColor.YELLOW));
			//stepLogger.log(Status.SKIP, "The Test case " + result.getName() + " has been Skipped"); | Another way to add using log
			stepLogger.info(MarkupHelper.createLabel("Email Sent", ExtentColor.TEAL));
			
		}
		
		stepLogger.log(Status.INFO, "Closing the Test Run");
		report.flush();
		
	}
	
	@AfterClass(alwaysRun = true)
	public void closureSteps() {
		driver.quit();
		System.out.println("Script executed and Browser Closed");
	}
	
	@AfterSuite
	public void emailSender() throws EmailException {
		SendEmail.email();
	}
	

}
 