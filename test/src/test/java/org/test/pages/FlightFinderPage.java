package org.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightFinderPage {
	
	@FindBy(xpath = "//input[@value='roundtrip']")
	WebElement roundTrip;
	
	@FindBy(xpath = "//input[@value='oneway']")
	WebElement oneWay;
	
	@FindBy(xpath = "//select[@name='passCount']")
	WebElement passengers;
	

	@FindBy(xpath = "//select[@name='passCount']")
	WebElement passengers1;
	
}