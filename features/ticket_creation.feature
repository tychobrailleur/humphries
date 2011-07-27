Feature: Ticket Creation
  As an Administrator
  I want to be able to create a ticket
  So that I can log a new defect
  
  Scenario: Create a ticket
    Given I am logged in as Administrator
    When I go to the Admin page
    Then I should see "Add" for "Tickets"
