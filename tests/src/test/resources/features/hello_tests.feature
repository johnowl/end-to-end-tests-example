Feature: Hello

  Scenario: Say hello
    Given I call the "/hello" endpoint with the "GET" method
    Then I receive the message "Hello world!"