@wip
Feature: Ticket Creation
  As an Administrator
  I want to be able to create a ticket
  So that I can log a new defect
  
  Scenario: Create a ticket
    Given I am logged in as Administrator
    When I go to the Ticket page
    Then I should see "New Ticket"
    
    Given I am on the "Ticket List" page
    When I click on the "New Ticket" link
    Then I should see "Create Ticket"
    
    Given I am on the "Create Ticket" page
    When I fill "name" with "This is a test"
    And I fill "reference" with "HUMP-12"
    And I fill "description" with "Lorem ipsum"
    And I click on the "create" button 
    # For some strange reason, webrat/ mechanize cannot see the response 
    # after page is submitted, so must explicitly go to the list page.
    And go to the Ticket page
    Then I should see "This is a test" 
    And I should see "HUMP-12"
    And I should see "Lorem ipsum"
