package com.app.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions( 
		plugin="html:target/cucumber12",
		features="src/test/resources/features",
		glue="com/app/stepDefs",
		tags="@Manip",
		dryRun=false
)

public class CukesRunner extends AbstractTestNGCucumberTests{
}
