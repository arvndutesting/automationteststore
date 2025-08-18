Feature: Booking T-Shirt in Automation Test Store Website
  
Background:
  Given User launches chrome browser
  And   User enters the url "https://automationteststore.com/"
  And   User click Register and select Register and click on continue
  When  User enter the login name and password
  Then User click on continue button
  
Scenario: User booking the T-shirt

 When  User click on the T-Shirt
 And   User click on "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie"
 And   User select the White colour
 Then  User clicks on the Add to cart button
 When  User select the Quality of 2 and click on Update
 And   User click on the Confirm Order
 Then  User getting the order details in console