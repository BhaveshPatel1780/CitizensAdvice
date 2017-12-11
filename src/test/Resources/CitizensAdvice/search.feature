@search
  Feature: Search google for Citizens Advice and verifying the search functionality on the Citizens Advice website.

    Scenario: As a user I should able to search 'Citizens Advice' from google
              and verify menu header item list
              and search functionality from homepage
              So that I can explore different functionality the Citizens Advice website

      Given I am Google search page
      And I search for 'Citizens Advice'
      When I navigate to Citizens Advice homepage
      Then I should able to see a list of items on main navigation header on the homepage
      When I search for "Pension" related help on the homepage
      Then I should able to verify "State Pension" link in search result


