package demo;

import org.testng.annotations.Test;

public class Customer {
	@Test
	public void createCustomer() {
		System.out.println("create customer");
	}

	@Test
	public void editCustomer() {
		System.out.println("Edit Customer");
	}

	@Test(dependsOnMethods = "editCustomer")
	public void deleteCustomer() {
		System.out.println("Delete customer");

	}

}
