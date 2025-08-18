
Feature: Register and Logging into Automation Test Store
  
Background:
  Given User launches chrome browser
  And   User enters the url "https://automationteststore.com/"
  And   User click Register and select Register and click on continue
  When User enter the login name and password
 
 @sanity 
Scenario: Singup with valid details  
  And   User enters all the required details
  Then  User click on Privacy policy and click on continue button
 
 @smoke 
Scenario: Signin with valid details
  When User enter the login name and password
  Then User click on continue button
 
   

