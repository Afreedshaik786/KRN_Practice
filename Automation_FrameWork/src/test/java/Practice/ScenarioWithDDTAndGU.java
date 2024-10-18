 package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.ExcelFile_Utility;
import Generic_Utilities.PropertyFile_Utility;
import Generic_Utilities.Selenium_Utility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class ScenarioWithDDTAndGU {

	public static void main(String[] args) throws Throwable {

		// create object utilities
		PropertyFile_Utility pr = new PropertyFile_Utility();
		ExcelFile_Utility ex = new ExcelFile_Utility();
		Selenium_Utility se = new Selenium_Utility();

		// read common data from property file utility
		String URL = pr.readDataFromPropertyFile("url");
		String USERNAME = pr.readDataFromPropertyFile("username");
		String PASSWORD = pr.readDataFromPropertyFile("password");

		// read test data from excel file utility
		String LASTNAME = ex.readDataFromExcelFile("Contacts", 1, 2);

		// step 1;- launch the browser
		WebDriver driver = new EdgeDriver();
		se.maximizeWindow(driver);
		se.addimplicitylyWait(driver);

		// step 2;-load the url
		driver.get(URL);

		// step3;- login to application
		// object repository by using POM class

		LoginPage lp = new LoginPage(driver);
		// lp.getUserNameTextField().sendKeys(USERNAME);//by using getters we will call
		// lp.getPasswordTextField().sendKeys(PASSWORD);//by using getters we will call
		// lp.getLoginButton().click();//by using getters we will call

		lp.loginToApp(USERNAME, PASSWORD);// by using business library we will call

		// step4;-navigate to contacts link
		// driver.findElement(By.linkText("Contacts")).click();

		HomePage hp = new HomePage(driver);// i hv created homepage pom class object
		hp.clickOnContactLink();// by using business library i have called

		// step5;- click on create contact look up image
		// driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		ContactsPage cp = new ContactsPage(driver);// i hv created contactspage pom class object
		cp.clickOnLookUp();// by using business library i have called_

		// step6;-create contact with mandatory details
		// driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		// step7;-save
		// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME);

		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.contactHeaderText();

		// String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		// System.out.println(contactHeader);

		// step8;-validate
		// if (conHeader.contains(LASTNAME)) {
		// System.out.println("contact is created");
		// System.out.println(conHeader);
		// } else {
		// System.out.println("contact is not created");
		// }

		// step9;-logout of application
		// WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		// se.mouseOverAction(driver, ele);

		// Thread.sleep(1000);
		// driver.findElement(By.linkText("Sign Out")).click();

		hp.logoutOfApp(driver);// by using homepage business library i have called_
		// step10;- close the browser
		driver.quit();

	}

}
