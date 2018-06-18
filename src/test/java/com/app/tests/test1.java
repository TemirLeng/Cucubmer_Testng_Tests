package com.app.tests;

import java.util.ArrayList;
import java.util.UUID;

import org.testng.annotations.Test;

public class test1 {
//	WebDriver driver = GenericMethods.setup();
String str="Mamytov";
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Test
	public void teset() {
		String[]list=UUID.randomUUID().toString().split("-");
		String lis=UUID.randomUUID().toString().replace("-", "");
		System.out.println(lis);
		System.out.println(list[0]+" "+list[1]);
//		System.out.println(UUID.randomUUID().toString());
//		System.out.println(UUID.fromString(str).toString());
//		driver.get("http://amazon.com");
//		Select sel = new Select(driver.findElement(By.id("searchDropdownBox")));
//		List list = driver.findElements(By.id("searchDropdownBox"));
//		System.out.println(list);
		// sel.selectByIndex(index);
	}
}
