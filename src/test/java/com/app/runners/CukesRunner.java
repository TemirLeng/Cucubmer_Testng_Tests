package com.app.runners;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions( 
		snippets = SnippetType.CAMELCASE,
		plugin= {
				"pretty",
				"html:target/cucumber12",
				"json:target/cucumber.json"
//		 plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"},
		},
		monochrome = true,
		features="./src/test/resources/features",
		glue="com/app/stepDefs",
		tags="@tweet",
		dryRun=true
	
		)

public class CukesRunner extends AbstractTestNGCucumberTests{
	
//	@BeforeClass
//	public void setup() {
//		
//	}
//	
//	@AfterClass
//	public void tearDown() {
//		
//	}
	
}
