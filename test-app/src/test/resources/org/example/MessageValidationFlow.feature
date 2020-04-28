Feature: MessageValidationFlowValidation
  Send 10 messages and validate responses from server

  Scenario: Send INCORRECT message with id 1
    Given message with id 1 and sender "VERY_VERY_BAD_SENDER" and company "VERY_NOT_GOOD_COMPANY" and session status "SESSION_DESTROYED"
    When send message to server
    Then validate returned response id 1 and validation status "failed"

  Scenario: Send CORRECT message with id 2
    Given message with id 2 and sender "GOOD_SENDER" and company "GOOD_COMPANY" and session status "SESSION_OK"
    When send message to server
    Then validate returned response id 2 and validation status "success"

  Scenario: Send INCORRECT message with id 3 and SESSION_WRONG
    Given message with id 3 and sender "GOOD_SENDER" and company "GOOD_COMPANY" and session status "SESSION_WRONG"
    When send message to server
    Then validate returned response id 3 and validation status "failed"

  Scenario: Send INCORRECT message with id 4 and BAD_COMPANY
    Given message with id 4 and sender "GOOD_SENDER" and company "BAD_COMPANY" and session status "SESSION_OK"
    When send message to server
    Then validate returned response id 4 and validation status "failed"

  Scenario: Send CORRECT message with id 5
    Given message with id 5 and sender "GOOD_SENDER" and company "GOOD_COMPANY" and session status "SESSION_OK"
    When send message to server
    Then validate returned response id 5 and validation status "success"

  Scenario: Send CORRECT message with id 6
    Given message with id 6 and sender "GOOD_SENDER" and company "GOOD_COMPANY" and session status "SESSION_OK"
    When send message to server
    Then validate returned response id 6 and validation status "success"

  Scenario: Send INCORRECT message with id 7 and BAD_SENDER
    Given message with id 7 and sender "BAD_SENDER" and company "GOOD_COMPANY" and session status "SESSION_OK"
    When send message to server
    Then validate returned response id 7 and validation status "failed"

  Scenario: Send CORRECT message with id 8
    Given message with id 8 and sender "GOOD_SENDER" and company "GOOD_COMPANY" and session status "SESSION_OK"
    When send message to server
    Then validate returned response id 8 and validation status "success"

  Scenario: Send CORRECT message with id 9
    Given message with id 9 and sender "GOOD_SENDER" and company "GOOD_COMPANY" and session status "SESSION_OK"
    When send message to server
    Then validate returned response id 9 and validation status "success"

  Scenario: Send INCORRECT message with id 10 and BAD_SENDER and BAD_COMPANY
    Given message with id 10 and sender "BAD_SENDER" and company "BAD_COMPANY" and session status "SESSION_OK"
    When send message to server
    Then validate returned response id 10 and validation status "failed"