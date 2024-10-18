package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.Selenium_Utility;

public class HomePage extends Selenium_Utility {// Rule 1

	// rule 2 Declaration
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	// rule 3 Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 4 Utilization
	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	// business library
	/**
	 * This method will click on contacts link in home page
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnContactLink() throws InterruptedException {
		contactsLink.click();
	}

	/**
	 * This method will navigate to administrator and signOut
	 * 
	 * @param driver
	 * @throws Throwable
	 */
	public void logoutOfApp(WebDriver driver) throws Throwable {
		mouseOverAction(driver, administratorImg);
		Thread.sleep(1000);
		signOutLink.click();
	}

}
