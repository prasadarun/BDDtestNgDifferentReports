package com.factory;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class DriverFactory {

	public static String highlight;
	private static WebDriver driver;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static void initializeDriver(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			// Set system properties for Chrome driver

			// Initialize ChromeDriver
			driver = new ChromeDriver();
			break;
		case "firefox":
			// Set system properties for Firefox driver

			// Initialize FirefoxDriver
			driver = new FirefoxDriver();
			break;
		case "edge":
			// Set system properties for Edge driver
			// Initialize EdgeDriver
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser name provided");
			break;
		}

		tlDriver.set(driver);
	}

	public static String takeScreenshot(WebDriver driver) {
		File srcFile = ((TakesScreenshot) tlDriver.get()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\screenshot\\" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);
			System.out.println("Screenshot captured: " + path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public synchronized static void quitDriver() {
		if (driver != null) {
			driver.quit();
			tlDriver.remove();

		}
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

}
