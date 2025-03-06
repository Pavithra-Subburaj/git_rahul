Feature: Delete multiple batches with checkbox
 
 Background:
 Given: Admin is on the batch page
 
 @batch
  Scenario:Validate single row delete with checkbox
  	Given Admin is on batch page
    When Admin clicks on the delete icon under the Manage batch header
    Then The respective row in the table should be deleted successfully with message "Batches Deleted"
 @batch
  Scenario:Validate Validate multiple row delete with checkbox
  	Given Admin is on batch page
    When Admin clicks multiple checkbox and clicks on the delete icon under the Manage batch header
    Then The respective row in the table should be deleted successfully with message "Batches Deleted"