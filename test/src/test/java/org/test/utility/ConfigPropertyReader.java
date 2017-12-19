package org.test.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigPropertyReader {
	
	
	static Properties prop;

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
	
	//Creating individual parameter methods to be used across packages
	
	public String chromePath() {
		
		String path = prop.getProperty("ChromeDriverPath");
		return path;
		
	}
	
	public String appUrl() {
		
		String appURL = prop.getProperty("appURL");
		return appURL;
	}
	
	public String sourceReportFile() {
		
		String sourceReportFile = prop.getProperty("SourceReportFile");
		return sourceReportFile;
	}
	
	public String destinationReportFile() {
		
		String destinationReportFile = prop.getProperty("DestinationReportFile");
		return destinationReportFile;
	}
	
	public String screenshotDestination() {
		
		String screenshotDestination = prop.getProperty("screenshotDestination");
		return screenshotDestination;
	}
	
	public String hostName() {
		
		String hostName = prop.getProperty("hostName");
		return hostName;
	}
	
	public String hostSMTPport() {
		
		String hostSMTPport = prop.getProperty("hostSMTPport");
		return hostSMTPport;
	}
		
	public String emailHostUsername() {
		
		String emailHostUsername = prop.getProperty("emailHostUsername");
		return emailHostUsername;
	}
		
	public String emailHostPassword() {
		
		String emailHostPassword = prop.getProperty("emailHostPassword");
		return emailHostPassword;
	}
	
	public String emailFrom() {
		
		String emailFrom = prop.getProperty("emailFrom");
		return emailFrom;
	}
	
	public String emailTo() {
		
		String emailTo = prop.getProperty("emailTo");
		return emailTo;
	}
	
}
