package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Config;

public class SuiteCRMLoginPage {
	WebDriver driver;

	public SuiteCRMLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_name")
	WebElement username;
	
	@FindBy(id = "username_password")
	WebElement password;
	
	@FindBy(name = "Login")
	WebElement login;
	
	public void loginMeth() {
		username.sendKeys(Config.getPropValue("username"));
		password.sendKeys(Config.getPropValue("password"));
		login.click();
	}
}
