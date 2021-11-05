@SmokeTest
Feature: Login scenarios

  Scenario Outline: Login with invalid user name
    When I enter username as "<username>"
#    And I enter password as "<password>"
#    And I login
#    Then login should fain with "<err>"

    Examples:
    | username |
    | Nyla |

