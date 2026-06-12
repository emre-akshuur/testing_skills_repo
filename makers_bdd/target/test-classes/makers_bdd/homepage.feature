Feature: Homepage

  Scenario: Can access the FAQ page from the homepage
    Given I am on the Makers homepage
    When I click the "FAQ" link
    Then I should be on the FAQ page


  Scenario Outline: Can access links from homepage
    Given I am on the Makers homepage
    When I click the "<link_name>" link
    Then I should be on a page containing "<expected_url>"
    Examples:
      | link_name       |         expected_url      |
      | FAQ             |         faq.makers.tech   |
      | Academy         |         academy           |
      | Apprenticeships |         makers.tech/learn/apprenticeships   |
      | Reviews         |         coursereport      |
