Feature: Bumble App Login
  Scenario Outline: Verify bumble landing page
    Given : App is launched with device "<DeviceName>" and port "<Port>"
    Then  : Verify bumble landing page
    Then  : Close App

    Examples:
      | DeviceName | Port |
      | Device1    | 1010 |

  Scenario Outline: Test login with Invalid phone number
    Given : App is launched with device "<DeviceName>" and port "<Port>"
    Given : Click use phone number button
    When  : Select country "<Country>" and enter "<PhoneNumber>"
    Then  : Click Next button
    Then  : Verify Error message
    Then  : Close App

    Examples:
      | Country         | PhoneNumber | DeviceName | Port |
      | United Kingdom  | 2345        | Device1    | 1010 |
      | Germany         | 152345      | Device1    | 1010 |