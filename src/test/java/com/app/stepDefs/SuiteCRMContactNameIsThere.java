package com.app.stepDefs;

import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMContactInfo;
import com.app.utilities.Config;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class SuiteCRMContactNameIsThere {

	WebDriver driver;

	SuiteCRMContactInfo contact = new SuiteCRMContactInfo();

	@Then("^I clicked on \"([^\"]*)\" contact$")
	public void i_clicked_on_contact(String arg1) {
		contact.contactClick();
	}

	@Then("^contact name is \"([^\"]*)\" and email is \"([^\"]*)\"$")
	public void contact_name_is_and_email_is(String arg1, String arg2) throws Exception {
			contact.verifyContactInfo(Config.getPropValue("name"), Config.getPropValue("lastName"), Config.getPropValue("email"));
	}


}
