Feature: Bumble App Login
  Scenario: Verify bumble landing page
    Given : App is launched
    Then  : Verify bumble landing page

  Scenario Outline: Test login with Invalid phone number
    Given : App is launched
    Given : Click use phone number button
    When  : Select country "<Country>" and enter "<PhoneNumber>"
    Then  : Click Next button
    Then  : Verify Error message
    Examples:
      | Country         | PhoneNumber |
      | United Kingdom  | 2345        |
      | Germany         | 152345      |