package salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	static By SORRY_TO_INTERRUPT_ERROR_MSG = By.cssSelector("#auraErrorMessage");

	public void goToSalesforceDevelopersPortal() {
		driver.get("https://developer.salesforce.com/docs/component-library/documentation/en/48.0/lwc");
		if (isDisplayed(driver, SORRY_TO_INTERRUPT_ERROR_MSG, 5)) {
			driver.get(driver.getCurrentUrl());
		}
	}

}
