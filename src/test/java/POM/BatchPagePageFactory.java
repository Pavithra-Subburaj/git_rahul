package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BatchPagePageFactory extends CommonPageFactory {
	
	public BatchPagePageFactory(WebDriver driver) {
			super(driver);
	}
	
	
	List<String> stringList = new ArrayList<>();
	List<WebElement> all_checkbox;
	@FindBy(xpath="//button/span[text()='Batch']") WebElement btn_homepage_batch;
	@FindBy(xpath="//button[text()='Add New Batch']")WebElement btn_Add_New_Batch;
	@FindBy(xpath="//span[text()=' LMS - Learning Management System ']")WebElement txt_LMS;
	@FindBy(xpath="//*[text()=' Manage Batch']")WebElement txt_Manage_batch;
	@FindBy(xpath="//*[text()=' Manage Batch']/following::button")WebElement btn_delete;
	@FindBy(xpath="//input[@id='filterGlobal']")WebElement txt_searchbox;
	@FindBy(xpath="//*[@class='p-datatable-thead']//th")List<WebElement> header_table_cols;
	@FindBy(xpath="//*[@class='p-datatable-thead']//th/p-sorticon")List<WebElement> header_table_cols_sort;
	@FindBy(xpath="//*[text()=' Dashboard']")WebElement homepage_validation;
	@FindBy(xpath="//span[text()=' LMS - Learning Management System ']")WebElement txt_batch_lms;
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-right']")WebElement btn_Pagination_right;
	@FindBy(xpath="//th//span[@class='p-checkbox-icon']")WebElement chbx_header;	
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']")WebElement total_pages;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']//tr//span[@class='p-checkbox-icon']")List<WebElement> pg_checkbox;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']//tr//span[@class='p-button-icon pi pi-pencil']")List<WebElement> pg_edit;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']//tr//span[@class='p-button-icon pi pi-trash']")List<WebElement> pg_delete;
	Actions actions = new Actions(driver);
	@FindBy(css="span.p-paginator-pages button:last-child")
	WebElement page_size;
	@FindBy(xpath="//*[text()='Batches']") WebElement btn_batches;
	@FindBy(xpath="//button[text()='Add New Batch']")WebElement btn_AddNewBatch;
	@FindBy(xpath="//span[text()='Batch Details']")WebElement txt_BatchDetails;	
	@FindBy(xpath="//span[@class='mat-button-wrapper'][text()='Logout']")WebElement btn_Logout;
	@FindBy(xpath="//input[@id='filterGlobal']")WebElement txt_search;
	@FindBy(xpath="//tbody//td[2]")
	public WebElement txt_search_entry;
	@FindBy(css = "button.p-paginator-next") WebElement nextButton;
	@FindBy(css = "button.p-paginator-last")WebElement lastButton;	
	@FindBy(css = "button.p-paginator-prev")WebElement prevButton;
	@FindBy(css = "button.p-paginator-first")WebElement FirstprevButton;
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']")WebElement showing_txt;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']//tr//td[text()='Java1']")WebElement edit_element;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']//tr//td[text()='Java2']")WebElement edit_element_all;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']//tr//td[text()='Java1']/following::span[1]")WebElement edit_batch_icon;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']//tr//td[text()='Java1']/preceding::span[1]")WebElement single_check_delete;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']//tr//td[text()='Java2']/preceding::span[1]")WebElement multiple_check_delete;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']")List<WebElement> all_data;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']//tr//td[text()='Java1']/following::td[2]")WebElement edit_class_no;
//AddNewBatch
	@FindBy(xpath="//label[@for='programName']")WebElement txt_prgname;
	@FindBy(xpath="//*[@id='programName']//input[@placeholder='Select a Program name']") WebElement txtbox_prgname;
	@FindBy(xpath="//span[@class='p-dropdown-trigger-icon ng-tns-c88-12 pi pi-chevron-down']")WebElement drp_prgname;
	@FindBy(xpath="//label[@for='batchName']")WebElement txt_batchName;
	@FindBy(xpath="//*[@id='batchProg']")WebElement txtbox_batchProg;
	@FindBy(xpath="//*[@id='batchName']")WebElement txtbox_batchName;
	@FindBy(xpath="//label[@for='batchDescription']")WebElement txt_batchDesc;
	@FindBy(xpath="//*[@id='batchDescription']")WebElement txtbox_batchDesc;
	@FindBy(xpath="//lable[@for='online']")WebElement txt_status;
	@FindBy(xpath="//input[@id='ACTIVE']/following::div[@class='p-radiobutton-box']")WebElement rd_active;
	@FindBy(xpath="//*[@id='INACTIVE']")WebElement rd_inactive;
	@FindBy(xpath="//label[@for='batchNoOfClasses']")WebElement txt_noClasses;
	@FindBy(xpath="//*[@id='batchNoOfClasses']")WebElement txtbox_noClasses;
	@FindBy(xpath="//*[text()='Cancel']")WebElement btn_cancel;
	@FindBy(xpath="//*[text()='Save']")WebElement btn_save;
	@FindBy(xpath="//*[@class='ng-tns-c88-12 ng-star-inserted']")List<WebElement> drop_addnew;
	@FindBy(xpath="//*[text()='Program Name is required.']")WebElement error_msg_programname;
	@FindBy(xpath="//input[@id='batchName']/following-sibling::small")WebElement error_msg_Batchname;
	@FindBy(xpath="//*[@id='batchDescription']/following::small")WebElement error_msg_desc;
	@FindBy(xpath="//*[text()='Successful']")WebElement success_msg;
	@FindBy(xpath="//*[text()='Status is required.']")WebElement error_msg_status;
	@FindBy(xpath="//*[text()='Number of classes is required.']")WebElement error_msg_noofclasses;
	@FindBy(xpath="//*[@class='p-dialog-header-close-icon ng-tns-c81-9 pi pi-times']")WebElement popup_close;
	@FindBy(css =".p-dialog")WebElement popup_disable;	
