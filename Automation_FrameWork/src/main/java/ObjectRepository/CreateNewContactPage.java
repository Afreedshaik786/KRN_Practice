package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.Selenium_Utility;

public class CreateNewContactPage extends Selenium_Utility {// Rule 1

	// rule 2 Declaration
	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;

	// rule 3 Initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 4 Utilization
	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getleadSourceDropDown() {
		return leadSourceDropDown;
	}

	// Business library
	/**
	 * This method will used to create new contact with mandatory fields
	 * 
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		lastName.sendKeys(LASTNAME);
		saveBtn.click();
	}

	/**
	 * This method will used to create new contact with lead Source DropDown
	 * 
	 * @param LASTNAME
	 * @param leadSourceValue
	 */
	public void createNewContact(String LASTNAME, String leadSourceValue) {
		lastName.sendKeys(LASTNAME);
		handleDropdown(leadSourceDropDown, leadSourceValue);
		saveBtn.click();

	}

}
