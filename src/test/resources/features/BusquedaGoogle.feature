Feature: Google Search

  Scenario: Search for automation on Google to verify the date and take a screenshot
    Given the user accessed Google and searched for the word "automatización"
    When the user sees the results, they select the Wikipedia link
    Then the information is verified that the year of the first automatic process was in the "siglo XVIII"
    And a screenshot of the Wikipedia page is taken