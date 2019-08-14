@All
Feature: Login into filpkart.com and search for an item and add it to cart

@Login_to_application
Scenario: Checking The Login of The application
Given The user is able to login with valid "username" and with valid "password"
And click on login button
And  I verify the title and url of the page
And Click on the search icon and Search for a product
Then Fill the data for item searched into the ExcelSheet
 

@Search_Filter
Scenario: Search for product in the site
Given The user is able to login with valid "username" and with valid "password"
And click on login button
And  Click on the search icon and Search for a product
Then Fill the data for item searched into the ExcelSheet
And  I verify the title and url of the page


