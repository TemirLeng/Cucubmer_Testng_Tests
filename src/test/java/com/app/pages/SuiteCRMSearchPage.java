package com.app.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.GenericMethods;

public class SuiteCRMSearchPage {
	
	WebDriver driver;
	
	public SuiteCRMSearchPage() {
		driver=GenericMethods.setup();
		PageFactory.initElements(driver, this);
//		driver.get(Config.getPropValue("url"));
	}
	
	@FindBy(xpath="//div[@class='desktop-bar']//button[@id='searchbutton']")
	WebElement searchbutton;
	
	
	@FindBy(xpath="//div[@class='desktop-bar']//form[@id='searchformdropdown']//input[@id='query_string']")
	WebElement searchBox;
	
	@FindBy (xpath="//a[.='John Doe']")
	WebElement result;
	
	public void searchButtonClick(String name) {
		searchbutton.click();
//		try {
//			Thread.sleep(2000);
//		}catch(Exception e) {
//			e.getMessage();
//		}
		searchBox.clear();
		searchBox.sendKeys(name+Keys.ENTER);
	}
	
	public boolean getHref() {
		System.out.println(result.getAttribute("href"));
		return (!result.getAttribute("href").isEmpty());
	}
	
	
}
