package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	
	Properties prop;

	//Creating a method to read property file
	public ConfigReader() {
		
		try {
			
			File src = new File("./src/test/resources/Property.property");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);	
			
		} 
		
		catch (Exception e) {
			
			System.out.println("Exception is: "+ e.getMessage());
		
		}
	}
	
	public String ChromePath() {
		
		String path = prop.getProperty("ChromeDriverPath");
		return path;
		
	}
	
	public String URL() {
		
		String URL = prop.getProperty("URL");
		return URL;
	}
		
}
