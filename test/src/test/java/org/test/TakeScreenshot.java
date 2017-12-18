package org.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


	
public class TakeScreenshot extends GenericConfigClass{
	
	static String destination;
	
	public static String captureScreenshot() throws IOException {
	
	
			System.out.println("ScreenshotCapture in Progress");
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			destination = configPropertyReader.screenshotDestination() + "\\Screenshot_" +df.format(date) +".png";
			FileUtils.copyFile(source, new File(destination));
		
			return destination;
	
	
}
}
