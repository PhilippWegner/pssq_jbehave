Narrative:
In order to develop a function article, 
As a developer
I want to know all of its properties


Scenario: 
Generate example article with all properties

Given An empty outdoor article instance
When I set the article properties to 1, Zelt, 12, 59.99
Then The article properties should be 1, Zelt, 12, 59.99