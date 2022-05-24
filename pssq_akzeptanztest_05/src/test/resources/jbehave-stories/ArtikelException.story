Narrative:
As a User of the outdoor article GUI
I want to create an outdoor article and set all its properties
In Order to see them correctly in my table view all getter and setters need to work properly.

			 
Scenario: 
Generate example article with wrong ID type

Given An empty outdoor article instance is created
When I set the article ID property to -1
Then I get an IllegalArgumentException