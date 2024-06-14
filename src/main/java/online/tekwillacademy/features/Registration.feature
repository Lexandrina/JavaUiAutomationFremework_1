Feature:Registration Flow

  Scenario: Access the Account page after successful registration
    Given The Home Page is accessed
    And RegisterOption is selected from the header drop-down
    And The Register form is populated with Valid data
    And Privacy Toggle is enabled
    When The Continue Button is clicked
    Then The Page URL contains the "success" keyword


  Scenario: User remains on Register Page when registering without accepting the privacy rules
    Given The Home Page is accessed
    And RegisterOption is selected from the header drop-down
    And The Register form is populated with Valid data
    When The Continue Button is clicked
    Then The Page URL contains the "route=account/register&language=en-gb" keyword


  Scenario: User remains on Register Page when registering without completing the mandatory fields
    Given The Home Page is accessed
    And RegisterOption is selected from the header drop-down
    And Privacy Toggle is enabled
    When The Continue Button is clicked
    Then The Page URL contains the "route=account/register&language=en-gb" keyword