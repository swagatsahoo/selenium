package org.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Config {
	
	public WebDriver driver;
	
	@BeforeTest
	public static void Initialization() {
		System.out.println("Test Success");
		System.out.println("Test Success 2");
	}
	
	@AfterTest
	public static void TearDown() {
		
	}

}
 