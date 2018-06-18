package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.GenericMethods;

public class HRappSearchPage {

	private WebDriver driver;

	public HRappSearchPage() {
		driver = GenericMethods.setup();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "qryId1:val00::content")
	public WebElement empIdSearchBox;
	
	@FindBy(id = "qryId1:val00::content")
	public WebElement firsNameBox;
	
	@FindBy(id = "qryId1:val20::content")
	public WebElement lastNameBox;
	
	@FindBy(id = "qryId1:val30::content")
	public WebElement emailBox;
	
	@FindBy(id = "qryId1:val40::content")
	public WebElement salaryBox;
	
	@FindBy(id = "qryId1:val50::content")
	public WebElement hireDate;
	
	@FindBy(id = "qryId1:val60::content")
	public WebElement titleBox;
	
	@FindBy(id = "qryId1:val70::content")
	public WebElement deptIdBox;
	
	@FindBy(id = "qryId1:val80::content")
	public WebElement deptNameBox;
	
	@FindBy(id = "qryId1:val90::content")
	public WebElement annualSalaryBox;
	
	@FindBy(id="cb7")
	public WebElement commintButton;
	
	@FindBy(id="cb5")
	public WebElement submitButton;
	
	@FindBy(id="cb6")
	public WebElement backButton;
	
	@FindBy(id="qryId1:conj:_1")
	public WebElement anyRadioButton;
	
	@FindBy(id="qryId1::search")
	public WebElement searchButton;
	
	@FindBy (id="it1::content")
	public WebElement empId;
	
	
}
