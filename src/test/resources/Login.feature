@Test
Feature: Login scenarios with use of valid and invalid usernames and passwords for security testing.

  Scenario Outline: Login with invalid username
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then Login should fail with an error message "<err>"

    Examples:
      | username        | password     | err                                                          |
      | invalidUsername | secret_sauce | Username and password do not match any user in this service. |


  Scenario Outline: Login with invalid password
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then Login should fail with an error message "<err>"

    Examples:
      | username      | password        | err                                                          |
      | standard_user | invalidPassword | Username and password do not match any user in this service. |


  Scenario Outline: Login with valid username and password
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then I should see Products

    Examples:
    | username | password |




