package com.app.runners;

import org.testng.annotations.AfterClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		plugin= {"usage","html:target/cucumber12"},
		tags="@JDBC",
		features= {"./src/test/resources/hrapp_features", "./src/test/resources/api"},
		glue="com.app.stepDefs",
		dryRun=false,
		strict=true,
		monochrome=true
//		format="pretty",
//		name=""
		
		
		)
public class CukesRunnerData extends AbstractTestNGCucumberTests{

	@AfterClass
	public void quite() {
		
	}
}
