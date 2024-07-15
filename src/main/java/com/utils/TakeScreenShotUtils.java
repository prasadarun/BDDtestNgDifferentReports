package com.utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.factory.DriverFactory;

public class TakeScreenShotUtils {

	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\screenshot\\" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Path of screen shot" + path);
		return path;

	}

	public static byte[] getScreenshotAsBytes() {
		byte[] screenshotBytes = null;
		try {
			// Create a Robot instance for screen capture
			Robot robot = new Robot();

			// Capture the screen rectangle
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

			// Write the captured image to a byte array output stream
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(screenFullImage, "png", baos);
			baos.flush();
			screenshotBytes = baos.toByteArray();
			baos.close();
		} catch (AWTException | IOException ex) {
			ex.printStackTrace();
		}
		return screenshotBytes;
	}

}
