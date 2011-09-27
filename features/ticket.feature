Feature: Ticket Management
  As an authenticated user
  I want to be able to manage a ticket
  So that I can track defects and changes
  
  Scenario: Create a ticket
    Given I am logged in as User
    When I create a ticket "This is a test" with reference "HUMP-12"
    Then "This is a test" should be in the ticket list

  Scenario: Assign a ticket
    Given I am logged in as User 
    And I have created a ticket
    When I assign the ticket to "Sébastien Le Callonnec"
    Then the ticket should appear in "Sébastien Le Callonnec"'s dashboard

