package Hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import Utilities.*;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	@Before(order = 1)
	public void launchBrowser() throws Throwable {
		ConfigReader config =new ConfigReader();
		config.loadProperties();
		String browser=config.getBrowserType();
		DriverFactory.launchBrowser(browser);
		ConfigReader.initElements();
	}

@After(order = 1)
	public void quitBrowser() {
		DriverFactory.getDriver().quit();
	}

	@After(order = 2)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}
