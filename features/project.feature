Feature: Project Management
  As an Administrator
  I want to be able to manage a project
  So that I can track tickets and users for this project
  
  Scenario: Create a project
    Given I am logged in as Administrator
    When I create a project "Humphries" with code "HUMP"
    Then "Humphries" should be in the project list

  @wip
  # FIXME, see project steps.
  # This test is failing because of an issue with webrat/mechanize
  # that doesn't see pages after forms are submitted or links are clicked.
  Scenario: Add a project member
    Given I am logged in as Administrator
    When I add "Sébastien" as a "Humphries" project member
    Then "Sébastien" should be a member of the "Humphries" project
