Feature: Delete multiple batches with checkbox
 
 Background:
 Given: Admin is on the batch page
 
 @batch
  Scenario:Validate validate delete Icon on any row
  	Given Admin is on batch page
    When Admin clicks the delete Icon on any row
    Then Admin should see the confirm alert box with yes and no button

 @batch
  Scenario:Validate Validate yes button on the confirm alert box
  	Given Admin is on the batch confirm popup page
    When Admin clicks on the delete icon and click yes button
    Then Admin should see the successful message "batch Deleted" and the batch should be deleted
    
  @batch
  Scenario:Validate validate no button on the confirm alert box
  	Given Admin is on the batch confirm popup page
    When Admin clicks on the delete icon and click no button
    Then Admin should see the alert box closed and the batch is not deleted
    
     
  @batch
  Scenario:Validate validate close Icon on the alert box
  	Given Admin is on the batch confirm popup page
    When Admin click on the close icon 
    Then Admin should see the alert box closed