package com.app.stepDefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.app.pages.SuiteCRMSearchPage;
import com.app.utilities.ExcelUtils;
import com.app.utilities.GenericMethods;

import cucumber.api.java.en.Then;

public class ExcelSearch_StepDefs {
	SuiteCRMSearchPage search = new SuiteCRMSearchPage();
	WebDriver driver = GenericMethods.setup();

	@Then("^I validate contact data from excel sheet using \"([^\"]*)\" and  \"([^\"]*)\"$")
	public void i_read_value_from_excel_sheet_using_and(String path, String sheet) throws Exception {
		ExcelUtils.openExcelFile("./Test.xlsx", "Sheet2");
		for (int i = 1; i < ExcelUtils.getUsedRowsCount(); i++) {
			System.out.println(ExcelUtils.getCellData(i, 3));
			if (ExcelUtils.getCellData(i, 3).equals("Y")) {
				String tempContact = ExcelUtils.getCellData(i, 2);
				System.out.println(tempContact);

				search.searchButtonClick(tempContact);
				String xpath = "//table[@class='list View']//a[contains(text(),'" + tempContact + "')]";
				List<WebElement> results = driver.findElements(By.xpath(xpath));

				if (results.size() > 0) {
					ExcelUtils.setCellData("Pass", i, 4);
				} else {
					ExcelUtils.setCellData("Fail", i, 4);
				}

			} else {
				ExcelUtils.setCellData("Skipped", i, 4);
			}
		}
	}

}
