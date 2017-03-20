# Author - Gavin.Walters
#
@Regression
Feature: The application allows users to add, amend, remove and view various computers in the databse

Background:
	Given The user is on the application home page

@create
Scenario: User is able to create a computer entering information in all fields
	And selects the "Add a new computer" button
	And enters valid information in all fields
	And selects the "Create this computer" button
	Then the computer is created successfully
	
@create
Scenario: User is able to create a computer entering information in mandatory fields only
	And selects the "Add a new computer" button
	And enters valid mandatory information only
	And selects the "Create this computer" button
	Then the computer is created successfully
	
@create
Scenario: User is able to create a computer entering special characters in the Name field
	And selects the "Add a new computer" button
	And enters special characters in the name field
	And selects the "Create this computer" button
	Then the computer is created successfully

@create
Scenario: User is able to create a computer entering special characters in the Name field
	And selects the "Add a new computer" button
	And enters 250 characters in the name field
	And selects the "Create this computer" button
	Then the computer is created successfully
	
@create
Scenario: Ensure no computer is created when an invalid introduced date is entered
	And selects the "Add a new computer" button
	And a date of "2001-02-31" into the introduced field and valid information in all others
	And selects the "Create this computer" button
	Then the computer is not created and the user remains on the Add a computer page
	
@create
Scenario: Ensure no computer is created when an invalid discontinued date is entered
	And selects the "Add a new computer" button
	And a date of "2001-50-01" into the discontinued field and valid information in all others
	And selects the "Create this computer" button
	Then the computer is not created and the user remains on the Add a computer page
	
@create
Scenario: Ensure that a computer can be created following the removal of a date error
	And is on the Add a computer page following a date validation error
	And when the date is corrected
	And selects the "Create this computer" button
	Then the computer is created successfully
	
# this test is failing - there is weak validation of the date fields
@create
Scenario: Ensure no computer is created when the introduced date is later than the discontinued date
	And selects the "Add a new computer" button
	And enters an introduced date that is later than the discontinued date
	And selects the "Create this computer" button
	Then the computer is not created and the user remains on the Add a computer page
	
@read
Scenario: Ensure a computer can be searched for
	And a computer has been created with the following details "QWERTY12345", "2001-01-01", "2002-01-01","Atari"
	And "QWERTY12345" is entered into the search box
	And selects the "Filter by name" button
	Then the computer searched for is displayed
	
@update
Scenario: User is able to update the name of an existing record
	And selects any record from the results table
	And updates the "name" field
	And selects the "Save this computer" button
	Then the computer is updated successfully
	
@update
Scenario: User is able to update the name of an existing record
	And selects any record from the results table
	And updates the "introduced" field
	And selects the "Save this computer" button
	Then the computer is updated successfully
	
@update 
Scenario: User is able to update the name of an existing record
	And selects any record from the results table
	And updates the "discontinued" field
	And selects the "Save this computer" button
	Then the computer is updated successfully
	
@update
Scenario: User is able to update the name of an existing record
	And selects any record from the results table
	And updates the "company" field
	And selects the "Save this computer" button
	Then the computer is updated successfully
	
@delete
Scenario: User is able to delete a computer
	And selects any record from the results table
	And selects the "Delete this computer" button
	Then the computer is deleted successfully
	
@misc
Scenario: Ensure all valid options are present in the company dropdown
	And selects the "Add a new computer" button
	Then all valid options are present in the company dropdown on the "Add a computer" page
	
@misc
Scenario: Ensure all valid options are present in the company dropdown
	And selects any record from the results table
	Then all valid options are present in the company dropdown on the "Amend a computer" page