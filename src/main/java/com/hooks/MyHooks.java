package com.hooks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
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


	@Before
	public void setup() throws FileNotFoundException {

		prop = PropertiesFileReader.readProperties();
		DriverFactory.initializeDriver(prop.getProperty("browser"));
		System.out.println(prop.getProperty(prop.getProperty("browser")));
		driver = DriverFactory.getDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@After
	public void afterScenario(Scenario scenario) throws IOException {
		/*
		 * boolean scenarioFailed = scenario.isFailed();
		 * ExtentReportListeners.logTestStatus(driver, scenarioFailed);
		 */

		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// Attach screenshot to BDD default report
			scenario.attach(screenshot, "image/png", "Screenshot on failure");
		}

	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();

	}

}
