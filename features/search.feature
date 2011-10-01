Feature: Search
  As an authenticated user
  I want to be able to search for tickets
  So that I can retrieve the tickets I am interested in

  Scenario: Search for a ticket by its title
    Given I am logged in as User
    When I search for 'spike'
    Then I should find 'HUMP-1'

  Scenario: Search for ticket with a tag
    Given I am logged in as User
    When I search for 'intro'
    Then I should find 'HUMP-1'

# TODO
# Search ticket description
# Search project
# Search user