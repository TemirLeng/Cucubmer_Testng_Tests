package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.GenericMethods;

public class SuiteCRMContactInfo {

	
	WebDriver driver;
	
	public SuiteCRMContactInfo() {
		driver=GenericMethods.setup();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="John Doe")
	WebElement contactLink;
	
	public void contactClick() {
		contactLink.click();
	}
	
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="last_name")
	WebElement lastName;
	
	@FindBy(css=".email-link")
	WebElement email;
	
	
	public boolean verifyContactInfo(String name, String lastName1, String email1) {
		if(firstName.getText().equals(name)) {
			if(lastName.getText().equals(lastName1)) {
				if(email.getText().equals(email1)) {
					return true;
				}
			}
		}
		return false;
	}
}
