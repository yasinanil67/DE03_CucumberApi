@End2End
Feature: Delete User

  @Delete @Api
  Scenario: Delete Updated User

    Given set the url for delete request
    When send the delete request and get the response
    Then status code should be two hundreds
    And body should be empty