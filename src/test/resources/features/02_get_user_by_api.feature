@End2End
Feature: Get User By API

  @ReadUser @Api #Before("@Api") methodunun bu method öncesi çalışabilmesi için bu annotation gerekli. Aksi taktirde spec objesi null kalır
  Scenario: Read User
    Given set the url for get request
    And set the expected data for get request
    When send the get request and get the response
    Then do assertion for get request