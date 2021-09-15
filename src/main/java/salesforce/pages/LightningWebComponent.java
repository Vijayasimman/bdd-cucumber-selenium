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
	static final By BASIC_DATA_TABLE_OPTION = By.xpath("//span[@title='Basic Data Table']");
	static final By RUN_BTN = By.xpath("//*[contains(@class,'slds-button') and text()='Run']");
	static final By PREVIEW_TABLE = By.xpath("//tr[3]");
	static final By LABEL_ROW_3 = By.xpath("//tr[3]/th");
	static final By LABEL_ROW_3_LABEL_EDIT_BTN = By.xpath("(//tr[3]//button)[2]");
	static final By LABEL_ROW_3_WEBSITE_EDIT_BTN = By.xpath("(//tr[3]//button)[3]");
	static final By LABEL_ROW_3_PHONE_EDIT_BTN = By.xpath("(//tr[3]//button)[4]");
	static final By LABEL_ROW_3_CLOSEAT_EDIT_BTN = By.xpath("(//tr[3]//button)[5]");
	static final By LABEL_ROW_3_BALANCE_EDIT_BTN = By.xpath("(//tr[3]//button)[6]");
	static final By LABEL_ROW_3_TXT = By.xpath("//tr[3]/th//lightning-base-formatted-text");
	static final By LABEL_TXT_BOX = By.xpath("//input[@name='dt-inline-edit-text']");
	static final By WEBSITE_TXT_BOX = By.xpath("//input[@name='dt-inline-edit-url']");
	static final By PHONE_TXT_BOX = By.xpath("//input[@name='dt-inline-edit-phone']");
	static final By DATE_TXT_BOX = By.xpath("(//input[@name='dt-inline-edit-datetime'])[1]");
	static final By TIME_TXT_BOX = By.xpath("(//input[@name='dt-inline-edit-datetime'])[2]");
	static final By BALANCE_TXT_BOX = By.xpath("//input[@name='dt-inline-edit-currency']");
	static final By PREVIEW_HEADER = By.xpath("//span[@title='Label']");
	static final By IFRAME_PREVIEW = By.xpath("//iframe[@name='preview']");
	static final By LIGHTNING_SPINNER = By.xpath("//*[contains(@class,'slds-spinner__dot-a')]");

	public boolean isLightningDatatableContentDisplayed() {
		return isDisplayed(driver, LIGHTNING_DATATABLE_CONTENT);
	}

	public void selectBasicDataTableUnderExample() {
		clickElement(driver, EXAMPLE_COMBOBOX);
		clickElement(driver, BASIC_DATA_TABLE_OPTION);
		pause(5000);
	}

	public void selectDataTableWithInlineEditUnderExample() {
		clickElement(driver, EXAMPLE_COMBOBOX);
		clickElement(driver, DATA_TABLE_WITH_INLINE_EDIT_OPTION);
		pause(20000);
	}

	public void clickRunButton() {
		clickElement(driver, RUN_BTN);
		pause(10000);
	}

	public boolean isPreviewContentDisplayed() {
		switchToFrameByElement(driver, driver.findElements(IFRAME_PREVIEW).get(0));
		switchToFrameByElement(driver, driver.findElement(IFRAME_PREVIEW));
		return isDisplayed(driver, PREVIEW_TABLE);
	}

	public void updateLabelInDatatableRow(int rowNumberToEdit, String value) {
		clickElement(driver, LABEL_ROW_3_LABEL_EDIT_BTN);
		clearTextInElement(driver, LABEL_TXT_BOX);
		enterTextInElement(driver, LABEL_TXT_BOX, value);
		clickElement(driver, PREVIEW_HEADER);
	}

	public boolean isLabelInDatatableRowContainsValue(int rowNumberToEdit, String value) {
		return isElementContainsText(driver, By.xpath("//tr[" + rowNumberToEdit + "]//lightning-base-formatted-text"),
				value);
	}

	public void updateWebsiteInDatatableRow(int rowNumberToEdit, String value) {
		clickElement(driver, LABEL_ROW_3_WEBSITE_EDIT_BTN);
		clearTextInElement(driver, WEBSITE_TXT_BOX);
		enterTextInElement(driver, WEBSITE_TXT_BOX, value);
		clickElement(driver, PREVIEW_HEADER);
	}

	public boolean isWebsiteInDatatableRowContainsValue(int rowNumberToEdit, String value) {
		return isElementContainsText(driver, By.xpath("//tr[" + rowNumberToEdit + "]//lightning-formatted-url/a"),
				value);
	}

	public void updatePhoneInDatatableRow(int rowNumberToEdit, String value) {
		clickElement(driver, LABEL_ROW_3_PHONE_EDIT_BTN);
		clearTextInElement(driver, PHONE_TXT_BOX);
		enterTextInElement(driver, PHONE_TXT_BOX, value);
		clickElement(driver, PREVIEW_HEADER);
	}

	public boolean isPhoneInDatatableRowContainsValue(int rowNumberToEdit, String value) {
		return isElementContainsText(driver, By.xpath("//tr[" + rowNumberToEdit + "]//lightning-formatted-phone/a"),
				value);
	}

	public void updateCloseAtInDatatableRow(int rowNumberToEdit, String dateValue, String timeValue) {
		clickElement(driver, LABEL_ROW_3_CLOSEAT_EDIT_BTN);
		clearTextInElement(driver, DATE_TXT_BOX);
		enterTextInElement(driver, DATE_TXT_BOX, dateValue);
		clearTextInElement(driver, TIME_TXT_BOX);
		enterTextInElement(driver, TIME_TXT_BOX, timeValue);
		clickElement(driver, PREVIEW_HEADER);
	}

	public boolean isDateInDatatableRowContainsValue(int rowNumberToEdit, String dateValue) {
		return isElementContainsText(driver, By.xpath("//tr[" + rowNumberToEdit + "]//lightning-formatted-date-time"),
				dateValue);
	}

	public void updateBalanceInDatatableRow(int rowNumberToEdit, String value) {
		clickElement(driver, LABEL_ROW_3_BALANCE_EDIT_BTN);
		clearTextInElement(driver, BALANCE_TXT_BOX);
		enterTextInElement(driver, BALANCE_TXT_BOX, value);
		clickElement(driver, PREVIEW_HEADER);
	}

	public boolean isBalanceInDatatableRowContainsValue(int rowNumberToEdit, String value) {
		return isElementContainsText(driver, By.xpath("//tr[" + rowNumberToEdit + "]//lightning-formatted-number"),
				value);
	}

}
