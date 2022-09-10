Feature: FacebookLogin


## A user can login to application

Scenario: User can login to application using valid credentials
Given Launch the browser
And Enter the URL of Facebook
When enter valid username and password
And Click on the login button
Then Verify the Homepage is displayed or not
 
 
Scenario: User can login to application using valid credentials
Given Launch the browser
And Enter the URL of Facebook
When enter valid username "rautanuprita96@gmail.com" and password "Anu@2360"
And Click on the login button
Then Verify the Homepage is displayed or not
 
 