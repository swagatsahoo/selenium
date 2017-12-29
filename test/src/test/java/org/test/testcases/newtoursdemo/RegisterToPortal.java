package org.test.testcases.newtoursdemo;

import org.openqa.selenium.support.PageFactory;
import org.test.pages.RegisterUserPage;
import org.test.utility.Initialization;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class RegisterToPortal extends Initialization{
	
	
	@Test
	public void  registrationVerification() {
				
		RegisterUserPage register_page = PageFactory.initElements(driver, RegisterUserPage.class);
		
		register_page.clickOnRegisterLink();
		stepLogger.log(Status.INFO, "Navigation to Registration page is successfull");
		
		register_page.enterFirstname("Swagat");
		stepLogger.log(Status.INFO, "First name entered");
		
		register_page.enterLastname("Sahoo");
		stepLogger.log(Status.INFO, "Last name entered");
		
		register_page.enterPhoneNumber("70328827282");
		stepLogger.log(Status.INFO, "Phone Number entered");
		
		register_page.enterEmailAddress("test@test.com");
		stepLogger.log(Status.INFO, "Email Address entered");
		
		register_page.enterAddress("XXX");
		stepLogger.log(Status.INFO, "Address entered");
		
		register_page.enterCity("Hyderabad");
		stepLogger.log(Status.INFO, "City entered");
		
		register_page.enterState("TS");
		stepLogger.log(Status.INFO, "State entered");
		
		register_page.enterPostalCode("500084");
		stepLogger.log(Status.INFO, "Postal Code entered");
		
		dropdownSelector.dropdownValue(RegisterUserPage.country,"INDIA"); //Using drop down selector class to select options from country
		stepLogger.log(Status.INFO, "Country selected");
		
		register_page.enterUsername("swagatsahoo");
		stepLogger.log(Status.INFO, "Username choosen");
		
		register_page.enterpassword("swagatsahoo");
		stepLogger.log(Status.INFO, "Password ******* choosen");
		
		register_page.enterConfirmPassword("swagatsahoo");
		stepLogger.log(Status.INFO, "Confirm password ******* entered");
		
		register_page.submitButtonClick();
		stepLogger.log(Status.INFO, "Submitted the registration form");
		
	}

}
