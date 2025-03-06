package stepdefinition;

import io.cucumber.java.en.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import DriverManager.DriverFactory;
import POM.LoginPagePageFactory;
import Utilities.ConfigReader;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import POM.*;
import io.qameta.allure.Allure;

public class BatchPageValidation_Navigation {
	static WebDriver driver;
	static ConfigReader config = new ConfigReader();
	LoginPagePageFactory lp;
	Actions act;
	static BatchPagePageFactory bp;
	HomePagePageFactory hp;
	Properties properties = new Properties();
	static List<WebElement> header_batch;
	@Before("@batch")
	public void setUP() throws Throwable {
//setup		

		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp = new LoginPagePageFactory(DriverFactory.getDriver());
		act=new Actions(driver);
		driver.get(config.getUrl());
		lp.SetUserName(config.getUsername());
		lp.SetPassword(config.getPassword());
		lp.setrole();
		lp.ClickLogin();

	}

	@Given("Admin is on the home Page")
	public void admin_is_on_the_home_page() throws Throwable {
		bp = new BatchPagePageFactory(driver);
		Assert.assertTrue(bp.homepageValidation().isDisplayed());
		Assert.assertEquals(driver.getCurrentUrl(), config.gethomeUrl());

	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {

		bp.Click_batch_btn();
	}
	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() throws Throwable {
		driver.navigate().refresh();
		Assert.assertEquals(driver.getCurrentUrl(), config.getbatchUrl());

	}
	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String lms_header) {
		Assert.assertEquals(lms_header, bp.LMS_header().getText());
	}

	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String managebatch_header) {
		Assert.assertEquals(managebatch_header, bp.batch_Managebatch_header().getText());
	}

	@Then("Admin should see the disabled Delete Icon under the header")
	public void admin_should_see_the_disabled_delete_icon_under_the_header() {
		
		boolean isEnabled = bp.batch_deleteall().isEnabled();
		Assert.assertFalse(isEnabled);
	}
	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
		Assert.assertTrue(bp.Pagination_right().isEnabled());
	}
	@Then("Admin should see the checkbox in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		Assert.assertTrue(bp.checkbox_header().isEnabled());
	}

	@Then("Admin should see the datatable headers {string}")
	public void admin_should_see_the_datatable_headers(String header) {
		header_batch=bp.header();
		for(WebElement table_header:header_batch)
		{
			Assert.assertTrue(table_header.isDisplayed());
		}
		List<String> header_text=bp.header_string();
		Assert.assertTrue(header_text.contains(header));
		
	}
	
	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		header_batch=bp.header_sorticon();
		for(WebElement table_header_sort:header_batch)
		{
			Assert.assertTrue(table_header_sort.isDisplayed());
		}
	}
	@Then("Admin should see the checkbox in each row")
	public void admin_should_see_the_checkbox_in_each_row()
	{
		List<WebElement> all_checkbox;
		int totalPages = bp.getTotalPages();
		for (int i = 0; i <totalPages; i++) {
		    all_checkbox = new ArrayList<>(bp.pagiantion_checkbox());
		    for(WebElement checkbox:all_checkbox)
		    {
		    	Assert.assertTrue(checkbox.isEnabled());
		    }
		   bp.clickNextPage();
		}
	}
	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		List<WebElement> all_delete_btn;
		int totalPages = bp.getTotalPages();
		for (int i = 0; i <totalPages; i++) {
		   all_delete_btn = new ArrayList<>(bp.pagiantion_delete_btn());
		    for(WebElement btn:all_delete_btn)
		    {
		    	Assert.assertTrue(btn.isEnabled());
		    }
		   bp.clickNextPage();
		}
	}
	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		List<WebElement> all_edit_btn;
		int totalPages = bp.getTotalPages();
		System.out.println("Total pages: " + totalPages);
		for (int i = 0; i <totalPages; i++) {
//		    System.out.println("Iteration " + (i + 1));
		    // Collect and print checkboxes on the current page
		   all_edit_btn = new ArrayList<>(bp.pagiantion_edit_btn());
		    for(WebElement btn:all_edit_btn)
		    {
//		    	System.out.println(btn);
		    	Assert.assertTrue(btn.isEnabled());
		    }

		    // Click the right pagination button using JavaScript
		   bp.clickNextPage();
		}
	}
	
}

