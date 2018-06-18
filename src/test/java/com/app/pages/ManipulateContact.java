package com.app.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.GenericMethods;

public class ManipulateContact {

	WebDriver driver;

	public ManipulateContact() {
		driver = GenericMethods.setup();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[.='ACTIONS']")
	WebElement actionsButton;

	@FindBy(id = "duplicate_button")
	WebElement duplicateButton;

	public void actionDupblicateButtonClick() {
		actionsButton.click();
		duplicateButton.click();
		
		
	}

	@FindBy(xpath = "//table[@class='dcQuickEdit']//input[@id='SAVE']")
	WebElement saveButton;

	@FindBy(xpath = "//input[@title='Save']")
	WebElement secondSaveButton;

	
	JavascriptExecutor js;
	public void saveSave() {
		saveButton.click();
		secondSaveButton.click();
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(1900,0);");
	}

	@FindBy(css = "#merge_duplicate_button")
	WebElement findDublicateButton;

	@FindBy(css = "#next_step_button")
	WebElement nextStepButton;

	@FindBy(xpath = "//ul[@id='selectLinkTop']//label[@class='glyphicon bootstrap-checkbox initialized-checkbox glyphicon-unchecked']")
	WebElement checkBoxes;
	
	@FindBy(css="#button_select_all_top")
	WebElement selectAll;

	@FindBy(css = "#perform_merge_button")
	WebElement performMergeButton;

	@FindBy(css = "#save_merged_record_button")
	WebElement saveMergeButton;

	
	
	public void duplicateAction() throws InterruptedException {
		actionsButton.click();
		findDublicateButton.click();
		nextStepButton.click();
		checkBoxes.click();
		selectAll.click();
		performMergeButton.click();
		saveMergeButton.click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}

}
