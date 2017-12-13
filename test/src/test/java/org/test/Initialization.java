package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Initialization  {
	
	static ConfigReader configReader = new ConfigReader();
	
	public static WebDriver driver;
	
	//Saving Reports to a specified location
	
	public static void Reports() {
		System.out.println("Report section to be created");
	}
		

	@BeforeTest
	public static void SetUp() {
		
		System.out.println("Initializing the Browser for testing");
		System.setProperty("webdriver.chrome.driver", configReader.ChromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(configReader.URL());
	}
	
	@Test
	public static void MainTest() {
		System.out.println("Main test");
	}
	
	@AfterTest
	public static void TearDown() {
		System.out.println("Finishing Test with Final Touch");
		Reports();
		driver.quit();
		System.out.println("Script executed and Browser Closed");
	}

}
 