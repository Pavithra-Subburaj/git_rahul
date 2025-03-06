Feature: Batch Page validation 
 
 Background:
 Given: Admin is on the home page after Login
    
@batch
  Scenario: Validate Title in Batch Page
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the "LMS - Learning Management System" Title
  
 @batch
  Scenario: Validate heading in the Batch Page
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the "Manage Batch" Heading
    
 @batch
  Scenario: Validate disabled Delete Icon under the header in the Batch Page
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the disabled Delete Icon under the header
           
@batch
  Scenario: Validate pagination in the Batch Page
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the enabled pagination controls under the data table
    
 @batch
  Scenario: Validate Checkbox in the Datatable header row
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the checkbox in the datatable header row
    
 @batch
  Scenario: Validate Datatable headers
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the datatable headers <List>
  Examples:
	|List|
	|""|
	|"Batch Name"|
	|"Batch Description"|
	|"Batch Status"|
	|"No Of Classes"|
	|"Program Name"| 
	|"Edit / Delete"|  
	
 @batch
  Scenario: Validate sort icon next to all the datatable header
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the sort icon next to all Datatable headers
    

 @batch
  Scenario: validate checkbox in each data rows
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the checkbox in each row 
 
 @batch
  Scenario: validate delete icon in each data rows
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the delete icon in each row   
    
 @batch
  Scenario: Validate edit icon in each data rows
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the edit icon in each row
   
    