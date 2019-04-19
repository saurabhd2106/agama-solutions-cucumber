Feature: Test login functionality of facebook

  Background: 
    Given user navigates to facebook page

  Scenario: Test user login with credentials
    And user enter username as saurabh.d2106@gmail.com
    And user enter password as abx123
    Then user logged in
    And user closes the browser

  Scenario: Signup on Facebook website
    And user enter following details
      | Name     | Saurabh                 |
      | lastname | Dhingra                 |
      | email    | saurabh.d2106@gmail.com |
      | password | abc@123                 |
    And user enter signup button
