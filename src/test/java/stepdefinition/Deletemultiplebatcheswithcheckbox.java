package stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.*;
import DriverManager.DriverFactory;
import POM.BatchPagePageFactory;
import POM.HomePagePageFactory;
import POM.LoginPagePageFactory;
import Utilities.ConfigReader;


public class Deletemultiplebatcheswithcheckbox {
	
	WebDriver driver;
	Actions act;
	ConfigReader config = new ConfigReader();
	LoginPagePageFactory lp;
	BatchPagePageFactory bp;
	HomePagePageFactory hp;
	public Deletemultiplebatcheswithcheckbox() {
	        driver = DriverFactory.getDriver();
	        bp = new BatchPagePageFactory(driver);
	        act=new Actions(driver);
	    }

@When("Admin clicks on the delete icon under the Manage batch header")
public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header() throws InterruptedException {
	 int totalPages = bp.getTotalPages();
	    System.out.println("Total pages: " + totalPages);	
	    boolean elementFound = false;
	    for (int currentPage = 1; currentPage <= totalPages && !elementFound; currentPage++) {
	        List<WebElement> dataTableElements = bp.all_data();
	        for (WebElement element : dataTableElements) {
	            try {
	                WebElement editBatchElement = bp.edit_element();
	                System.out.println("delete batch text: " + editBatchElement.getText());
	                elementFound = true;
	                act.moveToElement(bp.single_check_delete()).click().perform();
	                bp.all_delete().click();
	                bp.delete_confirm_popup_yes().click();;
                 
	                break;
	            } catch (NoSuchElementException e) {
	                System.out.println("Edit batch element not found");
	            }
	        }
	        if (!elementFound) {
	            bp.clickNextPage();
	        }
	    }
}

@When("Admin clicks multiple checkbox and clicks on the delete icon under the Manage batch header")
public void admin_clicks_multiple_checkbox_and_clicks_on_the_delete_icon_under_the_manage_batch_header() {
	int paginationPageCount = bp.getTotalPages();
    System.out.println("Total pages: " + paginationPageCount);

    List<WebElement> allElements = new ArrayList<>();

    for (int currentPage = 1; currentPage <= paginationPageCount; currentPage++) {
        List<WebElement> dataTableElements = bp.all_data();
        for (WebElement element : dataTableElements) {
            try {
                WebElement editBatchElement = bp.edit_element_all();
                System.out.println("delete batch text: " + editBatchElement.getText());
                act.moveToElement(bp.multiple_check_delete()).click().perform();
                allElements.add(element);
            } catch (NoSuchElementException e) {
                // Log the error or throw a custom exception
                System.err.println("Edit batch element not found on page " + currentPage);
            }
        }
        if (currentPage < paginationPageCount) {
            bp.clickNextPage();
        }
    }

    // Delete all elements
    deleteElements();


}

private void deleteElements() {
    
    bp.all_delete().click();
    bp.delete_confirm_popup_yes().click();
}

@Then("The respective row in the table should be deleted successfully with message {string}")
public void the_respective_row_in_the_table_should_be_deleted_successfully_with_message(String ExpectedMessage) {
	Assert.assertEquals(bp.msg_deleted().getText(), ExpectedMessage);
}


}
