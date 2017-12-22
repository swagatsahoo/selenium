package org.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterUserPage{
	
	
	
	@FindBy(linkText = "REGISTER")
	WebElement register;
	
	@FindBy(name = "firstName")
	WebElement firstName;
	
	@FindBy(name = "lastName")
	WebElement lastName;
	
	@FindBy(name = "phone")
	WebElement phone;
	
	@FindBy(name ="userName")
	WebElement emailId;
	
	@FindBy(name ="address1")
	WebElement address;
	
	@FindBy(name ="city")
	WebElement city;
	
	@FindBy(name ="state")
	WebElement state;
	
	@FindBy(name ="postalCode")
	WebElement postalCode;

	@FindBy(name ="country")
	public static WebElement country;
	
	@FindBy(id ="email")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(name ="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name ="register")
	WebElement submitButton;
	
	
	
	public void clickOnRegisterLink() {
		register.click();
	}
	
	public void enterFirstname(String firstname) {
		firstName.sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void enterPhoneNumber(String customerPhoneNumber) {
		phone.sendKeys(customerPhoneNumber);
	}

	public void enterEmailAddress(String customerEmail) {
		emailId.sendKeys(customerEmail);
	}

	public void enterAddress(String customerAddress) {
		address.sendKeys(customerAddress);
	}

	public void enterCity(String customerCity) {
		city.sendKeys(customerCity);
	}

	public void enterState(String customerState) {
		state.sendKeys(customerState);
	}

	public void enterPostalCode(String CustomerPostalCode) {
		postalCode.sendKeys(CustomerPostalCode);
	}

	public void enterUsername(String customerDesiredUsername) {
		username.sendKeys(customerDesiredUsername);;
	}
	
	public void enterpassword(String customerDesiredPassword) {
		password.sendKeys(customerDesiredPassword);
	}
	public void enterConfirmPassword(String confirmPass) {
		confirmPassword.sendKeys(confirmPass);
		
	}
	public void submitButtonClick() {
		submitButton.click();
	}

	

}
