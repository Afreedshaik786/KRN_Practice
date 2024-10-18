package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage  {// Rule 1

	// rule 2 Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement contactLookUpImg;

	// rule 3 Initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 4 Utilization
	public WebElement getContactLookUpImg() {
		return contactLookUpImg;
	}

	// Business library
	/**
	 * This method will click on create contact look up image
	 */
	public void clickOnLookUp() {
		contactLookUpImg.click();
	}

}
