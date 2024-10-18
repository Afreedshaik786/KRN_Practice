package DemoPack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Customer {
	@BeforeClass
	public void OpenBrowser() {
		System.out.println("open browser");
	}

	@BeforeMethod
	public void Login() {
		System.out.println("Login");
	}

	@Test(priority = 0)
	public void CreateCustomer() {
		System.out.println("Created customer Successfully");
		// Reporter.log("Created customer Successfully");
	}

	@Test(priority = 1)
	public void EditCustomer() {
		System.out.println("edited customer Successfully");
		// Reporter.log("edited customer Successfully");
	}

	@Test(priority = 4)
	public void DeleteCustomer() {
		System.out.println("deleted customer Successfully");
		// Reporter.log("deleted customer Successfully");
	}

	@AfterMethod
	public void Logout() {
		System.out.println("Logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("close browser");
	}

}
