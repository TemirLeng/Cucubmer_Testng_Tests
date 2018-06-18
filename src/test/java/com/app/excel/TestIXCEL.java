package com.app.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestIXCEL {
	public static void main(String[] args) throws IOException {

		File file=new File("./Test.xlsx");
		System.out.println(file.exists());
		FileInputStream input=new FileInputStream(file);
		XSSFWorkbook workBook=new XSSFWorkbook(input);
		XSSFSheet sheet=workBook.getSheet("Sheet1");
		System.out.println(sheet.getPhysicalNumberOfRows());
//		System.out.println(sheet.getRow(0).getCell(0));
		XSSFRow row1=sheet.getRow(0);
		XSSFCell cell1=row1.getCell(0);
		
		cell1.setCellValue("Doktur");
		sheet.getRow(0).getCell(3).setCellValue("55511111");
		FileOutputStream output=new FileOutputStream(file);
		workBook.write(output);
		output.close();
		
		System.out.println(sheet);
		System.out.println(sheet.getRow(0));
		for(int i=0;i<3;i++) {
			System.out.print(sheet.getRow(0).getCell(i)+" ");
		}
		
	}
}
