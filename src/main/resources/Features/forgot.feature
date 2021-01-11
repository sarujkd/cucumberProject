Feature: ForgotPassword functionality

Background:
 Given user is in login page
 
#Scenario: Forgot password Test

#When User enters Username in the field
#Then Clicks ForgotPassword 
#Then Navigate to ForgotPassword page
#Then Enters Username in the text field
#Then  clicks continue button

Scenario: check RememberMe 
 When User enters valid username and password
 Then clicks RememberMe Check box
 And clicks login button
 Then user navigates to homepage
 When User clicks username Drop down
 And clicks logout
 Then validates Username is present in the username field
 
 
