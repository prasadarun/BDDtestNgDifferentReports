package com.utils;

import java.util.Random;

public class GenerateRandomString {

	private static final String value = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

	public static StringBuilder generateRandomString() {

		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		char[] chars = value.toCharArray();

		int length = 10;
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(value.length());
			char randomChar = chars[randomIndex];
			sb.append(randomChar);
		}

		return sb;

	}
	
	public static void main(String args[]) {
		StringBuilder vaue = generateRandomString();
		System.out.println(vaue+"@gmail.com");
	}

}
