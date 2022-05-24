Narrative:
In order to get a functional VAT calculator for our Outdoor articles, 
As a a user of our GUI
I want to know the price excludet the VAT of 19%


Scenario: 
Calculate outdoor article price without VAT, also know as netprice

Given An Ourdoor article with VAT costs <grossprice>
When I want to know its netprice the calculator should divide 1,19
Then The outdoor article price should be <netprice>

Examples:
|grossprice|netprice|
|11.9|10|
|29.99|25.20158|