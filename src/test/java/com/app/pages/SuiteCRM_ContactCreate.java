package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.app.utilities.GenericMethods;

public class SuiteCRM_ContactCreate {

	WebDriver driver;
	Actions action;

	public SuiteCRM_ContactCreate() {
		driver = GenericMethods.setup();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".desktop-bar #quickcreatetop")
	WebElement createButton;

	@FindBy(xpath = "//div[@class='desktop-bar']//li[@id='quickcreatetop']//a[.='Create Contact']")
	WebElement createContactLink;

	
	//going to create a contact page
	
	public void createContact() {
		action = new Actions(driver);
		action.moveToElement(createButton).perform();
		createContactLink.click();
	}

	
	
	// Prefix
	@FindBy(css = "#salutation")
	WebElement prefix;

	// First Name
	@FindBy(css = "#first_name")
	WebElement firstName;

	// Last Name
	@FindBy(css = "#last_name")
	WebElement lastName;

	// Title
	@FindBy(css = "#title")
	WebElement title;

	// Phone number
	@FindBy(css = "#phone_mobile")
	WebElement phoneNumber;

	// Save buttons
	@FindBy(css = "#SAVE")
	WebElement saveButton;

	@FindBy(xpath = "//input[@title='Save']")
	WebElement save2Button;

	public void sendData(String prefix, String name, String lastName, String phoneNumber, String title) {

		 this.prefix.sendKeys(prefix);
		Select sel = new Select(this.prefix);
//		sel.selectByVisibleText(prefix);
		this.firstName.sendKeys(name);
		this.lastName.sendKeys(lastName);
		this.phoneNumber.sendKeys(phoneNumber);
		this.title.sendKeys(title);
		saveButton.click();
		try {
			save2Button.click();
		}catch(Exception e) {
			System.out.println("Contact is not duplicate");
			e.getMessage();
		}
	}
	
	@FindBy(xpath="//div[@field='phone_mobile']")
	WebElement mobilePhoneValidation;

	@FindBy(css = ".module-title-text")
	WebElement name_lastNameValidation;

	public void first_lastNameValidation( String prefix, String first, String last, String phoneNum, String title) {
//		Assert.assertTrue((prefix+". "+first + " " + last).equalsIgnoreCase(name_lastNameValidation.getText()),"Verifying Title name and last name. "+name_lastNameValidation.getText());
		//or we can also assert just last name
		Assert.assertTrue(name_lastNameValidation.getText().contains(last.toUpperCase()));
		Assert.assertEquals(firstName.getText(),first, "First name validation");
		Assert.assertEquals(lastName.getText(), last, "Last name validation");
		Assert.assertEquals(mobilePhoneValidation.getText(), phoneNum, "Phone number validation");
		Assert.assertEquals(this.title.getText(), title, "Title validation");
	}
	

}
