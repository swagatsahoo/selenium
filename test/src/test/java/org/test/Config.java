package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class Config {
	
	public static WebDriver driver;
	
	public static void Reports() {
		
	}

	@BeforeTest
	public static void Initialization(String url) {
		System.out.println("Initializing the Browser to start");
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
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
		System.out.println("Script executed and Browser Closed");
	}

}
 