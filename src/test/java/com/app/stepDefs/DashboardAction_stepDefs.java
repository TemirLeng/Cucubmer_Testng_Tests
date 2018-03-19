package com.app.stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.GenericMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashboardAction_stepDefs {
	
	WebDriver driver=GenericMethods.setup();
	SuiteCRMDashboardPage dashboardPage=new  SuiteCRMDashboardPage();
	
	@When("^I post \"([^\"]*)\"$")
	public void i_post(String note) {
		dashboardPage.leaveNote(note);
	}

	@Then("^\"([^\"]*)\" should be displayed$")
	public void should_be_displayed(String note) {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'"+note+"')]")).getText().equals(note));
	}
	@And("^I logged out from application$")
	public void i_logged_out_from_application(){
		dashboardPage.hoverOverUserToLogout();
	}
}
