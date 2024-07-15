package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/com/features/",
		glue = { "com.stepdefinations","com.hooks" },
		plugin = { "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","html:target/cucumber-reports" },
		tags = "@registration",
		publish = false,																							
		monochrome = false, 
		dryRun = false)

// Without AbstractTestNGCucumberTests or TestNgCucumberRunnerClass we cannot fetch the test anotations from test classes
public class MyRunner extends AbstractTestNGCucumberTests {

}
