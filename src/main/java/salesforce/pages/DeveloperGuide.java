package salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeveloperGuide extends BasePage {

	private WebDriver driver;

	public DeveloperGuide(WebDriver driver) {
		this.driver = driver;
	}

	static final By COMPONENT_REFERENCE_TAB = By.xpath("//div[@class='slds-grid']//span[@title='Component Reference']");

	public void clickComponentReferenceTab() {
		clickElement(driver, COMPONENT_REFERENCE_TAB);
	}
}
