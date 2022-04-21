Feature: Register feature test suite

  @ExecutaAcestTc
  Scenario: Register Page URL is accessible from Home Page
    Given "https://demo-opencart.com/" is accessed
    When user clicks on register button from navigation bar
    Then "register" is present within curent url

  @ExecutaAcestTc
  Scenario: Open cart page is accesible
    When "https://demo-opencart.com/" is accessed
    Then "https://demo-opencart.com/" is present within curent url

