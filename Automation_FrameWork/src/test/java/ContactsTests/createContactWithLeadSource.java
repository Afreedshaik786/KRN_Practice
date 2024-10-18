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
public class createContactWithLeadSource extends BaseClass {
	@Test(groups = "RegressionSuite")
	public void createContactWithLead() throws Throwable {

		// read test data from excel file utility
		String LASTNAME = eutil.readDataFromExcelFile("Contacts", 4, 2);
		String LEADSOURCE = eutil.readDataFromExcelFile("Contacts", 4, 3);

		// step4;-navigate to contacts link
		HomePage hp = new HomePage(driver);// i hv created homepage pom class object
		hp.clickOnContactLink();// by using business library i have called

		// step5;- click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);// i hv created contactspage pom class object
		cp.clickOnLookUp();// by using business library i have called_

		// step6;-create contact with mandatory details
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME, LEADSOURCE);

		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerInfo = cip.contactHeaderText();

		// step8;-validate
		Assert.assertTrue(headerInfo.contains(LASTNAME));
		System.out.println(headerInfo);

	}

}
