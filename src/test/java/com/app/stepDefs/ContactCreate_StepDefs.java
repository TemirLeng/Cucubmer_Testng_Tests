package com.app.stepDefs;

import com.app.pages.SuiteCRM_ContactCreate;

import cucumber.api.java.en.When;

public class ContactCreate_StepDefs {

	SuiteCRM_ContactCreate contactCreate = new SuiteCRM_ContactCreate();

	@When("^I go to create contact page$")
	public void i_go_to_create_contact_page() {
		contactCreate.createContact();
		System.out.println("Creating new contact");
	}

	@When("^I create new contact using \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_create_new_contact_using(String prefix, String firstName, String lastName, String phoneNumber,
			String title) {

		contactCreate.sendData(prefix, firstName, lastName, phoneNumber, title);
		// System.out.println("prefix: " + prefix);
		// System.out.println("First Name: " + firstName);
		// System.out.println("Last Name:" + lastName);
		// System.out.println("Phone number: " + phoneNumber);
		// System.out.println("Title: " + title);
	}

	@When("^I validate search result with \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_validate_search_result_with(String arg1, String arg2) throws Exception {
		System.out.println("Valitdation of name passed");

	}

	@When("^I validate new created contact info \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"s$")
	public void i_validate_new_created_contact_info(String prefix, String firstName, String lastName,
			String phoneNumber, String title) {
		contactCreate.first_lastNameValidation(prefix, firstName, lastName, phoneNumber, title);
	}

}
