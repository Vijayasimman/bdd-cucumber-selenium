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
