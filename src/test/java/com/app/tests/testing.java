package com.app.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.time.StopWatch;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testing {
	private static WebDriver driver;
	
	
	public static void main(String[] args) {
		
//		WebDriverManager.chromedriver().setup();;
//		driver=new ChromeDriver();
//		WebDriverWait wait=new WebDriverWait(driver, 10);
		List<String>list=new ArrayList();
		StopWatch li=new StopWatch();
		li.start();
		long start= li.getStartTime();
		li.stop();
		long stop=li.getTime();
		String str="adlfadfj alkdfa";
		String[]words=str.split(" ");
//		System.out.println(words[0].trim().length());
		
		
		list.add("heelo");
		list.add("bye");
		list.add("yoo");
		list.add("study");
		
		
		String a1="!!day--yaz!!";
		String[]a2=a1.split("\\W");
		
		for (int i = 0; i < a2.length; i++) {
			
			a2[i]=a2[i].replaceAll("\\W", "");
		}
		System.out.println(Arrays.toString(a2));
		System.out.println(a2.length);
		
		

//		if(Character.isDigit(list.get(0).charAt(list.get(0).length()-1))) {
//			System.out.println("it is digit");
//		}else {
//			System.out.println("it might be digit or symbol");
//		}
		
		Iterator it=list.iterator();
		while(it.hasNext()) {
//			System.out.println(it.next());
		}
		
		String name = "alamenenasdffassdffakdsjfakfalkjfjkdla";
		String check = "";
		int count = 0;
		String check2 = "";
		for (int i = 0; i < name.length(); i++) {
			if (!check.contains(String.valueOf(name.charAt(i)))) {
				for (int j = 0; j < name.length(); j++) {
					if (name.charAt(i) == name.charAt(j)) {
						count++;
						check += name.charAt(i);
					}
				}
			}

			if (!check2.contains(String.valueOf(name.charAt(i)))) {
//				System.out.println("the letter " + name.charAt(i) + " is met " + count + " times");
				check2 += name.charAt(i);
			}
			count = 0;
		}
	}
}
