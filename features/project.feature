Feature: Project Management
  As an Administrator
  I want to be able to manage a project
  So that I can track tickets and users for this project
  
  Scenario: Create a project
    Given I am logged in as Administrator
    When I create a project "Humphries" with code "HUMP"
    Then "Humphries" should be in the project list

  Scenario: Add a project member
    Given I am logged in as Administrator
    When I add "Sébastien Le Callonnec" as a "Humphries" project member
    Then "Sébastien" should be a member of the "Humphries" project

# TODO
# Remove project member
# Tag/untag a project
# 