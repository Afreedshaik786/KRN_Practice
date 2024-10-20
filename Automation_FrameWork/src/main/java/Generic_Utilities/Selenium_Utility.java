package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all generic method related to Selenium
 * 
 * @author SHAIK AFREED AHAMAD
 */
public class Selenium_Utility {

	/**
	 * This method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {

		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {

		driver.manage().window().minimize();
	}

	/**
	 * This method will add 10sec of implicit wait
	 * 
	 * @param driver
	 */
	public void addimplicitylyWait(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method will wait for 10s for element to be visible
	 * 
	 * @param driver
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will handle dropDown by index
	 * 
	 * @param element
	 * @param index
	 */

	public void handleDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method will handle dropDown by value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method will handle dropDown by text
	 * 
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method will perform mouse hovering action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method will perform right click action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method will perform double click action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will perform drag and drop action
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}

	/**
	 * 
	 * This method will perform scroll down action by 500units
	 * 
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver) { // we can scroll window for left,right,up n down by using asctions
														// class or javascript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}

	/**
	 * 
	 * This method will handle frame by using frame index
	 * 
	 * @param driver
	 * @param frame  index
	 */
	public void handleFrame(WebDriver driver, int frameindex) {
		driver.switchTo().frame(frameindex);
	}

	/**
	 * This method will handle frame by using frame name or id
	 * 
	 * @param driver
	 * @param framenameorID
	 */
	public void handleFrame(WebDriver driver, String framenameorID) {
		driver.switchTo().frame(framenameorID);
	}

	/**
	 * This method will handle frame by using frame web element
	 * 
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * This method will capture screenshot and store it in a folder
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShot\\" + screenShotName + ".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();// for extent reports
	}

}
