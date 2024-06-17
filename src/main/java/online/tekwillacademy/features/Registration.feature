Feature:Registration Flow


  Background:
    Given The Home Page is accessed
    And RegisterOption is selected from the header drop-down


  Scenario: Access the Account page after successful registration
    And The Register form is populated with Valid data
    And Privacy Toggle is enabled
    When The Continue Button is clicked
    Then The Page URL contains the "success" keyword


  Scenario: User remains on Register Page when registering without accepting the privacy rules
    And The Register form is populated with Valid data
    When The Continue Button is clicked
    Then The Page URL contains the "route=account/register&language=en-gb" keyword


  Scenario: User remains on Register Page when registering without completing the mandatory fields
    And Privacy Toggle is enabled
    When The Continue Button is clicked
    Then The Page URL contains the "route=account/register&language=en-gb" keyword


  @Register
  Scenario Outline: Error message is displayed when firstName is to long
    Given The "https://tekwillacademy-opencart.online/index.php?route=account/register&language=en-gb" link is accessed
    And the register form is populated with the following data:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | Random      |
      | password  | Random      |
    When The Continue Button is clicked
    Then The following error messages are displayed:
      | Warning: You must agree to the Privacy Policy!       |
      | <affectedField> must be between 1 and 32 characters! |

    Examples:
      | affectedField | firstName                                                         | lastName                             |
      | First Name    | lfylidgflidgifgrleiufgriegliyfgrkeuyawfeuyfuyegkrgkeriugfiywegkru | random                               |
      | Last Name     | random                                                            | dwqiwdytieytdfytqecdycytcecngsdvjcgv |



