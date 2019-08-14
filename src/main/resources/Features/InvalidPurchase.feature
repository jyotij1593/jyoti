@All
Feature: To verify the negative login
  

 @test1
 Scenario: To verify the invalid login cerdentails
    Given The user is able to login with valid "username" and with valid "password"
    And click on login button
    Then validate error message is displayed
    And Logout of The application
    

 @test2
 Scenario: Perform cart for unregistered user
    Given The user is able to login with valid "username" and with valid "password"
    When user search for a product
    Then verify product is displayed
    And click on the product
    When user perfroms cart operation
    Then Application should navigate to user registration
    And Logout of The application
    
 @test3
  Scenario: Register a user without providing address details
    Given The user is able to login with valid "username" and with valid "password"
    When click on sign in option
    Then Verify the user info page is displayed
    When Addres of the user is missing
    And  click on register
    Then Error message should be displayed
    And Logout of The application

    
