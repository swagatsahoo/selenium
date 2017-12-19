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
		
	//static ConfigPropertyReader configPropertyReader = new ConfigPropertyReader();
	//static WebDriver driver;
	//static String OutputReport = configPropertyReader.destinationReportFile()+"\\TestReport_" + df.format(date) + ".html";
	//static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OutputReport);
	//static ExtentReports report = new ExtentReports();
	//public static ExtentTest stepLogger;
	
	
	
	/*----------------------------------------------------------------------------------------------
	
	//Saving Reports to a specified location
	public static void generatedReportsWithTimeStamp() {
	
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("YYYYMMMdd_HHmmSS");
		
		File sourceFile = new File(configPropertyReader.sourceReportFile());
		File destinationFile = new File( configPropertyReader.destinationReportFile()+"\\TestReport_" + df.format(date) + ".html" );
		
		try {
			Files.copy(sourceFile.toPath(), destinationFile.toPath());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	--*/

	/*------------------------------------------
	 * 
	 * ------------------------------------------------------*/
			
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
	
	
	//Main test
	@Test
	public static void mainTest() {
		
		//stepLogger = report.createTest("TC1", "Verify the Title");
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
	
	//After Test
	@AfterMethod
	public void tearDown(ITestResult result) throws Throwable {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			//stepLogger.log(Status.PASS, "The Test case " + result.getName()+ " has Passed");
			stepLogger.pass(MarkupHelper.createLabel(result.getName() + " has Passed", ExtentColor.GREEN));
			stepLogger.info(MarkupHelper.createLabel("Email Sent", ExtentColor.TEAL));
			//SendEmail.email();
			//stepLogger.info("Email Sent");
		}
		
		else if(result.getStatus()==ITestResult.FAILURE) {
			stepLogger.fail(MarkupHelper.createLabel(result.getName() + " has Failed with below error message", ExtentColor.RED));
			stepLogger.fail(MarkupHelper.createCodeBlock("Error Message: " + result.getThrowable()));
			stepLogger.fail("Snapshot added: " + stepLogger.addScreenCaptureFromPath(TakeScreenshot.captureScreenshot()));
			stepLogger.fail("Snapshot added. Click <a href='http://github.com'>HERE</a> to view the snapshot" );
			
			stepLogger.info(MarkupHelper.createLabel("Email Sent", ExtentColor.TEAL));
			//SendEmail.email();
			//stepLogger.info("Email Sent");
		
			
			//stepLogger.log(Status.FAIL, "The Test case " + result.getName() + " has Failed");
			//stepLogger.log(Status.FAIL, "Error Message: "+ result.getThrowable());
			//stepLogger.assignAuthor("Swagat");
			
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			stepLogger.skip(MarkupHelper.createLabel(result.getName() + " has been skipped", ExtentColor.YELLOW));
			//stepLogger.log(Status.SKIP, "The Test case " + result.getName() + " has been Skipped");
			
			stepLogger.info(MarkupHelper.createLabel("Email Sent", ExtentColor.TEAL));
			//SendEmail.email();
			//stepLogger.info("Email Sent");
		}
		
		stepLogger.log(Status.INFO, "Closing the Test Run");
		report.flush();
		driver.quit();
		System.out.println("Script executed and Browser Closed");
		
		
	}
	
	
	@BeforeMethod
	public void register(Method method) {
		String testName = method.getName();
		stepLogger=report.createTest(testName);
	}
	
	@AfterClass
	public void finalizeTest() throws EmailException {
		SendEmail.email();
	}
	

}
 