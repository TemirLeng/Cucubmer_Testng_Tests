package com.app.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions( 
		features="src/test/resources/features",
		glue="com/app/stepDefs",
		tags="@regression",
		dryRun=false
)

public class CukesRunner extends AbstractTestNGCucumberTests{
}
