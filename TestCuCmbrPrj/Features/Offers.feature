Feature: Offers

Scenario: Verify the Total Number of offers 
 Given I have submitted a POST Request via uri 
 When I verify or count the number of Offers JSON Objects returned 
 Then The total number of offers objects will be five

Scenario: Verify Offer_ID for given offers
 Given I have submitted a POST Request via uri 
 When I verify or review the offer_id from the OfferList
 Then The Offer_ID will be valid and NOT Null 

Scenario: Verify Customers Email Address on given Offers 
 Given I have submitted a POST Request via uri 
 When I verify or review the emailadr from Customer Object 
 Then  The format of the email is Valid and NOT Null 
