Feature: Search Text box validation 
 
 Background:
 Given: Admin is on the Batch page
    
 @batch
  Scenario: validate search box functionality
  	Given Admin is on batch page
    When Admin enters the batch name in the search text box <batchname>
    Then Admin should see the filtered batches in the data table <batchname>
  Examples:
	|batchname|
	|"java-198"|
	|"Micro service-01"|
	|"abc"|
	|"123"|
