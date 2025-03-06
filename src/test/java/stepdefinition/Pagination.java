package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;
import DriverManager.DriverFactory;
import POM.BatchPagePageFactory;
import POM.HomePagePageFactory;
import POM.LoginPagePageFactory;
import Utilities.ConfigReader;

public class Pagination {
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	LoginPagePageFactory lp;
	BatchPagePageFactory bp;
	HomePagePageFactory hp;
	public Pagination() {
	        driver = DriverFactory.getDriver();
	        bp = new BatchPagePageFactory(driver);
	    }
	
	@When("Admin clicks next page link on the data table")
	public void admin_clicks_next_page_link_on_the_data_table() {
	   
	    int totalPages = bp.getTotalPages();
	    for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
	        System.out.println("Page: " + currentPage);
	        bp.clickNextPageIfEnabled();
	    }
	}

	@Then("Admin should see the Next enabled link")
	public void admin_should_see_the_next_enabled_link() {
	    Assert.assertTrue("Next button should be disabled on last page", !bp.nextright().isEnabled());
	}
	
	@When("Admin clicks last page link on the data table")
	public void admin_clicks_last_page_link_on_the_data_table() {
	    
	    bp.btn_lastnext();
	}

	@Then("Admin should see the last page link with next page link disabled on the table")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {
	    Assert.assertFalse("Next button should be disabled on last page", bp.nextright().isEnabled());
	}
	@When("Admin clicks previous page link on the data table")
	public void admin_clicks_previous_page_link_on_the_data_table() throws InterruptedException {
		int totalPages = bp.getTotalPages();
		for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
		bp.clickNextPage();
		}
		for (int currentPage = totalPages; currentPage >= 1; currentPage--) {
		    System.out.println("Page: " + currentPage);
		    bp.clickPreviousPageIfEnabled();
		}
	    
	}
	@Then("Admin should see the previous page on the table")
	public void admin_should_see_the_previous_page_on_the_table() {
		 Assert.assertTrue("Next button should be disabled on last page", !bp.btn_previous().isEnabled());
	}
	@When("Admin clicks first page link on the data table")
	public void admin_clicks_first_page_link_on_the_data_table() {
		int totalPages = bp.getTotalPages();
		for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
		bp.clickNextPage();
		}
		bp.click_First_prev();
	}

	@Then("Admin should see the very first page on the data table")
	public void admin_should_see_the_very_first_page_on_the_data_table() {
		String text= bp.txt_showing().getText();
		System.out.println(text);
		Assert.assertTrue("Showing 1 to 10 text is not displayed",text.contains("Showing 1 to"));

	    
	}


}