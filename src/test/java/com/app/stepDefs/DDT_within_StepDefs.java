package com.app.stepDefs;

import java.util.List;

import com.app.models.Contact;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class DDT_within_StepDefs {
	@Given("^I pass info$")
	public void i_pass_info(List<Contact> data){
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)

		for(Contact e:data) {
			System.out.println("Prefix: "+e.getPrefix());
			System.out.println("First name: "+e.getFirstName());
			System.out.println("Last name: "+ e.getLastName());
		}
	System.out.println(data.get(2));
	}

	@Given("^I logout from application$")
	public void i_logout_from_application()  {
	}
}
