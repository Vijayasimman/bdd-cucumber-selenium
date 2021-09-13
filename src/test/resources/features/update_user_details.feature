Feature: Update user details in salesforce portal

@chrome
Scenario Outline: Update user details in Lightning web component
Given user is on salesforce developers portal
When clicks on component reference tab
Then component reference page is loaded
When user searches datatable under lightning web components
Then datatable is loaded
When user selects data table with inline edit option under example
And clicks run button
Then preview is loaded
When user edits label in row 3
Then label in row 3 is updated

@firefox
Scenario Outline: Update user details in Lightning web component
Given user is on salesforce developers portal
When clicks on component reference tab
Then component reference page is loaded
When user searches datatable under lightning web components
Then datatable is loaded
When user selects data table with inline edit option under example
And clicks run button
Then preview is loaded
When user edits label in row 3
Then label in row 3 is updated

@ie
Scenario Outline: Update user details in Lightning web component
Given user is on salesforce developers portal
When clicks on component reference tab
Then component reference page is loaded
When user searches datatable under lightning web components
Then datatable is loaded
When user selects data table with inline edit option under example
And clicks run button
Then preview is loaded
When user edits label in row 3
Then label in row 3 is updated


