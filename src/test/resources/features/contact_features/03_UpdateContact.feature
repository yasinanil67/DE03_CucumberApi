@Contact
Feature: Update Contact

  @UpdateContact @Api
  Scenario: Update Contact Scenario
    Given set the url for update contact
    And set the expected data for update contact
    When send the put request and get the response for update contact
    Then do assertion for update contact