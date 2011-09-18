@wip
Feature: Ticket Creation
  As a authenticated user
  I want to be able to create a ticket
  So that I can log a new defect
  
  Scenario: Create a ticket
    Given I am logged in as User
    When I create a ticket "This is a test" with reference "HUMP-12"
    Then "This is a test" should be in the ticket list
