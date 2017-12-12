package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Config {
	
	public static WebDriver driver;
	
	//Saving Reports to a specified location
	
	public static void Reports() {
		System.out.println("Report section");
	}
	
	//Creating a method to read property file
	public static void ReadPropertyFile() {
		try {
			File src = new File("./src/test/resources/Property.property");
			FileInputStream fis = new FileInputStream(src);
			Properties prop = new Properties();
			prop.load(fis);
		} 
		catch (Exception e) {
			System.out.println("Exception is: "+ e.getMessage());
		};
	}
	

	@BeforeTest
	public static void Initialization() {
		System.out.println("Initializing the Browser for testing");
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();	
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
 