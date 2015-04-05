Feature: Dashboard
  As an authenticated user
  I want to be able to look at the dashboard
  So that I can see the state of my projects at a glance 
  
  Scenario: See my Project list
    Given I am logged in as User
    When I go to the dashboard
    Then I should see a list of the projects "pierre" is a member of

  Scenario: See my Ticket list
    Given I am logged in as User
    When I go to the dashboard
    Then I should see a list of the tickets assigned to "pierre"