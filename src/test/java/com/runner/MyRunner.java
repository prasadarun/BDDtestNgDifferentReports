package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	    features = "src/test/resources/com/features/",
	    glue = {"com.stepdefinations", "com.hooks"},
	    plugin = {
	        "pretty",
	        "html:build/reports.html",
	    },
	    tags = "@login",
	    publish = false, // used to move reports to CICD pipeline
	    monochrome = false,
	    dryRun = false
	)

// Without AbstractTestNGCucumberTests or TestNgCucumberRunnerClass we cannot fetch the test anotations from test classes
public class MyRunner extends AbstractTestNGCucumberTests{





}
