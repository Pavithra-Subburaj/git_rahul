package testrunner;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Utilities.ConfigReader;

import Utilities.*;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/resources/features"}, glue = {"stepdefinition","Hooks"})

public class runner extends AbstractTestNGCucumberTests{

	@BeforeTest
	@Parameters( {"browsertype"})
	public void defineBrowser(String browser) throws Throwable {
		ConfigReader configreader = new ConfigReader();
		configreader.setPropertiesforCrossbrowsertesting(browser);

	}

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}