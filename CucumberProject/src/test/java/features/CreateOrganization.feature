Feature: Organization module
## user can login to vtiger and create a org

Background:
Given Launch browser
And Enter URL
And In Login Page enter username and password and click on login button
When Click on org link
And Click on create org image

Scenario: Create a org with mandatoy fields
And Enter org name "SDET36L" and select Industry click on save button
Then Verify org "SDET36L" is created or not
 
Scenario Outline: Create a org with mandatoy fields
And Enter org name "<orgName>" and "<email>" click on save button
Then Verify org "<orgName>" is created or not

Examples:
|orgName |  email      |
|SDET36L2|abc@gmail.com|
|SDET36L3|abc123@gmail.com|

Scenario Outline:
And Enter org name orgName and email email select Industry click on save button
|orgName |  email      |
|SDET36L4|abc@gmail.com|
|SDET36L5|abc123@gmail.com|
Then Verify org orgName is created or not
|orgName|
|SDET36L4|
|SDET36L5|