package com.saucelab.sort;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Sort_01_SauceLab {
	WebDriver driver;
	WebElement element;

	@BeforeClass
	public void beforeClass() {
		//WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		

	}

	@Test
	public void Sort_01_Name_Ascending() {
		//Select A - Z ( Increading)
		selectItemInDropdown("//select[@class='product_sort_container']", "Name (A to Z)");
		//Verify Sort Correct
		Assert.assertTrue(isDataSortedAscending("//div[@class='inventory_item_name']"));
	}
	@Test
	public void Sort_01_Name_Descending() {
		//Select A - Z ( Increading)
		selectItemInDropdown("//select[@class='product_sort_container']", "Name (Z to A)");
		//Verify Sort Correct
		Assert.assertTrue(isDataSortedDescending("//div[@class='inventory_item_name']"));
	}
	@Test
	public void Sort_01_Price_Ascending() {
		//Select A - Z ( Increading)
		selectItemInDropdown("//select[@class='product_sort_container']", "Price (low to high)");
		//Verify Sort Correct
		Assert.assertTrue(isPriceSortedAscending("//div[@class='inventory_item_price']"));
	}
	@Test
	public void Sort_01_Price_Descending() {
		//Select A - Z ( Increading)
		selectItemInDropdown("//select[@class='product_sort_container']", "Price (high to low)");
		//Verify Sort Correct
		Assert.assertTrue(isPriceSortedDescending("//div[@class='inventory_item_price']"));
	}
	public void Sort_03() {
		// button[text()='Sort']
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		driver.findElement(By.xpath("//button[text()='Sort']")).click();
		//div[@class='inventory_item_name']
		// Verify Sort Correct

	}

	public boolean isPriceSortedAscending(String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		//Find All element matching with condition (Name/ Price ...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		//Get text element and add to Array List
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		System.out.println("---------------Du lieu tren UI ------------------------");
		for (Float name : arrayList) {
			System.out.println(name);
			
		}
		//Copy to new Array List to sort 
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}
		//Implement Sort
		Collections.sort(arrayList);
		System.out.println("---Data sorted Asc in Code");
		for(Float name:arrayList) {
			System.out.println(name);
		}
		//Verify 2 array equals
		return sortedList.equals(arrayList);
	}
	public boolean isDataSortedAscending(String locator) {
		//Init Array List
		ArrayList<String> arrayList = new ArrayList<>();
		//Find All element matching with condition (Name/ Price ...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		//Get text element and add to Array List
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		System.out.println("---------------Du lieu tren UI ------------------------");
		for (String name : arrayList) {
			System.out.println(name);
		}
		//Copy to new Array List to sort 
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}
		//Implement Sort
		Collections.sort(arrayList);
		System.out.println("---Data sorted Asc in Code");
		for(String name:arrayList) {
			System.out.println(name);
		}
		//Verify 2 array equals
		System.out.println("Da in xong");
		return sortedList.equals(arrayList);
	}
	public boolean isDataSortedDescending(String locator) {
		ArrayList<String> arrayList = new ArrayList<>();
		//Find All element matching with condition (Name/ Price ...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		//Get text element and add to Array List
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		System.out.println("---------------Du lieu tren UI ------------------------");
		for (String name : arrayList) {
			System.out.println(name);
		}
		//Copy to new Array List to sort 
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}
		//Implement Sort
		Collections.sort(arrayList);
		System.out.println("---Data sorted Asc in Code");
		for(String name:arrayList) {
			System.out.println(name);
		}
		//Reverse data ASC sort to DSC
		Collections.reverse(arrayList);
		//Collections sort (arrayList, Collections.reverseOrder());
		System.out.println("---Du lieu da sort DESC trong Code -- -");
		for(String name:arrayList) {
			System.out.println(name);
		}
		//Verify 2 array equals
		return sortedList.equals(arrayList);
	}
	public boolean isPriceSortedDescending(String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		//Find All element matching with condition (Name/ Price ...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		//Get text element and add to Array List
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		System.out.println("---------------Du lieu tren UI ------------------------");
		for (Float name : arrayList) {
			System.out.println(name);
		}
		//Copy to new Array List to sort 
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}
		//Implement Sort
		Collections.sort(arrayList);
		
		System.out.println("---Data sorted Asc in Code");
		for(Float name:arrayList) {
			System.out.println(name);
		}
		Collections.reverse(arrayList);
		System.out.println("---Du lieu da sort DESC trong Code -- -");
		for(Float name:arrayList) {
			System.out.println(name);
		}
		//Verify 2 array equals
		return sortedList.equals(arrayList);
	}

	/*
	 * public boolean isDataSortedASC(String locator) { List<WebElement> elementList
	 * = driver.findElements(By.xpath(locator)); List<String> names =
	 * elementList.stream().map(n->n.getText()).collect(Collectors.toList());
	 * List<String> sortedNames = names; Collections.sort(sortedNames); return
	 * names.equals(sortedNames); }
	 */
	public void selectItemInDropdown(String locator,String valueItem) {
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
