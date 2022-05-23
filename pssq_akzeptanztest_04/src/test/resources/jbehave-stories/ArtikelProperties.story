Narrative:
As a User of the outdoor article GUI
I want to create an outdoor article and set all its properties
In Order to see them correctly in my table view all getter and setters need to work properly.


Scenario: 
Generate example article with all properties

Given An empty outdoor article instance
When I set the article properties to 1, Zelt, 12, 59.99
Then The article properties should be 1, Zelt, 12, 59.99