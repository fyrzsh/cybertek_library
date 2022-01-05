Feature: Login with parameters

  @librarianParam
  Scenario: Login with librarian 52
    Given I am on the login page
    When I enter username "librarian52@library"
    And I enter password 'Sdet2022*'
    And click the sign in button
    And there should be 7318 users
    Then dashboard should be displayed



#  Scenario: Login as librarian 12
#    Given I am on the login page
#    When I enter username "librarian12@library"
#    And I enter password 'AOYKYTMJ'
#    And click the sign in button
#    Then dashboard should be displayed
#    And there should be 7318 users
    #number can be whatever is on the page with that user login


  @studentParam
  Scenario: Login with student 106
    Given I am on the login page
    When I enter username "student106@library"
    And I enter password 'Sdet2022*'
    And click the sign in button
    Then books should be displayed


    #@wip
  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian52@library" and "Sdet2022*"
    And there should be 7318 users
    Then dashboard should be displayed
    #number can be whatever is on the page with that user login