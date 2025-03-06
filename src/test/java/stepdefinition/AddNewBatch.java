package stepdefinition;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import DriverManager.DriverFactory;
import POM.BatchPagePageFactory;
import POM.HomePagePageFactory;
import POM.LoginPagePageFactory;
import Utilities.ConfigReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class AddNewBatch {
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	LoginPagePageFactory lp;
	BatchPagePageFactory bp;
	HomePagePageFactory hp;
	Properties properties = new Properties();
	Actions act;
	List<WebElement> header_batch;
	
	public AddNewBatch() {
        driver = DriverFactory.getDriver();
    }
	@Given("Admin is on batch page")
	public void admin_is_on_batch_page() throws Throwable {
		bp = new BatchPagePageFactory(driver);
		bp.click_batches_btn();
		driver.navigate().refresh();
		Assert.assertEquals(driver.getCurrentUrl(), config.getbatchUrl());
	}
	@When("Admin clicks Batch on the navigation bar")
	public void admin_clicks_batch_on_the_navigation_bar() {
	    bp.Click_batch_btn();
	}
	@Then("Admin should see sub menu in menu bar as Add New Batch")
	public void admin_should_see_sub_menu_in_menu_bar_as_add_new_batch() {
		Assert.assertTrue(bp.AddNewBatch_btn().isDisplayed());
	}
	@Given("Admin is on the home page")
	public void admin_is_on_the_home_page() throws Throwable {
		bp = new BatchPagePageFactory(driver);
		Assert.assertTrue(bp.homepageValidation().isDisplayed());
		Assert.assertEquals(driver.getCurrentUrl(), config.gethomeUrl());
	}

	@When("Admin clicks on Add New batch under the batch menu bar")
	public void admin_clicks_on_add_new_batch_under_the_batch_menu_bar() {
		 bp.Click_batch_btn();
		 bp.click_AddNewBatch_btn();
	}

	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		Assert.assertTrue(bp.BatchDetails_text().isDisplayed());
	}

}
