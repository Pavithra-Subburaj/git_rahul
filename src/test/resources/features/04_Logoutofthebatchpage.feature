Feature: LogOut of the application from the batch page
 
 Background:
 Given: Admin is on  Batch page
    
 @batch
  Scenario: Validate logout option in the header is visible and enabled from the batch page
  	Given Admin is on batch page
    When Admin clicks on the logout button
    Then Admin should see the Login screen Page