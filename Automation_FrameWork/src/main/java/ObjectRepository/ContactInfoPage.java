package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {// Rule 1

	// rule 2 Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;

	// rule 3 Initialization
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 4 Utilization
	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	// Business library
	/**
	 * This method will used to capture the header info and return it to caller
	 * @return 
	 * 
	 * @return
	 */
	public String contactHeaderText() {
		return headerInfo.getText();

	}

}
