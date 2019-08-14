package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.net.ssl.SSLEngineResult.Status;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Business_Methods.Basesetupdriver;

public class Commonmethods {
	static Logger log = Logger.getLogger("devpinoyLogger");
	static WebDriver driver;

	public static void click(WebElement webElement) throws InterruptedException {
		try {
			if (webElement.isDisplayed()) {
				webElement.click();
				Reports.testStatus("pass", "Clicked on Login Button");
				System.out.println("Testcase passing for correct testcase");
				
			}
			else
			{
				Reports.testStatus("fail","Cannot Click on The Login Button");
				System.out.println("Failing because of wrong Element");
			}
		} catch (StaleElementReferenceException e) {
		}
	}

	public static void jsClickByXPath(WebDriver driver, String NormalXpath) {
		WebElement element = driver.findElement(By.xpath(NormalXpath));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void jsTypeByXPath(WebDriver driver, String NormalXpath, String InputData) {
		WebElement element = driver.findElement(By.xpath(NormalXpath));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		executor.executeScript("arguments[0].type ='" + InputData + "';", element);
	}

	public static void actionClick(WebDriver driver, WebElement webElement) throws InterruptedException {
		try {
			if (webElement.isEnabled()) {
				webElement.click();
				Reports.testStatus("pass", "Click on Action Method");
			}
			else
			{
				System.out.println("Cannot Click on The Element");
				Reports.testStatus("fail", " cannot Click on Action Method");
			}
		} catch (StaleElementReferenceException e) {
		}
	}

	public static void actionType(WebDriver driver, WebElement webElement, CharSequence... keysToSend) {
		try {
			if (webElement.isEnabled()) {
				webElement.sendKeys(keysToSend);
			}
		} catch (StaleElementReferenceException e) {
		}
	}
		
	/*---Method Used For Handling Windows
	 *  By Koushick.s
	 *  ---------------------------------------------------*/
	
	public static void Handle_window_tabs(int i) throws InterruptedException
	{
		ArrayList<String> tabs = new ArrayList<String> (Basesetupdriver.driver.getWindowHandles());
		Basesetupdriver.driver.switchTo().window(tabs.get(i));
		Reports.testStatus("pass", "Switched to window");
	}
	
	/*---Method Used For Taking ScreenShot and Attaching to Document
	 *  By Koushick.s
	 *  ---------------------------------------------------*/
	
	public static void ScreenShot() throws InvalidFormatException, IOException
	{
		Attaching_Screenshot_to_document.attachscreenshot(Basesetupdriver.driver);
	}
	
	public static void doubleClick(WebDriver driver, WebElement webElement) {
		try {
			Actions action = new Actions(driver).doubleClick(webElement);
			action.build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			log.info("Element " + webElement + " was not clickable " + e.getStackTrace());
		}
	}

	public static void clickAndHold(WebDriver driver, WebElement webElement) {
		try {
			Actions builder = new Actions(driver);
			builder.clickAndHold(webElement).build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			log.info("Element " + webElement + " was not clickable " + e.getStackTrace());
		}
	}

	public static void clear(WebElement webElement) {
		webElement.clear();
	}

	public static void actionClear(WebDriver driver, WebElement webElement) {
		webElement.click();
		Actions action = new Actions(driver);
		webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");
		action.sendKeys(Keys.DELETE);
	}

	public static String clearAndType(WebElement webElement, String keysToSend) {
		webElement.clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webElement.sendKeys(keysToSend);
		return keysToSend;
	}

	public static String sendKeys(WebElement webElement, String keysToSend) throws InterruptedException {
		
		if(webElement.isDisplayed())
		{
		webElement.sendKeys(keysToSend);
		Reports.testStatus("pass", "Sending valid " +keysToSend);
		System.out.println("Testcase passing for correct testcase");
		}
		else
		{
			System.out.println("Failing because of wrong data");
			Reports.testStatus("fail", "Invalid " + keysToSend );
		}
	
		return keysToSend;
	}

	public static void submit(WebElement webElement) {
		
		webElement.submit();
	}

	public static void keyDown(Actions actions, Keys keys) {
		actions.keyDown(keys);
	}

	public static void keyUp(Actions actions, Keys keys) {
		actions.keyUp(keys);
	}

	public static String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public static void mouseOver(WebDriver driver, WebElement webElement) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(webElement).build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			log.info("Element " + webElement + " was not mouseOver " + e.getStackTrace());
		}
	}

	public static void mouseOverAndClick(WebDriver driver, WebElement webElement) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(webElement).click().build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			log.info("Element " + webElement + " was not mouseOver " + e.getStackTrace());
		}
	}

	public static void selectCheckBox(WebElement element) {
		try {
			if (element.isSelected()) {
				log.info("Checkbox: " + element + "is already selected");
			} else {
				element.click();
			}
		} catch (Exception e) {
			log.info("Unable to select the checkbox: " + element);
		}
	}

	public static void deSelectCheckBox(WebElement element) {
		try {
			if (element.isSelected()) {
				element.click();
			} else {
				log.info("Checkbox: " + element + "is already deselected");
			}
		} catch (Exception e) {
			log.info("Unable to deselect checkbox: " + element);
		}
	}

	public static void selectByIndex(WebElement element, String inputData) {
		try {
			Integer index = new Integer(inputData);
			Select selectBox = new Select(element);
			selectBox.selectByIndex(index);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static void selectByValue(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.selectByValue(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static String selectByVisibletext(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.selectByVisibleText(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
		return inputData;
	}

	public static void deSelectByVisibletext(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.deselectByVisibleText(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static void deSelectByIndex(WebElement element, String inputData) {
		try {
			Integer index = new Integer(inputData);
			Select selectBox = new Select(element);
			selectBox.deselectByIndex(index);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static void deSelectByValue(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.deselectByValue(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static void Alertaccept(WebDriver driver) {
		try {
			Alert obj = driver.switchTo().alert();
			obj.accept();
		} catch (Exception e) {
			log.info("Unable to accept the alert: " + e);
		}
	}

	public static void AlertDismiss(WebDriver driver) {
		try {
			Alert obj = driver.switchTo().alert();
			obj.dismiss();
		} catch (Exception e) {
			log.info("Unable to handle the alert: " + e);
		}
	}

	public static String GetText(WebElement element) {
		String obj = element.getText();
		return obj;
	}

	public static void pageDown(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)", "");
	}

	public static void switchToFrame(WebDriver driver, String frameName) {
		try {
			driver.switchTo().frame(frameName);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame " + frameName + e.getStackTrace());
		}
	}

	public static void switchToFrame(WebDriver driver, int frameIndex) {
		try {
			driver.switchTo().frame(frameIndex);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frameIndex + e.getStackTrace());
		}
	}

	public static void Enter(WebElement ele, WebDriver driver) {
		ele.sendKeys(Keys.DOWN);
		ele.sendKeys(Keys.ENTER);
	}

	public static void RobotEnter(WebDriver driver) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void Esc(WebDriver driver) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public static void screenShot(WebDriver driver, String inputData) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(inputData));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
