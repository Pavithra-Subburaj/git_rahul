package stepdefinition;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.DriverFactory;
import POM.BatchPagePageFactory;
import POM.HomePagePageFactory;
import POM.LoginPagePageFactory;
import Utilities.ConfigReader;
import io.cucumber.java.en.*;

public class SearchTextboxvalidation {
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	LoginPagePageFactory lp;
	BatchPagePageFactory bp;
	HomePagePageFactory hp;
	Properties properties = new Properties();
	Actions act;
	List<WebElement> header_batch;
	
	public SearchTextboxvalidation() {
        driver = DriverFactory.getDriver();
    }
	@When("Admin enters the batch name in the search text box {string}")
	public void admin_enters_the_batch_name_in_the_search_text_box(String text) throws InterruptedException {
		bp = new BatchPagePageFactory(driver);
		act = new Actions(driver);
		act.moveToElement(bp.txt_searchbox())
		        .click()
		        .sendKeys(text);
		act.click().pause(Duration.ofSeconds(2)).perform();
	}

	@Then("Admin should see the filtered batches in the data table {string}")
	public void admin_should_see_the_filtered_batches_in_the_data_table(String text) throws InterruptedException {
		
		Assert.assertEquals(bp.search().getText(),text);
		
		
	}
}
