package com.app.stepDefs;

import com.app.pages.ManipulateContact;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Manip_StepDefs {

	ManipulateContact manip = new ManipulateContact();
	
	@When("^remove duplicate for this contact$")
	public void remove_duplicate_for_this_contact() throws Exception {
		manip.actionDupblicateButtonClick();
		manip.saveSave();
		manip.duplicateAction();
	}

	@Then("^there should be only (\\d+) \"([^\"]*)\" in the contact page$")
	public void there_should_be_only_in_the_contact_page(int arg1, String arg2) throws Exception {
	}
}
