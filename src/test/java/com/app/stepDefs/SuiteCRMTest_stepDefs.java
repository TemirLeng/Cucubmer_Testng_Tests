package com.app.stepDefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.utilities.Config;
import com.app.utilities.GenericMethods;
import static com.app.utilities.GenericMethods.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SuiteCRMTest_stepDefs {
	WebDriver driver = GenericMethods.setup();
	
	SuiteCRMLoginPage loginPage=new SuiteCRMLoginPage(driver);
	SuiteCRMDashboardPage dashboardPage=new SuiteCRMDashboardPage(driver);
	
	
	@Given("^I logged into suiteCRM$")
	public void i_logged_into_suiteCRM() {
		driver.get(Config.getPropValue("url"));
		sleep(3);
		loginPage.loginMeth();
		}

	@Then("^CRM name should be SuiteCRM$")
	public void crm_name_should_be_SuiteCRM() {
		Assert.assertTrue(driver.getTitle().endsWith("SuiteCRM"));
	}

	@Then("^Modules should be displayed$")
	public void modules_should_be_displayed() {
//		Assert.assertTrue();
		System.out.println("Displayed");
	}
}
