package com.krn.actitime.pageclass;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskPage {

	public void clickOnTask(WebDriver driver) {
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
	}

	public void clickOnAddNew(WebDriver driver) {
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
	}

	public int getRandomNum() {
		Random ran = new Random();
		int ranNum = ran.nextInt(100);
		return ranNum;
	}

}
