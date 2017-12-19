package org.test.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GenericConfigClass {
	
	public static WebDriver driver;
	public static ConfigPropertyReader configPropertyReader = new ConfigPropertyReader();
	public static Date date = new Date();
	public static DateFormat df = new SimpleDateFormat("dd.MMM.YYY, EEE 'at' h.mm.ss a z");
	static String OutputReport = configPropertyReader.destinationReportFile()+"\\TestReport_" + df.format(date) + ".html";
	static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OutputReport);
	static ExtentReports report = new ExtentReports();
	public static ExtentTest stepLogger;
}
