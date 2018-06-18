package com.app.stepDefs;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.pages.SuiteCRM_ContactCreate;
import com.app.utilities.Config;
import com.app.utilities.GenericMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatingContact_UsingMaps_StepDefs {
	WebDriver driver = GenericMethods.setup();

	@When("^I create a new contact:$")
	public void i_create_a_new_contact(Map<String, String> contact) {
		// open the create contact dialog
		// enter information
		// save
		SuiteCRM_ContactCreate createContact=new SuiteCRM_ContactCreate();
		
		createContact.createContact();
		
		createContact.sendData(contact.get("prefix"), contact.get("first_name"), contact.get("last_name"), contact.get("office_phone"), contact.get("title"));
		
		

	
	}

	@Then("^I should see contact information for \"([^\"]*)\"$")
	public void i_should_see_contact_information_for(String arg1) {
		System.out.println("I created a new contact using Map");
	}
}
