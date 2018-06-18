
package com.app.stepDefs;

import static com.app.utilities.GenericMethods.driverClose;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.GenericMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	WebDriver driver;

//	@Before 
	public void setup() {
		driver = GenericMethods.setupBrowser("chrome");
		System.out.println("Before scenario");
	}
	@After("@hello")
	public void tearDown(Scenario scenario) {
		SuiteCRMDashboardPage cm=new SuiteCRMDashboardPage(driver);
		cm.hoverOverUserToLogout();
		driverClose();
		
		
		
		System.out.println("After scenario");
		if(scenario.isFailed()) {
			final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		
	}
}
