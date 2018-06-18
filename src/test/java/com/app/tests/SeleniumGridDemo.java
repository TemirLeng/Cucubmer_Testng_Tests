package com.app.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Demo hot to run
 * 
 * @author Nurkulov
 *
 */
public class SeleniumGridDemo {
	WebDriver driver;
	public static final String URL = "http://52.70.143.199:4444/wd/hub";

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setPlatform(Platform.ANY);
		// caps.setCapability("version", "67");
		driver = new RemoteWebDriver(new URL(URL), caps);

	}

	@Test
	public void testGoogle() throws InterruptedException {
		driver.get("http://google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Java programming" + Keys.ENTER);
		Thread.sleep(2000);

	}

}
