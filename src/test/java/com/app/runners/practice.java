package com.app.runners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.app.utilities.GenericMethods;

public class practice {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = GenericMethods.setup();
		driver.get("http://34.223.219.142:1022/wordpress/wp-login.php?loggedout=true");
	}
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.id("user_login")).sendKeys("Icode");
		driver.findElement(By.id("user_pass")).sendKeys("abc123");
		driver.findElement(By.id("wp-submit")).click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//li[@id='wp-admin-bar-site-name']/a"))).build().perform();;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Visit Site']")).click();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//li[@id='wp-admin-bar-site-name']/a"))).build().perform();;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Dashboard']")).click();
	}
}
