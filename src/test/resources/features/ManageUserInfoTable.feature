Feature: manage user info table


  User Story: As a user, I want to change the number of raws to see the user info



  Scenario: Change number of rows in Users page
    Given user is on the login page
    And user login as a librarian
    And user click on "Users" link
    When user select Show 50 records
    Then show records value should be 50
    And the users table must display 50 records
