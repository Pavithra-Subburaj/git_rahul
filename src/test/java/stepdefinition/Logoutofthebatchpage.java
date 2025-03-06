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

public class Logoutofthebatchpage {
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	LoginPagePageFactory lp;
	BatchPagePageFactory bp;
	HomePagePageFactory hp;
	public Logoutofthebatchpage() {
	        driver = DriverFactory.getDriver();
	    }
	@When("Admin clicks on the logout button")
	public void admin_clicks_on_the_logout_button() throws InterruptedException {
		bp = new BatchPagePageFactory(driver);
		bp.click_BatchLogout_btn();
	}

	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(),config.getUrl());
	    
	}
}
