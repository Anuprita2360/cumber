Feature:Login module

## A user can login to application
Background:
Given Launch a browser
And Enter the URL

@smokeTest
Scenario: User can login to application using valid credentials
When Login page is displayed enter valid username and password
And Click on login button
Then Verify Homepage is displayed or not
 
 @FunctionalityTest
Scenario: User can login to application using valid credentials
When Login page is displayed enter valid username "admin12" and password "admin12"
And Click on login button
Then Verify error msg is displayed or not
 
 