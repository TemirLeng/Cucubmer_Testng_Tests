package com.app.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.GenericMethods;

import cucumber.api.event.Event;

public class HRAppPage {
	private WebDriver driver;

	public HRAppPage() {
		driver = GenericMethods.setup();
		PageFactory.initElements(driver, this);
		driver.get("http://34.223.219.142:7101/HRSystem-ViewController-context-root/faces/DeptEmpPage");
	}

	@FindBy(id = "pt1:ot1")
	public WebElement departmentID;

	@FindBy(id = "pt1:ot3")
	public WebElement managerID;

	@FindBy(id = "pt1:ot4")
	public WebElement locationID;

	@FindBy(id = "pt1:ot2")
	public WebElement departmentName;

	@FindBy(id = "pt1:cb3")
	public WebElement nextButton;

	@FindBy(id = "pt1:r1:0:it1::content")
	public WebElement emailBox;

	@FindBy(id = "pt1:r1:0:cb1")
	public WebElement findButton;

	@FindBy(id = "pt1:r1:0:ot1")
	public WebElement firstName;

	@FindBy(id = "pt1:r1:0:ot2")
	public WebElement lastName;

	@FindBy(xpath = "//div[@id='pt1:pc1:t1::db']//tr")
	public List<WebElement> employeesCount;

	@FindBy(xpath = "//div[@id='pt1:pc1:t1::db']//td")
	public WebElement employeesTable;
	
	@FindBy(id="pt1:pc1:_dchTbr")
	public WebElement detach;
	Robot rotob;
	public void searchForDepartment(int deptId) throws InterruptedException, AWTException {
		int currentDepId = Integer.parseInt(departmentID.getText());

		while (currentDepId != deptId) {
			nextButton.click();
			if (currentDepId == 50) {
				detach.click();
//				employeesTable.click();
//				Thread.sleep(2000);
//				Actions act=new Actions(driver);
//				act.moveToElement(employeesTable).perform();
//				
//				rotob=new Robot();
//				rotob.mouseWheel(20);
//				rotob.keyPress(KeyEvent.VK_PAGE_DOWN);
//				act.keyDown(Keys.PAGE_DOWN).perform();
//				act.keyUp(Keys.PAGE_UP).perform();
			}
			Thread.sleep(2000);
//			GenericMethods.scrollDown();
			currentDepId = Integer.parseInt(departmentID.getText());
			System.out.println(currentDepId);
		}
	}
	
	@FindBy(id="pt1:cb6")
	public WebElement queryButton;
}
