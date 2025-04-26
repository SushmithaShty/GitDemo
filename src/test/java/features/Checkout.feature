Feature: Place the Order for Products

@PlaceOrder
Scenario Outline: Search Experience for the product search in both home and offers page

  Given User is On the GreenCart Landing Page
  When User Searched with ShortName <Name> and extract the Actual Name of the Product
  And Added 3 items of the selected product to the cart
  Then User procceds to Checkout and validates the <Name> items in checkout page
  And verify user has ability to enter promo code and place the order

Examples:
 | Name  |
 | Tom   |