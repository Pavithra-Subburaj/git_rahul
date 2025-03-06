Feature: Add New Batch details pop up
 
 Background:
 Given: Admin is on the Add new batch pop up
 
 @batch
  Scenario: Validate all the fields exist in pop up
  	Given Admin is on the Batch Details Pop Up WIndow
    When Admin checks all the field
    Then The pop up should include the fields <Fields>
 Examples:
	|Fields|
	|"Program Name*"|
	|"Batch Name*"|
	|"Description*"|
	|"Status : *"|
	|"Number of Classes*"|

@batch
  Scenario: Validate details in Add new batch pop up
  	Given Admin is on the Batch Details Pop Up WIndow
    When scenario specified is executed in "<SheetName>" and rownumber <RowNumber>
    Then Admin is able to see the message in sheetname "<SheetName>" and rownumber <RowNumber>
    Examples: 
     | SheetName  | RowNumber|
     | Details    |         0|
     | Details    |         1|
     | Details    |         2|
     | Details    |         3|
     | Details    |         4|
 		 | Details    |         5|
		 | Details    |         6|
		 | Details    |         7|
		 | Details    |         8|
		 | Details    |         9|
		 | Details    |         10|
		 | Details    |         11|
 		 | Details    |         12|
 		 | Details    |         13|
 		 | Details    |         14|
 		 | Details    |         15| 		 
 		 | Details    |         16| 		 
 		 | Details    |         17| 		 
 		 | Details    |         18|
 		  		 
@batch
  Scenario: validate close icon on the batch details pop up details in Add new batch pop up
  	Given Admin is on the Batch Details Pop Up WIndow
    When Admin clicks on the close icon
    Then batch details pop up closes
   
  
  