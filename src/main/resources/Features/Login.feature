Feature: Login functionality

Background: Launching the browser and url
 Given Launch the browser and enter the Url
 
 
Scenario:  Login with no password and check Login Error Message 

When User enters Username in the text field 
Then clears the password field
And Clicks login button
Then checks Error messag Please enter your password should be displayed
 
 Scenario: Login with valid credentials

When User enters valid Username in the username field 
Then Enters the valid password in the password field
 And Clicks login button

 
 Scenario: Login with Invalid credentials

When User enters invalid Username in the username field 
Then Enters the invalid password in the password field
And Clicks login button
Then Error message should be displayed
 
 