Narrative:
For the development of a functional VAT calculator, 
we need to know the basis of calculation.
In Germany, the VAT is currently 19%. 


Scenario: 
Calculate outdoor article price without VAT

Given An Ourdoor article with VAT costs <grossprice>
When I want to know its netprice the calculator should divide 1,19
Then The outdoor article price should be <netprice>

Examples:
|grossprice|netprice|
|11.9|10|
|29.99|25.20158|