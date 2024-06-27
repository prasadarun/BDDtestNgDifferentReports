package com.hooks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.listeners.ExtentReportListeners;
import com.utils.ElementUtils;
import com.utils.PropertiesFileReader;
import com.utils.TakeScreenShotUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class MyHooks {

	WebDriver driver;
	Properties prop;
	ElementUtils utils;

	@Before(order = 0)
	public void beforeScenario(Scenario scenario) {
		String scenarioName = scenario.getName();
		ExtentReportListeners.getExtentReport();
		ExtentReportListeners.createTest(scenarioName);
		
	}

	@Before(order = 1)
	public void setup() throws FileNotFoundException {

		prop = PropertiesFileReader.readProperties();
		DriverFactory.initializeDriver(prop.getProperty("browser"));
		System.out.println(prop.getProperty(prop.getProperty("browser")));
		driver = DriverFactory.getDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) throws IOException {
		boolean scenarioFailed = scenario.isFailed();
		ExtentReportListeners.logTestStatus(driver, scenarioFailed);
		Allure.addAttachment("Screenshot",TakeScreenShotUtils.getScreenshot());
	}

	@After(order = 0)
	public void tearDown() {
		DriverFactory.quitDriver();

	}



}
