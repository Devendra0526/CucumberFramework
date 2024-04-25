#Author Devendra
#Adding New Customer
Feature: Customer

  Background: Common steps for all scenarios
    Given User launch Chrome browser
    When User open URL "http://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view Dashboard

  @sanity
  Scenario: Add New Customer
    When User click on Customer Menu
    And Click on customer Menu Item
    And Click on Add new button
    Then User can view Add a new customer page
    When User enters customer information
    And Click on Save button
    Then User can view confirmaition message "The new customer has been added successfully."
    And close browser

  @regression
  Scenario: Search Customer by Email
    When User click on Customer Menu
    And Click on customer Menu Item
    And Enter customer Email
    When Click on search button
    Then User should found Email in the search table
    And close browser

  @regression
  Scenario: Search Customer by Name
    When User click on Customer Menu
    And Click on customer Menu Item
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should found name in the search table
    And close browser
