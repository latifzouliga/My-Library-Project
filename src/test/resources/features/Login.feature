Feature: Login function
  Agile Story: As a user, I should be able to login
  # As a librarian, I want to login and access to the dashboard page.
  # As a user, I should be able to Login with valid credentials.

  @librarian
  Scenario: login with valid credentials
    Given Librarian on the login page
    When Librarian enters valid email address
    And Librarian enters valid password
    And Librarian clicks Sign in button
    Then Librarian should see Library title

  @librarian
  Scenario Outline: login with invalid credentials
    Given Librarian on the login page
    When Librarian enters invalid "<email>" address
    And Librarian enters invalid "<password>"
    And Librarian clicks Sign in button
    Then Librarian should not be able to login

    Examples:
      | email              | password          |
      | librarianUsername1 | wrongPassword     |
      | wrongEmail         | librarianPassword |
      | wrongEmail         | wrongPassword     |
      | librarianUsername1 | empty             |
      | empty              | librarianPassword |
      | empty              | empty             |


  @student
  Scenario: login with valid credentials
    Given student on the login page
    When student enters valid email address
    And student enters valid password
    And student clicks Sign in button
    Then student should see Library title

  @student
  Scenario Outline: login with invalid credentials
    Given student on the login page
    When student enters invalid "<email>" address
    And student enters invalid "<password>"
    And student clicks Sign in button
    Then student should not be able to login

    Examples:
      | email            | password        |
      | studentUsername1 | wrong           |
      | wrong            | studentPassword |
      | EmailWrong       | PasswordWrong   |
      | studentUsername1 | empty           |
      | empty            | studentPassword |
      | empty            | empty           |












