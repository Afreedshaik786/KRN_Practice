package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

/**
 * This class consists of all basic configurations of testNG
 * 
 * @author SHAIK AFREED AHAMAD
 */

public class BaseClass {
	public ExcelFile_Utility eutil = new ExcelFile_Utility();
	public PropertyFile_Utility putil = new PropertyFile_Utility();
	public Java_Utility jutil = new Java_Utility();
	public Selenium_Utility sutil = new Selenium_Utility();

	public WebDriver driver;

	// for Listeners
	public static WebDriver sdriver;// static thts y prefix s to driver

	@BeforeSuite /* (groups = { "SmokeSuite", "RegressionSuite" }) */
	public void bsconfig() {
		System.out.println("============DB connection successfull===========");
	}

	// @Parameters("browser")
	@BeforeTest
	// @BeforeClass(alwaysRun = true)
	public void bcconfig(/* String BROWSER */) throws Throwable {
		String URL = putil.readDataFromPropertyFile("url");
		driver = new EdgeDriver();
		/*
		 * if(BROWSER.equals("edge")) 
		 * {
		 *  driver = new EdgeDriver();
		 *   }
		 *    else{
		 * if(BROWSER.equals("chrome")) 
		 * {
		 *  driver = new ChromeDriver();
		 *   }
		 *    }
		 */

		sutil.maximizeWindow(driver);
		sutil.addimplicitylyWait(driver);
		driver.get(URL);// here holding the some value by driver
		System.out.println("============Browser launch successfull==========");

		// for listeners
		sdriver = driver;// here reinitializing sdriver = driver;
	}

	@BeforeMethod /* (alwaysRun = true) */
	public void bmconfig() throws Throwable {
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("============login to app successfull==========");
	}

	@AfterMethod /* (alwaysRun = true) */
	public void amconfig() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("============logout to app successfull==========");
	}

	@AfterTest
	// @AfterClass(alwaysRun = true)
	public void acconfig() {
		driver.quit();
		System.out.println("============Browser closure successfull==========");
	}

	@AfterSuite /* (alwaysRun = true) */
	public void asconfig() {
		System.out.println("============DB closure successfull==========");
	}

}
