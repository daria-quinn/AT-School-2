Feature: Login functionality on the-internet.herokuapp.com

  Background:
    Given User opens the internet homepage

  Scenario: Valid login and logout
    When User clicks on Form Authentication link
    Then Login page title should be displayed
    When User enters username "tomsmith"
    And User enters password "SuperSecretPassword!"
    And User clicks Login button
    Then Success message "You logged into a secure area!" should be displayed
    And Logout button should be visible
    When User clicks Logout button
    Then Login page title should be displayed

  Scenario: Invalid login with wrong credentials
    When User clicks on Form Authentication link
    Then Elemental Selenium link should be visible
    When User enters username "admin"
    And User enters password "1234"
    And User clicks Login button
    Then Error message "Your username is invalid!" should be displayed
