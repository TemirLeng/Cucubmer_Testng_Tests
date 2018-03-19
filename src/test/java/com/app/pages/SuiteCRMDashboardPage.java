package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuiteCRMDashboardPage {
	private WebDriver driver;

	public SuiteCRMDashboardPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "SALES")
	WebElement sales;

	@FindBy(linkText = "MARKETING")
	WebElement marketing;

	@FindBy(linkText = "SUPPORT")
	WebElement support;

	@FindBy(linkText = "ACTIVITIES")
	WebElement activities;

	@FindBy(linkText = "COLLABORATION")
	WebElement collaboraion;

	@FindBy(linkText = "ALL")
	WebElement all;

	@FindBy(xpath = "//input[contains(@title,'Post Status Update for']")
	WebElement postField;

	@FindBy(xpath = "//div[@class='dashletNonTable']//input[@value='Post']")
	WebElement postButton;

	public void leaveNote(String note) {
		postField.sendKeys(note);
		postButton.click();
	}

	@FindBy(css = ".dropdown-toggle.user-menu-button")
	WebElement userDropDown;
	
	@FindBy(id = "logout_link")
	WebElement logoutLink;

	public void hoverOverUserToLogout() {
		Actions action = new Actions(driver);
		action.moveToElement(userDropDown).perform();
		logoutLink.click();
	}
}
