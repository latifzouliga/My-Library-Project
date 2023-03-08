Feature:
  User Story4: As a user, I want to select different number of raws to see users records


  Scenario Outline: Show records for <count> options
    Given Librarian is already logged in
    And Librarian click on "Users" link
    When Librarian select Show <count> records
    Then show records value needs to be <count>
    And users table must display <count> records
    Examples:
      | count |
      | 5     |
      | 10    |
      | 15    |
      | 50    |
      | 100   |
