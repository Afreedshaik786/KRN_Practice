package com.krn.actitime.tasks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.BaseClass;

public class CreateCustomer extends BaseClass {
	@Test
	public void testCreateCustomer() throws Throwable {
		tp.clickOnTask(driver);
		tp.clickOnAddNew(driver);
		driver.findElement(By.xpath("//div[text()='New Customer']")).click();
		String custName = xlib.getExcelData("CreateCustomer", 1, 0);
		String descp = xlib.getExcelData("CreateCustomer", 1, 1);
		driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys(custName);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(descp);
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();

	}
}
