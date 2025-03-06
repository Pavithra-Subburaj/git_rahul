package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePageFactory extends CommonPageFactory{
	
	//constructor	
			
	public LoginPagePageFactory(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	//locators---find
		
	
		@FindBy(xpath="//*[@id='username']") WebElement txt_user_loc;
//another way
		//@FindBy(how=How.XPATH,using="//*[@name='username']")WebElement txt_user_loc;
		
		@FindBy(xpath="//*[@id='password']") WebElement txt_password_loc;
		@FindBy(xpath="//*[@id='login']") WebElement btn_login_loc;
		@FindBy(xpath="//*[@id='mat-select-value-1']/span") WebElement dl_role;
		@FindBy(xpath="//span[text()=' Admin ']") WebElement dl_role_admin;
	
//Find group of elements
		//@FindBy(tagName="a") <List>WebElements links;
		
		//Action Methods
		
		
		public void SetUserName(String user )
		{
			txt_user_loc.sendKeys(user);
		}
		public void SetPassword(String pwd)
		{
			txt_password_loc.sendKeys(pwd);
		}
		public void setrole()
		{
			dl_role.click();
			dl_role_admin.click();
		}
		public void ClickLogin()
		{
			btn_login_loc.click();
		}
		
}
