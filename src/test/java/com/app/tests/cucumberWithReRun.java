package com.app.tests;

	import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	public class cucumberWithReRun {
	@RunWith(Cucumber.class)
	@CucumberOptions(
	        features = "@target/rerun.txt",
	        plugin = {
	        		"json:target/cucumber.json",
	        		"html:target/cucumber/",
	        		"rerun:target/rerun.txt"}
	)
	public class FailedScenarios   {

	}
}
