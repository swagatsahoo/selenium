package org.test.testcases;

import org.openqa.selenium.support.PageFactory;
import org.test.pages.LoginPage;
import org.test.utility.GenericConfigClass;
import org.test.utility.Initialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLoginToApplication extends GenericConfigClass {
	
	
	@Test
	public void setUp(){
	LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
	login_page.loginNewToursDemo("demo", "demo");
	stepLogger.info("Login Successful");
	Assert.assertTrue(driver.getTitle().contains("Find a Flight"));
	stepLogger.pass("Title Verification passed");
	//Initialization.tearDown(null);
	//Initialization.finalizeTest();
	
	}
	 

}
