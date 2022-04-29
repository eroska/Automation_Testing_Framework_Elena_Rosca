@LectieAvansata
Feature: Register feature test suite

  Background:
    Given "https://demo-opencart.com/" is accessed

  Scenario: Register Page URL is accessible from Home Page
    When user clicks on my account button from navigation bar
    And Register button is clicked
    Then "register" is present within current url


  Scenario: Open cart page is accessible
    When "https://demo-opencart.com/" is accessed
    Then "https://demo-opencart.com/" is present within current url

  @LectieAvansata
  Scenario Outline: error message is displayed when providing invalid data for registration form <affectedField>
    Given "https://demo-opencart.com/" is accessed
    And user clicks on register button from navigation bar
    When The register fields are populated with the following data:
      | firstName       | <first name>   |
      | lastName        | <last name>    |
      | email           | <email>        |
      | phoneNumber     | <phone number> |
      | password        | 4865555525     |
      | confirmPassword | 4865555525     |
    And privacyCheckBox is clicked
    And Continue button is clicked
    Then the following key words are present within an error message
      | <errorMessage> |

    Examples:
      | affectedField | first name | last name | email                | phone number                      | errorMessage                                    |
      | email         | Elena      | Gheorghiu |                      | 06987545                          | E-Mail Address does not                         |
      | first name    |            | Gheorghiu | emailclass@gmail.com | 063254569                         | First Name must be between 1 and 32 characters! |
      | last name     | Elena      |           | emailclass@gmail.com | 555445544                         | Last Name must be between 1 and 32 characters!  |
      | phone number  | Elena      | Gheorghiu | emailclass@gmail.com |                                   | Telephone must be between 3 and 32 characters!  |
      | phone number  | Elena      | Gheorghiu | emailclass@gmail.com | 98                                | Telephone must be between 3 and 32 characters!  |
      | phone number  | Elena      | Gheorghiu | emailclass@gmail.com | 236547896542365478965423654789654 | Telephone must be between 3 and 32 characters!  |