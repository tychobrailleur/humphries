@wip
Feature: Project Creation
  As an Administrator
  I want to be able to create a project
  So that I can track tickets for this project
  
  Scenario: Create a project
    Given I am logged in as Administrator
    When I create a project "Humphries" with code "HUMP"
    Then "Humphries" should be in the project list
