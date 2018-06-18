package com.app.excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.app.utilities.*;
public class Test2XcelSheet {
	public static void main(String[] args) {
		
		ExcelUtils.openExcelFile("./Test.xlsx", "Sheet1");
		String data=ExcelUtils.getCellData(1, 2);
		System.out.println(data);
		
		ExcelUtils.setCellData("how many rules?", 1, 2);
		String data2=ExcelUtils.getCellData(1, 2);
		System.out.println(data2);
		
		ExcelUtils.setCellData("yeee", 4, 4);
		
	}
}
