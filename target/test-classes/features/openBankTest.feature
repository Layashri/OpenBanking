Feature: Open banking product validation

  As a user I would like to get product and outage details
  @getproducts @regression
  Scenario: To validate user able to get product details

    Given user gets all products of open banking
    When user gets particular product detail for a product
    Then user verifies the response is 200

  @regression @errorValidation
  Scenario: To validate error message when product id mismatch

    Given user gets all products of open banking
    When user sets invalid product id
    Then user verifies the response is 422
    And user should see error code [ERROR-422-1008]
    And error title should be [Invalid product]
    And error detail should be [Product not found.]


  @regression @productWithFilter
  Scenario Outline: To get products filtered based on the product-category
    Given user gets all products of open banking
    When user  sets filter <parameter> to <value>
    And user gets all products of open banking with filter
    Then user validates the end point retrieves only filtered data

    Examples:
      | parameter |value|
      | product-category|TERM_DEPOSITS|
      | product-category|TRANS_AND_SAVINGS_ACCOUNTS|

  @regression
  Scenario: To get products filtered based on multiple filters
    Given user gets all products of open banking
    When user  sets filter page to 1
    When user  sets filter product-category to TRANS_AND_SAVINGS_ACCOUNTS
    And user gets all products of open banking with filter
    Then user validates the end point retrieves only filtered data

  @regression @getoutage
  Scenario: To get the list of Outages
    Given user gets the list of outages
    Then user verifies the response is 200
