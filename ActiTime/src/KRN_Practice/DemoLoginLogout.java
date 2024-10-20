package KRN_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoLoginLogout {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://online.actitime.com/tcs4/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ExcelLibrary xlib = new ExcelLibrary();
		int lastRow = xlib.getLastRowNum("sheet1");
		for (int i = 1; i <= lastRow; i++) {
			String un = xlib.getExcelData("Sheet1", i, 0);
			String pwd = xlib.getExcelData("Sheet1", i, 1);
			driver.findElement(By.id("username")).sendKeys(un);
			driver.findElement(By.name("pwd")).sendKeys(pwd);
			driver.findElement(By.xpath("//a[@id='loginButton']//div")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Logout")).click();
			Thread.sleep(3000);
		}

	}

}
