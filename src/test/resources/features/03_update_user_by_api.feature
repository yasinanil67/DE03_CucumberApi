@End2End
Feature: Update User By Api

  @Update @Api
  Scenario: Update User Scenario
    Given set the url for put request
    And set the expected data for put request
    When send the put request and get the response
    Then do assertion for put request