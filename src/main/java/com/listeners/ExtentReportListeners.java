package com.listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utils.TakeScreenShotUtils;

public class ExtentReportListeners {

	static ExtentReports extent;
	static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();
	static final String OUTPUT_FOLDER = "./reports/";
	static final String FILE_NAME = "TestExecutionReport1.html";

	public synchronized static ExtentReports getExtentReport() {

		if (extent == null) {
			Path path = Paths.get(OUTPUT_FOLDER);
			if (!Files.exists(path)) {
				try {
					Files.createDirectories(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		}
		return extent;
	}

	public static void createTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestThreadLocal.set(test);
	}

	public static void logTestStatus(WebDriver driver, boolean isFailed) throws IOException {
		ExtentTest test = extentTestThreadLocal.get();
		if (test != null) {
			if (isFailed) {
				test.fail("Scenario Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShotUtils.getScreenshot()).build());
			} else {
				test.pass("Scenario Passed");
			}
			extent.flush();
		} else {
			System.out.println("ExtentTest is null. Test not initialized properly.");
		}
	}

}
