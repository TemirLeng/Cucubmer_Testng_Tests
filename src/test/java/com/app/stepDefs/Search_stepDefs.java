package com.app.stepDefs;

import com.app.pages.SuiteCRMSearchPage;
import com.app.utilities.Config;

import cucumber.api.java.en.Then;

public class Search_stepDefs {
	SuiteCRMSearchPage search=new SuiteCRMSearchPage();
	@Then("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {
		
//		search.searchButtonClick(Config.getPropValue("name")+" "+Config.getPropValue("lastName"));
		search.searchButtonClick(arg1);
		
	}

	@Then("^verify link for \"([^\"]*)\" is displayed$")
	public void verify_link_for_is_displayed(String arg1) {
		search.getHref();
	}
}
