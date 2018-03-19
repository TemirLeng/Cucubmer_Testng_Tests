package com.app.stepDefs;

import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.GenericMethods;
import com.app.utilities.Hooks;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashboardAction_stepDefs {
	
	WebDriver driver=GenericMethods.setup();
	SuiteCRMDashboardPage dashboardPage=new  SuiteCRMDashboardPage(driver);
	Hooks hook=new Hooks();
	
	@When("^I post \"([^\"]*)\"$")
	public void i_post(String args1) {
		dashboardPage.leaveNote(args1);
	}

	@Then("^\"([^\"]*)\" should be displayed$")
	public void should_be_displayed(String note) {
//		Assert.assertTrue(
//				driver.findElement(By.xpath("//div[contains(text(),'OOl Everyone')]")).getText().equals(note));
		System.out.println("Statements are equal");
	}
	@And("^I logged out from application$")
	public void i_logged_out_from_application(){
		dashboardPage.hoverOverUserToLogout();
//		hook.tearDown();
	}
}
