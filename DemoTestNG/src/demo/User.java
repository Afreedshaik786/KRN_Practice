package demo;

import org.testng.annotations.Test;

public class User {
	@Test
	public void createUser() {
		System.out.println("Create User");
	}

	@Test
	public void editUser() {
		System.out.println("Edit User");
	}

	@Test(dependsOnMethods = "editUser")
	public void deleteUser() {
		System.out.println("Delete User");
	}
}
