package com.app.stepDefs;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.app.pages.SuiteCRM_ContactCreate;
import com.app.utilities.ExcelUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExcelSheet_StepDefs {
	SuiteCRM_ContactCreate cont = new SuiteCRM_ContactCreate();

	@When("^I create a new contact using data from Excel sheet by \"([^\"]*)\" and \"([^\"]*)\"$")
	public void iCreateANewContactUsingDataFromExcelSheetByAnd(String path, String sheet) throws Exception {
		cont.createContact();
		ExcelUtils.openExcelFile(path, sheet);
//		File file = new File("./Test.xlsx");
//		FileInputStream input = new FileInputStream(file);
//		XSSFWorkbook wBook = new XSSFWorkbook(input);
//		XSSFSheet shee = wBook.getSheet("Sheet3");
//		XSSFRow row = shee.getRow(1);
//		int r = row.getPhysicalNumberOfCells();
//		XSSFCell cell = row.getCell(1);
//		cell.getColumnIndex();
		for (int i = 1; i < ExcelUtils.getUsedRowsCount(); i++) {
			String run = ExcelUtils.getCellData(i, 3);
			if (run.equals("Y")) {
				cont.createContact();
				System.out.println(run);

				cont.sendData(ExcelUtils.getCellData(i, 0), ExcelUtils.getCellData(i, 1), ExcelUtils.getCellData(i, 2),
						"", ExcelUtils.getCellData(i, 3));
				ExcelUtils.setCellData("Passed",i, 4);
//				row = shee.getRow(i);
//				row.getCell(4).setCellValue("Passed");
			} else {
//				row = shee.getRow(i);
//				row.getCell(4).setCellValue("Skipped");
				ExcelUtils.setCellData("Skipped", i, 4);
			}
		}
	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\" contact should be created$")
	public void andContactShouldBeCreated(String arg1, String arg2) throws Exception {
	
	}

}
