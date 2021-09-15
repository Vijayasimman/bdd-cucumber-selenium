package salesforce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public void waitUntilElementToBePresent(WebDriver driver, By by) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitForElementToBeVisible(WebDriver driver, By by) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementToBeInvisible(WebDriver driver, By by, long timeinSec) {
		new WebDriverWait(driver, Duration.ofSeconds(timeinSec)).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitForElementToBeClickable(WebDriver driver, By by) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void clickElementByJs(WebDriver driver, By by) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(by));
	}

	public void clickElementByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickElement(WebDriver driver, By by) {
		waitUntilElementToBePresent(driver, by);
		waitForElementToBeVisible(driver, by);
		waitForElementToBeClickable(driver, by);
		try {
			driver.findElement(by).click();
		} catch (Exception e) {
			clickElementByJs(driver, by);
		}
	}

	public String getTextFromElement(WebDriver driver, By by) {
		waitUntilElementToBePresent(driver, by);
		waitForElementToBeVisible(driver, by);
		return driver.findElement(by).getText();
	}

	public void clearTextInElement(WebDriver driver, By by) {
		waitUntilElementToBePresent(driver, by);
		waitForElementToBeVisible(driver, by);
		waitForElementToBeClickable(driver, by);
		driver.findElement(by).clear();
	}

	public void enterTextInElement(WebDriver driver, By by, String text) {
		waitUntilElementToBePresent(driver, by);
		waitForElementToBeVisible(driver, by);
		waitForElementToBeClickable(driver, by);
		driver.findElement(by).sendKeys(text);
	}

	public boolean isDisplayed(WebDriver driver, By by) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

	public boolean isDisplayed(WebDriver driver, By by, long timeoutInSec) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.presenceOfElementLocated(by));
			return true;
		} catch (TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementPresent(WebDriver driver, By by, long timeoutInSec) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.presenceOfElementLocated(by));
			return true;
		} catch (TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementVisible(WebDriver driver, By by) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementContainsText(WebDriver driver, By by, String text) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
			return true;
		} catch (TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

	public void switchToFrameByElement(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(60)).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public String getCurrentFrameName(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String currentFrame = jsExecutor.executeScript("return window.name").toString();
		return currentFrame;
	}

	public void mouseHoverOnElement(WebDriver driver, By by) {
		if (isElementPresent(driver, by)) {
			WebElement element = driver.findElement(by);
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);}else if (document.createEventObject){arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) driver).executeScript(mouseOverScript, element);
		}
	}

	public void moveToElement(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		Actions action = new Actions(driver);
		int scrollCounter = 0;
		do {
			action.moveToElement(element).build().perform();
			scrollCounter++;
			if (scrollCounter > 10) {
				break;
			}
		} while (!isElementVisible(driver, by));
	}

	public void pause(long milliSecs) {
		try {
			Thread.sleep(milliSecs);
		} catch (InterruptedException ex) {

		}
	}
}
