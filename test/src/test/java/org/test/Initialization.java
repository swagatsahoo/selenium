package org.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Initialization  {
	

	//Initializing the global variable
	
	static ConfigReader configReader = new ConfigReader();
	public static WebDriver driver;
	
	/*------------------------------------------------------------------------------------------------*/
	
	//Saving Reports to a specified location
	public static void generatedReportsWithTimeStamp() {
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("YYYYMMMdd_HHmmSS");
		
		File sourceFile = new File(configReader.sourceReportFile());
		File destinationFile = new File( configReader.destinationReportFile()+"\\TestReport_" + df.format(date) + ".html" );
		
		try {
			Files.copy(sourceFile.toPath(), destinationFile.toPath());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/*------------------------------------------------------------------------------------------------*/
			
	//Starting of Before Test
	@BeforeTest
	public static void setUp() {
		
		System.out.println("Initializing the Browser for testing");
		System.setProperty("webdriver.chrome.driver", configReader.chromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(configReader.url());
	}
	

	/*------------------------------------------------------------------------------------------------*/
	
	
	//Main test
	@Test
	public static void mainTest() {
		
		System.out.println("Main test");
	}
	

	/*------------------------------------------------------------------------------------------------*/
	
	
	//After Test
	@AfterTest
	public static void tearDown() {
		
		System.out.println("Finishing Test with Final Touch");
		generatedReportsWithTimeStamp();
		
		driver.quit();
		
		System.out.println("Script executed and Browser Closed");
	}

}
 