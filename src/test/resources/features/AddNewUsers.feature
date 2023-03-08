Feature: Add new users Function

  Agile Story: As a user, I want to add new users to the app.

  Background:
    Given Librarian is already logged in
    And Librarian is already in Users page


  Scenario: Add new user
    Given Librarian clicks Add user button
    Then Librarian should see Add User popup window
    Then Librarian enters Full Name
    And Librarian enters Email
    And Librarian enters password
    And Librarian enters Start Date
    And Librarian enters End Date
    And Librarian enters Address
    And Librarian clicks Save changes
    Then Librarian should see "The user has been created."


  Scenario Outline: Add new user
    Given Librarian clicks Add user button
    Then Librarian should see Add User popup window
    Then Librarian enters fullName "<Full Name>"
    And Librarian enters email "<Email>"
    And Librarian enters password "<password>"
    And Librarian enters start date "<Start Date>"
    And Librarian enters end date "<End Date>"
    And Librarian enters address "<Address>"
    And Librarian clicks Save changes
    Then Librarian should see "The user has been created."

    Examples:
      | Full Name   | Email       | password | Start Date | End Date  | Address        |
      | Ahmed Ahmed | Email@mal01 | password | 2023-5-10  | 2023-7-10 | 123 Address dr |
      | John Doe    | hello@h01   | 123412   | 2023-6-10  | 2023-8-10 | 22 Address st  |
      | Mike Mike   | hi@hllo01   | sdf123sd | 2023-5-10  | 2024-5-10 | 1 Address blvd |


