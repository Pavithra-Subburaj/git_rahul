Feature: Pagination
 
 Background:
 Given: Admin is on the Batch page
    
 @batch
  Scenario: Validate next page link
  	Given Admin is on batch page
    When Admin clicks next page link on the data table
    Then Admin should see the Next enabled link

@batch
  Scenario: validate last page link
  	Given Admin is on batch page
    When Admin clicks last page link on the data table
    Then Admin should see the last page link with next page link disabled on the table

@batch
  Scenario: validate the previous page link
  	Given Admin is on batch page
    When Admin clicks previous page link on the data table
    Then Admin should see the previous page on the table
    
@batch
  Scenario: validate the first page link
  	Given Admin is on batch page
    When Admin clicks first page link on the data table
    Then Admin should see the very first page on the data table