package org.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(name ="userName")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(name = "login")
	WebElement signOnButton;
	
	public void loginNewToursDemo(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		signOnButton.click();
	}
	

}
