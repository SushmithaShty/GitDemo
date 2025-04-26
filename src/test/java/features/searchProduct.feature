Feature: Search and Place the Order for Products

@OffersPage
Scenario Outline: Search Experience for the product search in both home and offers page

  Given User is On the GreenCart Landing Page
  When User Searched with ShortName <Name> and extract the Actual Name of the Product
  Then user searched for the <Name> shortname in offers page
  And validate product name in offers page matches with Landing Page

Examples:
 | Name  |
 | Tom   |
 | Beet  |
