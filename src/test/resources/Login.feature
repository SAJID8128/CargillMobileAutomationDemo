@SmokeTest
Feature: Login scenarios

  Scenario Outline: Login with invalid user name
    When I enter username as "<username>"

    Examples:
    | username |
    | Nyla     |

