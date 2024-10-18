package ContactsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;

@Listeners(Generic_Utilities.ListenersImplementation.class)
public class createContactTests extends BaseClass {
	@Test(groups = "SmokeSuite")
	public void createContactWithlastName() throws Throwable {
		// read test data from excel file utility
		String LASTNAME = eutil.readDataFromExcelFile("Contacts", 1, 2);

		// step4;-navigate to contacts link
		HomePage hp = new HomePage(driver);// i hv created homepage pom class object
		// Thread.sleep(2000);
		hp.clickOnContactLink();// by using business library i have called

		// step5;- click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);// i hv created contactspage pom class object
		cp.clickOnLookUp();// by using business library i have called_

		// step6;-create contact with mandatory details
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME);

		// step7:- contact info page
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.contactHeaderText();

		// step8;-validate
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
	}

	@Test
	public void demotest() {
		Assert.fail();
		System.out.println("hi");
	}

}
