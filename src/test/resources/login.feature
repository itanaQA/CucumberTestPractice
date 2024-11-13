Feature: Log in functionality

  Scenario: User can log in
    Given user is on login page
    When user inputs valid username
    And user inputs valid password
    And user clicks on Login button
    Then user is logged in
    And redirected to homepage
