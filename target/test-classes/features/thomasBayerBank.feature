Feature: Check if Bank Details are correct

  Scenario: Get the Bank detail based on blz number
    Given Make the request to thomasBayer Bank Service
    When check in the response if all okay
    Then Should be able to check details
