package com.app.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.utilities.GenericMethods;

public class SauceLabsDemo {

	WebDriver driver;
	public static final String USERNAME = "jaji@gifto12.com";
	public static final String ACCESS_KEY = "2a0705c6-5b74-4c72-b867-bc6678bfd48f";
	public static final String URL = "http://" + USERNAME + ":" + 
	ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setPlatform(Platform.WINDOWS);
		caps.setCapability("version", 66);
		driver = new RemoteWebDriver(new URL(URL), caps);
		
		
	}

	@Test
	public void testGoogle() throws InterruptedException {
		driver.get("http://google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Java programming" + Keys.ENTER);
		Thread.sleep(2000);

	}

	@AfterTest
	public void tearDown() {

	}
}
