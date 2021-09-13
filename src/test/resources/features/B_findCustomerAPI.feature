Feature: Find Customer API

  Scenario: FINDING CUSTOMER BY ID API

    Given Admin wants to find a customer by mobile number
    When Customer mobile number is '8787878787'
    Then Customer is found and status code is '200'
    
    
    
   #Scenario: FINDING CUSTOMER BY ID API (FAIL)
#
    #Given Admin wants to find a customer by ID 
    #When Customer ID is '-1'
    #Then Customer is not found and status code is '500'
    #
    #
    #
    

