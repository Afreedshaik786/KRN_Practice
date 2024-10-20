package com.krn.actitime.testbase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.krn.actitime.pageclass.TaskPage;

import KRN_Practice.ExcelLibrary;

public class BaseClass {
	public WebDriver driver;
	public ExcelLibrary xlib;
	public TaskPage tp;

	@BeforeSuite
	public void dbconnection() {
		System.out.println("Database Conneceted Succesfully");
	}

	@BeforeClass
	public void openBrowser() {
		driver = new ChromeDriver();
		xlib = new ExcelLibrary();
		tp = new TaskPage();
		driver.manage().window().maximize();
		driver.get("https://online.actitime.com/tcs4/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String expectedTitle = "actiTIME - Login";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@BeforeMethod
	public void login() throws Throwable {
		String un = xlib.getExcelData("Sheet1", 1, 0);
		String pwd = xlib.getExcelData("Sheet1", 1, 1);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();
		System.out.println("=================Login Successfull==========");
		String expectedTest = "Enter Time-Track for";
		String actualTest = driver.findElement(By.xpath("//h3[text()='Enter Time-Track for']")).getText();
		Assert.assertEquals(actualTest, expectedTest);

	}

	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		System.out.println("======================Logout Successfull");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}

	@AfterSuite
	public void dbconnection1() {
		System.out.println("Database disConneceted Succesfully");
	}
}
