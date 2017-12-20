package org.test.testcases;

import org.openqa.selenium.support.PageFactory;
import org.test.pages.LoginPage;
import org.test.utility.Initialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLoginToApplication extends Initialization {
	
	
	@Test
	public void verifyLogin(){
	LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
	login_page.loginNewToursDemo("demo", "demo");
	stepLogger.info("Login Successful");
	Assert.assertTrue(driver.getTitle().contains("Qvantel"));
	stepLogger.pass("Title Verification passed");

	}
	 

}
