package com.krn.actitime.tasks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.BaseClass;

public class DeleteCustomer extends BaseClass {
	@Test
	public void testDeleteCustomer() throws Throwable {
		tp.clickOnTask(driver);
		String delteCustomer = xlib.getExcelData("CreateCustomer", 1, 0);
		driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys(delteCustomer);
		driver.findElement(By.xpath("(//div[text()='"+delteCustomer+"'])[1]/../..//div[text()='editButton']")).click();
		driver.findElement(By.xpath("(//div[text()='ACTIONS'])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='Delete'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
	}
}
