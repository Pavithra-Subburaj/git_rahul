package Utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import DriverManager.DriverFactory;
import POM.CommonPageFactory;
import stepdefinition.BatchPageValidation_Navigation;

public class ConfigReader {
	public static final Logger LOGGER = LogManager.getLogger(ConfigReader.class);
	public static DriverFactory driverfactory;
//	private static String browserType=null;
	private static WebDriver driver;

//	public static void setBrowserType(String browser) {
//
//		browserType = browser;
//
//	}

	public static String getBrowserType() throws Throwable {

		if (CommonPageFactory.BROWSER!= null)

			return CommonPageFactory.BROWSER;

		else

			throw new RuntimeException("browser not specified in the testng.xml");

	}
	
	public static String getUsername() throws Throwable {

		if (CommonPageFactory.USERNAME!= null)

			return CommonPageFactory.USERNAME;

		else

			throw new RuntimeException("browser not specified in the testng.xml");

	}
	public static String getPassword() throws Throwable {

		if (CommonPageFactory.PASSWORD!= null)

			return CommonPageFactory.PASSWORD;

		else

			throw new RuntimeException("browser not specified in the testng.xml");

	}
	public static String getUrl() throws Throwable {

		if (CommonPageFactory.APP_URL!= null)

			return CommonPageFactory.APP_URL;

		else

			throw new RuntimeException("browser not specified in the testng.xml");

	}
	public static String gethomeUrl() throws Throwable {

		if (CommonPageFactory.HOME_URL!= null)

			return CommonPageFactory.HOME_URL;

		else

			throw new RuntimeException("browser not specified in the testng.xml");

	}
	public static String getbatchUrl() throws Throwable {

		if (CommonPageFactory.BATCH_URL!= null)

			return CommonPageFactory.BATCH_URL;

		else

			throw new RuntimeException("browser not specified in the testng.xml");

	}
	
	
	
	public  void loadProperties()
	{
		System.out.println("I am inside load properties of Propertiesconfig");
		Properties properties = new Properties();
		FileInputStream fis =null;
		try {

			//properties.load(getClass().getResourceAsStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Utlils\\config.properties"));
			fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\utils\\config.properties");
			properties=new Properties();
			properties.load(fis);
			fis.close();
			
			String browser=properties.getProperty("browser");
			System.out.println("Browser "+browser);
			LOGGER.info ("get Property Browser");
			driverfactory = new DriverFactory();
			driverfactory.launchBrowser(browser);
			driver=driverfactory.getDriver();
			LOGGER.info ("initializeDrivers for " + browser);
			CommonPageFactory.BROWSER=properties.getProperty("browser"); // set values of browser from cross browser test runner
			CommonPageFactory.APP_URL=properties.getProperty("appURL");
			CommonPageFactory.USERNAME=properties.getProperty("username");
			CommonPageFactory.PASSWORD=properties.getProperty("password");
			CommonPageFactory.HOME_URL=properties.getProperty("homepageurl");
			CommonPageFactory.BATCH_URL=properties.getProperty("batchpageurl");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}

	}

	public void setPropertiesforCrossbrowsertesting(String browser) {
		
		System.out.println("I am inside cross browser testing load properties of Propertiesconfig");
		Properties properties = new Properties();
		FileInputStream fis =null;
		try {

			//properties.load(getClass().getResourceAsStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Utlils\\config.properties"));
			fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\utils\\config.properties");
			properties=new Properties();
			properties.load(fis);
			fis.close();
			
			String browser1=properties.getProperty("browser");
			System.out.println("Browser "+browser1);
			LOGGER.info ("get Property Browser");
			driverfactory = new DriverFactory();
			driverfactory.launchBrowser(browser);
			driver=driverfactory.getDriver();
			LOGGER.info ("initializeDrivers for " + browser1);
			CommonPageFactory.BROWSER=properties.getProperty("browser"); // set values of browser from cross browser test runner
			CommonPageFactory.APP_URL=properties.getProperty("appURL");
			CommonPageFactory.USERNAME=properties.getProperty("username");
			CommonPageFactory.PASSWORD=properties.getProperty("password");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		ConfigReader.driver = driver;
	}
	
	public static void initElements() {
		PageFactory.initElements(DriverFactory.getDriver(), CommonPageFactory.class);
	}
}
