Feature: Product Search on EmiratesRed

  As an online shopper on EmiratesRed
  I want to search for products
  So that I can find items I wish to purchase more easily

  Background:
    Given I am on the EmiratesRed homepage

  Scenario: Search for a product using a valid search term
    When I enter "perfume" into the search box
    And I click the search button
    Then I should see a list of products related to "perfume"

  Scenario: No results found for a search term
    When I enter "xyz123" into the search box
    And I click the search button
    Then I should see a message indicating no products found

  Scenario Outline: Using suggestions from the search auto-suggestions
    When I start typing "<partial_search_term>" in the search box
    Then I should see suggestions related to "<partial_search_term>"
    When I select "<full_search_term>" from the suggestions
    And I click the search button
    Then I should see a list of products related to "<full_search_term>"

    Examples:
      | partial_search_term | full_search_term  |
      | perf               | perfume           |
      | watc               | watches           |
      | sun                | sunglasses        |

  Scenario: Applying filters to a search
    Given I have searched for "shoes"
    When I apply the filter for brand "Nike"
    And I apply the filter for size "10"
    Then I should see a list of "Nike" shoes in size "10"

  Scenario: Sorting search results
    Given I have searched for "bags"
    When I sort the results by price in ascending order
    Then I should see the list of bags sorted by price from low to high
