package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigPropertyReader {
	
	
	Properties prop;

	//Creating a method to read property file
	public ConfigPropertyReader() {
		
		try {
			
			File src = new File("./src/test/resources/Config.property");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);	
			
		} 
		
		catch (Exception e) {
			
			System.out.println("Exception is: "+ e.getMessage());
		
		}
	}
	
	public String chromePath() {
		
		String path = prop.getProperty("ChromeDriverPath");
		return path;
		
	}
	
	public String url() {
		
		String URL = prop.getProperty("URL");
		return URL;
	}
	
	public String sourceReportFile() {
		
		String URL = prop.getProperty("SourceReportFile");
		return URL;
	}
	
	public String destinationReportFile() {
		
		String URL = prop.getProperty("DestinationReportFile");
		return URL;
	}
}
