Feature: Campaign Module

Scenario Outline:
When Click on Campaigns link
And Click on create Campaigns image
And Enter Campaign name "<CampaignName>" click on save button
|CampaignName|
|SDET36L4|
|SDET36L5|
Then Verify Campaign "<CampaignName>" is created or not
|CampaignName|
|SDET36L4|
|SDET36L5|
