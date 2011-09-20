Feature: User Authentication
  As a user
  I want to be able to authenticate
  So that I manage my tickets

  Scenario: Authenticate
    Given I am on the home page
    When I authenticate as "pierre"
    Then I should see I am logged in as "pierre"

  Scenario: Sign out
    Given I am logged in as "pierre"
    When I sign out
    Then I should see I am not logged in as "pierre"
