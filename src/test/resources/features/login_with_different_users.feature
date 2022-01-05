Feature: User account tests
  As a user, when I login with different users using their correct emails and
  passwords, I should be able to see username in the account username
  section.

  @all_accounts
  Scenario Outline: Verify user information <email>
    Given I am on the login page
    When I login using "<username>" and "<password>"
    Then account holder name should be "<name>"

    #TEST DATA
    @students
    Examples:
      | username          | password  | name            |
      | student30@library | Sdet2022* | Test Student 30 |
      | student31@library | Sdet2022* | Test Student 31 |
      | student32@library | Sdet2022* | Test Student 32 |
      | student34@library | Sdet2022* | Test Student 34 |

    @librarians
    Examples:
      | username          | password    | name            |
      | librarian13@library | Sdet2022* | Test Librarian 13 |
      | librarian14@library | Sdet2022* | Test Librarian 14 |
      | librarian15@library | Sdet2022* | Test Librarian 15 |
      | librarian16@library | Sdet2022* | Test Librarian 16 |
      | librarian17@library | Sdet2022* | Test Librarian 17 |
      | librarian18@library | Sdet2022* | Test Librarian 18 |
      | librarian19@library | Sdet2022* | Test Librarian 19 |
      | librarian20@library | Sdet2022* | Test Librarian 20 |
      | librarian21@library | Sdet2022* | Test Librarian 21 |
      | librarian22@library | Sdet2022* | Test Librarian 22 |
      | student31@library   | Sdet2022* | Test Student 31   |
      | student32@library   | Sdet2022* | Test Student 32   |
      | student33@library   | Sdet2022* | Test Student 33   |
      | student34@library   | Sdet2022* | Test Student 34   |
      | student35@library   | Sdet2022* | Test Student 35   |
      | student36@library   | Sdet2022* | Test Student 36   |
      | student37@library   | Sdet2022* | Test Student 37   |
      | student38@library   | Sdet2022* | Test Student 38   |
      | student39@library   | Sdet2022* | Test Student 39   |
      | student40@library   | Sdet2022* | Test Student 40   |
      | student41@library   | Sdet2022* | Test Student 41   |
      | student42@library   | Sdet2022* | Test Student 42   |
      | student43@library   | Sdet2022* | Test Student 43   |
      | student44@library   | Sdet2022* | Test Student 44   |
