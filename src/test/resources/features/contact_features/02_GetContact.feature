@Contact
Feature: Get Contact

  @GetContact @Api
  Scenario: Get Contact Scenario
    Given set the url for get contact
    And set the expected data for get contact
    When send the get request and get the response for get contact
    Then do assertion for get contact