//deletepopup
	@FindBy(xpath="//span[text()='Confirm']")WebElement delete_confirm_popup;
	@FindBy(xpath="//span[@class='p-button-label'][text()='No']")WebElement delete_confirm_popup_no;
	@FindBy(xpath="//span[@class='p-button-label'][text()='Yes']")WebElement delete_confirm_popup_yes;
	@FindBy(xpath="//span[text()='Confirm']/following::span")WebElement delete_confirm_popup_cancel;
	@FindBy(xpath="//*[text()=' Manage Batch']/following::span[@class='p-button-icon pi pi-trash']")WebElement all_delete;
	@FindBy(xpath="//*[text()='Batches Deleted']")WebElement msg_deleted;
	@FindBy(xpath="//*[text()='batch Deleted']")WebElement msg_deleted_single;
//deletepopup methods
	public WebElement msg_deleted()
	{
		return msg_deleted;
	}
	public WebElement msg_deleted_single()
	{
		return msg_deleted_single;
	}
	public WebElement delete_confirm_popup()
	{
		return delete_confirm_popup;
	}
	public WebElement delete_confirm_popup_no()
	{
		return delete_confirm_popup_no ;
	}
	public WebElement delete_confirm_popup_yes()
	{
		return delete_confirm_popup_yes;
	}
	public WebElement delete_confirm_popup_cancel()
	{
		return delete_confirm_popup_cancel;
	}
	public WebElement all_delete()
	{
		return all_delete;
	}
	public WebElement single_check_delete()
	{
		return single_check_delete;
	}
	public WebElement multiple_check_delete()
	{
		return multiple_check_delete;
	}
	public WebElement edit_element_all()
	{
		return edit_element_all;
	}
