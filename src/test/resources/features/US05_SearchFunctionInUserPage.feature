@1
Feature: Search functionality on the users page

  User Story5: As I user, I should be able to search values in the Users page.

  Background:
    Given Librarian is already logged in
    And Librarian click on "Users" link

  Scenario: Search accuracy
    When Librarian search for "test"
    Then table should contain rows with "Test"

  Scenario: Table columns names
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |


