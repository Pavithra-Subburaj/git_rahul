package stepdefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.Keys;
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
import Utilities.ExcelReader;

public class EditiconValidation {
	private ExcelReader reader = new ExcelReader();
	WebDriver driver;
	Actions act;
	ConfigReader config = new ConfigReader();
	LoginPagePageFactory lp;
	BatchPagePageFactory bp;
	HomePagePageFactory hp;
	public EditiconValidation() {
	        driver = DriverFactory.getDriver();
	        bp = new BatchPagePageFactory(driver);
	        act=new Actions(driver);
	    }

@When("scenario specified in {string} and rownumber {int} Excel")
public void scenario_specified_in_and_rownumber_excel(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
	List<Map<String, String>> testData = reader.getData(System.getProperty("user.dir")+"\\src\\test\\resources\\utils\\batch.xlsx", sheetName);
    Map<String, String> data = testData.get(rowNumber);
    String scenario=data.get("Scenarios");
	String ProgramName=data.get("ProgramName");
	String BatchName1=data.get("BatchName1");
	String BatchName2=data.get("BatchName2");
	String Status=data.get("Status");
	String Description=data.get("Description");
	String NumberofClasses=data.get("NumberofClasses");	
	
		if (scenario.equals("Validate Edit icon feature in any row")||
				scenario.equals("Validate program name value is disabled to edit")||
				scenario.equals("Validate batch name value is disabled to edit"))
				{
		    System.out.println(scenario + " scenario is tested");
		    int totalPages = bp.getTotalPages();
		    System.out.println("Total pages: " + totalPages);	
		    boolean elementFound = false;
		    for (int currentPage = 1; currentPage <= totalPages && !elementFound; currentPage++) {
		        List<WebElement> dataTableElements = bp.all_data();
		        for (WebElement element : dataTableElements) {
		            try {
		                WebElement editBatchElement = bp.edit_element();
		                System.out.println("Edit batch text: " + editBatchElement.getText());
		                elementFound = true;
	                    WebElement editBatchIcon = bp.edit_batch_icon();
	                    editBatchIcon.click();
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
	else if (scenario.equals("Validate editing description with invalid data in the pop up")) {
		 System.out.println(scenario + " scenario is tested");
		    int totalPages = bp.getTotalPages();
		    System.out.println("Total pages: " + totalPages);	
		    boolean elementFound = false;
		    for (int currentPage = 1; currentPage <= totalPages && !elementFound; currentPage++) {
		        List<WebElement> dataTableElements = bp.all_data();
		        for (WebElement element : dataTableElements) {
		            try {
		                WebElement editBatchElement = bp.edit_element();
		                System.out.println("Edit batch text: " + editBatchElement.getText());
		                elementFound = true;
	                    WebElement editBatchIcon = bp.edit_batch_icon();
	                    editBatchIcon.click();
	                    bp.txtbox_batchDesc().clear();
	                    act.moveToElement(bp.txtbox_batchDesc()).click().perform();
	        			bp.txtbox_batchDesc().sendKeys(Description);
		                break;
		            } catch (NoSuchElementException e) {
		                System.out.println("Edit batch element not found");
		            }
		        }
		        if (!elementFound) {
		            bp.clickNextPage();
		        }
		    }		
	}else if(scenario.equals("Validate editing  No. of classes fields with invalid data in the pop up")) {
		 System.out.println(scenario + " scenario is tested");
		    int totalPages = bp.getTotalPages();	
		    boolean elementFound = false;
		    for (int currentPage = 1; currentPage <= totalPages && !elementFound; currentPage++) {
		        List<WebElement> dataTableElements = bp.all_data();
		        for (WebElement element : dataTableElements) {
		            try {
		                WebElement editBatchElement = bp.edit_element();
		                int length=bp.edit_class_total().getText().length();
		                elementFound = true;
		                System.out.println("total numbers:"+bp.edit_class_total().getText());
	                    WebElement editBatchIcon = bp.edit_batch_icon();
	                    editBatchIcon.click();	
	                    act.moveToElement(bp.txtbox_noClasses()).click().perform();  
	                    for(int i=0;i<length;i++)
	                    {
	                    	act.sendKeys(Keys.BACK_SPACE).perform();
	                    }	                    
	                    bp.btn_save().click();
	                    
		                break;
		            } catch (NoSuchElementException e) {
		                System.out.println("Edit batch element not found");
		            }
		        }
		        if (!elementFound) {
		            bp.clickNextPage();
		        }
		    }		
	}else if(scenario.equals("validate save button in Batch details pop up")) {
		int totalPages = bp.getTotalPages();
		outerLoop:		
		for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
		    List<WebElement> dataTableElements = bp.all_data();
		    
		    for (WebElement element : dataTableElements) {
		        try {
		            WebElement editBatchElement = bp.edit_element();
		            WebElement editBatchIcon = bp.edit_batch_icon();
		            editBatchIcon.click();
		            bp.txtbox_noClasses().clear();
		            act.moveToElement(bp.txtbox_noClasses()).click().perform();
		            bp.txtbox_noClasses().sendKeys(NumberofClasses);
		            Thread.sleep(1000);
		            bp.btn_save().click();
		            break outerLoop;
		        } catch (NoSuchElementException e) {
		            System.out.println("Edit batch element not found");
		        }
		    }
		    
		    bp.clickNextPage();
		}
	}else if(scenario.equals("validate cancel button in Batch details pop up")) {
		int totalPages = bp.getTotalPages();
		outerLoop:		
		for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
		    List<WebElement> dataTableElements = bp.all_data();
		    
		    for (WebElement element : dataTableElements) {
		        try {
		            WebElement editBatchElement = bp.edit_element();
		            WebElement editBatchIcon = bp.edit_batch_icon();
		            editBatchIcon.click();
		            bp.txtbox_noClasses().clear();
		            act.moveToElement(bp.txtbox_noClasses()).click().perform();
		            bp.txtbox_noClasses().sendKeys(NumberofClasses);
		            Thread.sleep(1000);
		            bp.btn_cancel().click();
		            break outerLoop;
		        } catch (NoSuchElementException e) {
		            System.out.println("Edit batch element not found");
		        }
		    }
		    
		    bp.clickNextPage();
		}
	}
}
	        
	  

@Then("Admin sees the message in sheetname {string} and rownumber {int}")
public void admin_sees_the_message_in_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	List<Map<String, String>> testData = reader.getData(System.getProperty("user.dir")+"\\src\\test\\resources\\utils\\batch.xlsx", sheetName);
    Map<String, String> data = testData.get(rowNumber);
    String scenario=data.get("Scenarios");
    String ExpectedMessage=data.get("ExpectedMessage");  	
    if (scenario.equals("Validate Edit icon feature in any row")) {
    	Assert.assertEquals(bp.BatchDetails_text().getText(),ExpectedMessage);
    }else  if (scenario.equals("Validate program name value is disabled to edit")) {
    	Assert.assertFalse(bp.txtbox_programName().isEnabled());
    }else  if (scenario.equals("Validate program name value is disabled to edit")) {
    	Assert.assertFalse(bp.txt_batchName().isEnabled());
    }else if(scenario.equals("Validate editing description with invalid data in the pop up"))
    {
    	Assert.assertEquals(bp.error_msg_desc(),ExpectedMessage);
    }else if(scenario.equals("Validate editing  No. of classes fields with invalid data in the pop up")) {
    	Assert.assertEquals(bp.error_msg_noofclasses(), ExpectedMessage);
    }else if(scenario.equals("validate save button in Batch details pop up")) {
    	Assert.assertEquals(bp.success_msg(), ExpectedMessage);
    }else if(scenario.equals("validate cancel button in Batch details pop up")){
    	Assert.assertTrue(bp.txt_search_entry.isDisplayed());
    }
}

}
