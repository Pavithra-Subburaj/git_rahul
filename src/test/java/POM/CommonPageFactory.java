package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommonPageFactory {
	public WebDriver driver;
	public static String BROWSER;
	public static String USERNAME;
	public static String PASSWORD;
	public static String APP_URL;
	public static String HOME_URL;
	public static String BATCH_URL;
	
	public CommonPageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
