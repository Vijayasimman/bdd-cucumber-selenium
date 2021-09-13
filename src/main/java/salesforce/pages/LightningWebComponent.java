package salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LightningWebComponent extends BasePage {

	private WebDriver driver;

	public LightningWebComponent(WebDriver driver) {
		this.driver = driver;
	}

	static final By LIGHTNING_DATATABLE_CONTENT = By.xpath("//*[@data-bundle-descriptor='lightning-datatable']");
	static final By EXAMPLE_COMBOBOX = By.xpath("//input[@role='combobox']");
	static final By DATA_TABLE_WITH_INLINE_EDIT_OPTION = By.xpath("//span[@title='Data Table with Inline Edit']");
	static final By RUN_BTN = By.xpath("//*[contains(@class,'slds-button') and text()='Run']");
	static final By PREVIEW_TABLE = By.xpath("//tr");
	static final By LABEL_ROW_3 = By.xpath("//tr[3]/th");
	static final By LABEL_ROW_3_EDIT_BTN = By.xpath("//tr[3]/th//button");
	static final By LABEL_ROW_3_TXT = By.xpath("//tr[3]/th//lightning-base-formatted-text");
	static final By LABEL_TXT_BOX = By.cssSelector("input[name='dt-inline-edit-text']");
	static final By PREVIEW_HEADER = By.xpath("//div[text()='Preview']");

	public boolean isLightningDatatableContentDisplayed() {
		return isDisplayed(driver, LIGHTNING_DATATABLE_CONTENT);
	}

	public void selectDataTableWithInlineEditUnderExample() {
		driver.navigate().refresh();
		clickElement(driver, EXAMPLE_COMBOBOX);
		clickElement(driver, DATA_TABLE_WITH_INLINE_EDIT_OPTION);
	}

	public void clickRunButton() {
		clickElement(driver, RUN_BTN);
	}

	public boolean isPreviewContentDisplayed() {
		switchToFrameWithIndex(driver, 0);
		return isDisplayed(driver, PREVIEW_TABLE, 30);
	}

	public void updateLabelInDatatableRow(int rowNumberToEdit, String value) {
		mouseHoverOnElement(driver, By.xpath("//tr[" + rowNumberToEdit + "]/th"));
		clickElement(driver, By.xpath("//tr[" + rowNumberToEdit + "]/th//button"));
		clearTextInElement(driver, LABEL_TXT_BOX);
		enterTextInElement(driver, LABEL_TXT_BOX, value);
		clickElement(driver, PREVIEW_HEADER);
	}

	public boolean isLabelInDatatableRowContainsValue(int rowNumberToEdit, String value) {
		return isElementContainsText(driver,
				By.xpath("//tr[" + rowNumberToEdit + "]/th//lightning-base-formatted-text"), value);
	}

}
