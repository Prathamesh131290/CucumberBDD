Feature: Shopping scenario 
	As a potential customer
	I want to browse products and view details
	So that I can make informed purchasing decisions
	
Scenario: View specific product details 

Given I am on the "Product Listing Page" page
When I navigate to "Men Tshirts page" page
And I apply filter by "Tshirts" and sort by "Popularity"
And I click on the first product on "Men Tshirts page" page
Then I should see the "Product Details Page" page