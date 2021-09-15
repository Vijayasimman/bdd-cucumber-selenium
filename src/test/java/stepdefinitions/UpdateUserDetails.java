package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import salesforce.pages.BasePage;
import salesforce.pages.ComponentReference;
import salesforce.pages.DeveloperGuide;
import salesforce.pages.HomePage;
import salesforce.pages.LightningWebComponent;

public class UpdateUserDetails extends BasePage {

	WebDriver driver;
	HomePage homePage;
	DeveloperGuide developerGuide;
	ComponentReference componentReference;
	LightningWebComponent lightningWebComponent;

	@Before("@chrome")
	public void setUpChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Before("@firefox")
	public void setUpFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Before("@ie")
	public void setUpEdge() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
	}

	@Given("^user is on salesforce developers portal$")
	public void user_is_on_salesforce_developers_portal() {
		homePage = new HomePage(driver);
		homePage.goToSalesforceDevelopersPortal();
	}

	@When("^clicks on component reference tab$")
	public void clicks_on_component_reference_tab() {
		developerGuide = new DeveloperGuide(driver);
		developerGuide.clickComponentReferenceTab();
	}

	@Then("^component reference page is loaded$")
	public void component_reference_page_is_loaded() {
		componentReference = new ComponentReference(driver);
		Assert.assertTrue("Component reference content failed to load",
				componentReference.isComponentReferenceContentDisplayed());
	}

	@When("^user searches datatable under lightning web components$")
	public void user_searches_datatable_under_lightning_web_components() {
		componentReference.searchTextInQuickFind("datatable");
	}

	@Then("^datatable is loaded$")
	public void datatable_is_loaded() {
		lightningWebComponent = new LightningWebComponent(driver);
		Assert.assertTrue("Lightning datatable content is not loaded",
				lightningWebComponent.isLightningDatatableContentDisplayed());
	}

	@When("^user selects basic data option under example$")
	public void user_selects_basic_data_option_under_example() {
		lightningWebComponent.selectBasicDataTableUnderExample();
	}

	@When("^user selects data table with inline edit option under example$")
	public void user_selects_data_table_with_inline_edit_option_under_example() {
		lightningWebComponent.selectDataTableWithInlineEditUnderExample();
	}

	@And("^clicks run button$")
	public void clicks_run_button() {
		lightningWebComponent.clickRunButton();
	}

	@Then("^preview is loaded$")
	public void preview_is_loaded() {
		Assert.assertTrue("Preview content loading failed", lightningWebComponent.isPreviewContentDisplayed());
	}

	@When("^user edits label in row 3$")
	public void user_edits_label_in_row_3() {
		lightningWebComponent.updateLabelInDatatableRow(3, "Larry Page");
	}

	@Then("^label in row 3 is updated$")
	public void label_in_row_3_is_updated() {
		Assert.assertTrue("Label in row 3 is not updated as per user input",
				lightningWebComponent.isLabelInDatatableRowContainsValue(3, "Larry Page"));
	}

	@When("^user edits website in row 3$")
	public void user_edits_website_in_row_3() {
		lightningWebComponent.updateWebsiteInDatatableRow(3, "https://google.com");
	}

	@Then("^website in row 3 is updated$")
	public void website_in_row_3_is_updated() {
		Assert.assertTrue("Website in row 3 is not updated as per user input",
				lightningWebComponent.isWebsiteInDatatableRowContainsValue(3, "https://google.com"));
	}

	@When("^user edits phone in row 3$")
	public void user_edits_phone_in_row_3() {
		lightningWebComponent.updatePhoneInDatatableRow(3, "(555)-755-6575");
	}

	@Then("^phone in row 3 is updated$")
	public void phone_in_row_3_is_updated() {
		Assert.assertTrue("Phone in row 3 is not updated as per user input",
				lightningWebComponent.isPhoneInDatatableRowContainsValue(3, "(555)-755-6575"));
	}

	@When("^user edits closeat in row 3$")
	public void user_edits_closeat_in_row_3() {
		lightningWebComponent.updateCloseAtInDatatableRow(3, "Sep 16, 2021", "12:57 PM");
	}

	@Then("^closeat in row 3 is updated$")
	public void closeat_in_row_3_is_updated() {
		Assert.assertTrue("CloseAt in row 3 is not updated as per user input",
				lightningWebComponent.isDateInDatatableRowContainsValue(3, "Sep 16, 2021"));
	}

	@When("^user edits balance in row 3$")
	public void user_edits_balance_in_row_3() {
		lightningWebComponent.updateBalanceInDatatableRow(3, "770.54");
	}

	@Then("^balance in row 3 is updated$")
	public void balance_in_row_3_is_updated() {
		Assert.assertTrue("Balance in row 3 is not updated as per user input",
				lightningWebComponent.isBalanceInDatatableRowContainsValue(3, "770.54"));
	}

	@After("@chrome")
	public void tearDownChrome() {
		if (driver != null) {
			driver.quit();
		}
	}

	@After("@firefox")
	public void tearDownFirefox() {
		if (driver != null) {
			driver.quit();
		}
	}

	@After("@ie")
	public void tearDownIE() {
		if (driver != null) {
			driver.quit();
		}
	}

}
