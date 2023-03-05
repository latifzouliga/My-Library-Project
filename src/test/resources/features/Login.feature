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

  @librarian @wip
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

