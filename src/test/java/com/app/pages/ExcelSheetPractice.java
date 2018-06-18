package com.app.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class ExcelSheetPractice {
WebDriver driver;
//ExtentReports report;
//ExtentTest test;
Properties properties;
FileInputStream input;
File file;
XSSFWorkbook wBook;
XSSFSheet sheet;
XSSFRow row;
SuiteCRM_ContactCreate cont;

@BeforeClass
public void setUp() throws IOException {
	file=new File("./Test.xlsx");
	input=new FileInputStream(file);
	properties=new Properties();
	wBook=new XSSFWorkbook(input);
	sheet=wBook.getSheetAt(3);
	row=sheet.getRow(4);
	cont = new SuiteCRM_ContactCreate();
}

public void getDataFromExel() {
	for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
		cont.createContact();
		row=sheet.getRow(i);
		if(sheet.getRow(i).getCell(4).equals("Y")) {
			cont.sendData(row.getCell(0).toString(), row.getCell(1).toString(), row.getCell(2).toString(), "", row.getCell(3).toString());
			row.getCell(5).setCellValue("Passed");
		}else {
			row.getCell(5).setCellValue("Skipped");
		}
		row.getCell(i);	
	}
}
}
