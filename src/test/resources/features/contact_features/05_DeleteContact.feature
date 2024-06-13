@Contact
Feature: Delete Contact


  @DeleteContact @Api
  Scenario: Delete Contact Scenario
    Given set the url for delete contact
    And set the expected data for delete contact
    When send the delete request and get the response for delete contact
    Then do assertion for delete contact
