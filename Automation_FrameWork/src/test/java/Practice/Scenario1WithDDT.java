package Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1WithDDT {

	public static void main(String[] args) throws Throwable {

		// read all the required data
		// read data from property file
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

		// read data from excel file
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();

		// step1;- launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// step2;-load the url
		driver.get(URL);
		// step3;- login to appln
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		// step4;-navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		// step5;- click on create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		// step6;-create contact with mandatory details
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		// step7;-save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String conHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		// step8;-validate
		if (conHeader.contains(LASTNAME)) {
			System.out.println("contact is created");
			System.out.println(conHeader);
		} else {
			System.out.println("contact is not created");
		}
		// step9;-logout of application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		// step10;- close the browser
		driver.close();

	}

}