//AddNewBatch popup method
	public List<WebElement> all_data(){
		return all_data;
	}
	public WebElement edit_batch_icon(){
		return edit_batch_icon;
	}
	public WebElement edit_element(){
		return edit_element;
	}	
	public WebElement popup_disable()
	{
		return popup_disable;
	}
	public WebElement popup_close()
	{
		return popup_close;
	}
	public String error_msg_desc()
	{
		return error_msg_desc.getText();
	}
	public String error_msg_status()
	{
		return error_msg_status.getText();
	}
	public String error_msg_noofclasses()
	{
		return error_msg_noofclasses.getText();
	}
	public String success_msg()
	{
		return success_msg.getText();
	}
	public String error_msg_programname()
	{
		return error_msg_programname.getText();
	}
	public String error_msg_Batchname()
	{
		return error_msg_Batchname.getText();
	}
	public List<WebElement> drp_addnewbatch()
	{
		return drop_addnew;
	}
	public WebElement txt_programName()
	{
		return txt_prgname;
	}
	public WebElement txtbox_programName()
	{
		return txtbox_prgname;
	}
	public WebElement drp_programName()
	{
		return drp_prgname;
	}
	public WebElement txt_batchName()
	{
		return txt_batchName;
	}
	public WebElement txtbox_batchProg()
	{
		return txtbox_batchProg;
	}
	public WebElement txtbox_batchName()
	{
		return txtbox_batchName;
	}
	public WebElement txt_batchDesc()
	{
		return txt_batchDesc;
	}
	public WebElement txtbox_batchDesc()
	{
		return txtbox_batchDesc;
	}
	public WebElement txt_status()
	{
		return txt_status;
	}
	public WebElement radio_active()
	{
		return rd_active;
	}
	public WebElement radio_inactive()
	{
		return rd_inactive;
	}
	public WebElement txt_noClasses()
	{
		return txt_noClasses;
	}
	public WebElement txtbox_noClasses()
	{
		return txtbox_noClasses;
	}
	public WebElement btn_cancel()
	{
		return btn_cancel;
	}
	public WebElement btn_save()
	{
		return btn_save;
	}
	//Batchpage methods	
	public WebElement edit_class_total(){
		return edit_class_no;
	}
	public WebElement nextright()
	{
		return nextButton;
	}
	public WebElement btn_lastnext()
	{
		return lastButton;
	}
	public WebElement btn_previous()
	{
		return prevButton;
	}
	public WebElement btn_First_prev()
	{
		return FirstprevButton;
	}
	
	public void click_First_prev()
	{
		 FirstprevButton.click();
	}
	
	
	public WebElement txt_showing()
	{
		actions.moveToElement(showing_txt).perform();
		return showing_txt;
	}
	public WebElement search() throws InterruptedException {
	    return txt_search_entry;
	}
	public WebElement txt_searchbox()
	{
		return txt_search;
	
	}
	public List<WebElement> pagiantion_checkbox()
	{	
		return pg_checkbox;
	}
	public List<WebElement> pagiantion_edit_btn()
	{	
		return pg_edit;
	}
	public List<WebElement> pagiantion_delete_btn()
	{	
		return pg_delete;
	}
	public int getTotalPages() {		
		actions.moveToElement(page_size).perform();
		System.out.println(page_size.getText());
	    return Integer.parseInt(page_size.getText());
	}

	public WebElement RightNext_btn()
	{
		return btn_Pagination_right;
	}
	public void clickNextPage() {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click()", btn_Pagination_right);
	}
	
	public WebElement homepageValidation()
	{
		return homepage_validation;
	}
	public void Click_batch_btn()
	{
		btn_homepage_batch.click();
	
	}
	public void click_batches_btn() {
		btn_batches.click();
	}
	
	public void click_AddNewBatch_btn()
	{
		btn_AddNewBatch.click();
	}
	
	public void click_BatchLogout_btn()
	{
		btn_Logout.click();
	}
	
	
	public WebElement AddNewBatch_btn()
	{
		return btn_AddNewBatch;
	}
	public WebElement BatchDetails_text()
	{
		return txt_BatchDetails;
	}
	
	public WebElement LMS_header()
	{
		return txt_batch_lms;
	}
	public WebElement batch_Managebatch_header()
	{
		return txt_Manage_batch;
	}
	public WebElement batch_deleteall()
	{
		return btn_delete;
	}
	public WebElement Pagination_right()
	{
		return btn_Pagination_right;
	}
	public WebElement checkbox_header()
	{
		return chbx_header;
	}
	public List<WebElement> header()
	{
		return header_table_cols;
	}
	public List<String> header_string()
	{
		for(WebElement table_header:header_table_cols)
		{
			stringList.add(table_header.getText());
//			System.out.println(stringList);
		}
		
		return stringList;
	}
	public List<WebElement> header_sorticon()
	{
		return header_table_cols_sort;
	}
		
	public boolean isNextPageAvailable() {
	    return btn_Pagination_right.isEnabled() && btn_Pagination_right.isDisplayed();
	}
	public void clickNextPageIfEnabled() {
	    if (nextright().isEnabled()) {
	        System.out.println("Next button is enabled, clicking...");
	        clickNextPage();
	    } else {
	        System.out.println("Next button is disabled");
	    }
	}
	public void clickPreviousPageIfEnabled() {
	    if (btn_previous().isEnabled()) {
	        System.out.println("Previous button is enabled, clicking...");
	        clickPreviousPage();
	    } else {
	        System.out.println("Previous button is disabled");
	    }
	}
	private void clickPreviousPage() {
		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click()", prevButton);
	}
}
