package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {


public static Properties readProperties() throws FileNotFoundException {


		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}
}
