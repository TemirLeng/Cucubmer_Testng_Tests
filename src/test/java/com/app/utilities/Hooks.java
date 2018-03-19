package com.app.utilities;

import org.openqa.selenium.WebDriver;

import com.app.utilities.GenericMethods;
import static com.app.utilities.GenericMethods.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	WebDriver driver;
	@Before
	public void setup() {
		driver=GenericMethods.setup();
	}
	@After
	public void tearDown() {
		driverClose();
	}
}
