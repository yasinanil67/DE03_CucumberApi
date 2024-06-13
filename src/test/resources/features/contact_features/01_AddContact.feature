@Contact
Feature: Add Contact Feature

  @AddContact @Api
  Scenario: Add Contact Scenario
    Given set the url for add contact
    And set the expected data for add contact
    When send the post request and get the response
    Then do assertion for add contact