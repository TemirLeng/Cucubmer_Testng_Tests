package com.app.utilities;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Login {
	static String pass = "Y!9";
	static String login = "E";
	static String firstName = "H";
	static String lastName = "Z";
	static char r;
	static Random ran = new Random();
	static WebDriver driver;

	public String login() {
		while (login.length() < 5) {
			char randomNum = (char) (ran.nextInt((122 - 97) + 1) + 97);
			login += randomNum;
		}

		return login;
	}

	public String Password() {
		
		while (pass.length() < 8) {
			char randomNum = (char) (ran.nextInt((122 - 97) + 1) + 97);
			pass += randomNum;
		}

		return pass;
	}

	public static String firstName() {

		while (firstName.length() < 6) {
			char randomNum = (char) (ran.nextInt((122 - 97) + 1) + 97);
			firstName += randomNum;
		}

		return firstName;
	}

	public String lastName() {

		while (lastName.length() < 4) {
			char randomNum = (char) (ran.nextInt((122 - 97) + 1) + 97);
			lastName += randomNum;
		}

		return lastName;
	}
	
	
	public static String getRandomString(int length) {
		StringBuilder sb=new StringBuilder();
		String characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for(int i=0;i<length;i++) {
			int index=(int)Math.random()*characters.length();
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	public static void screenshot() {
		String fileName=getRandomString(10)+".png";
		String directory="\\D:\\SeleniumScreetshot";
		
		File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(sourceFile, new File(directory+fileName));
	}
}
