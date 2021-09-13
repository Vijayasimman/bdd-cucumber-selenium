package salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComponentReference extends BasePage {

	private WebDriver driver;

	public ComponentReference(WebDriver driver) {
		this.driver = driver;
	}

	static final By COMPONENT_REFERENCE_CONTENT = By.cssSelector("div[class='main show-sidebar']");
	static final By QUICK_FIND_TXT_BOX = By.xpath("//input[@name='Quick Find']");
	static final By LIGHTNING_WEB_COMPONENTS_DATATABLE_OPTION = By.xpath(
			"//*[text()='Lightning Web Components']/following::*[@class='slds-tree_container'][1]//*[text()='datatable']");

	public boolean isComponentReferenceContentDisplayed() {
		return isDisplayed(driver, COMPONENT_REFERENCE_CONTENT);
	}

	public void searchTextInQuickFind(String text) {
		enterTextInElement(driver, QUICK_FIND_TXT_BOX, text);
		clickElement(driver, LIGHTNING_WEB_COMPONENTS_DATATABLE_OPTION);
	}
}
