Feature: Show record functionality

  @wip
  Scenario: Verify default values in User page
    Given I am on the login page
    And I login as a librarian
    When I click on "Users" link
    Then show records default value should be 10
    And ow records should have following options:
          | 5 |
          | 10 |
          | 15 |
          | 50 |
          | 100 |
          | 200 |
          | 500 |

