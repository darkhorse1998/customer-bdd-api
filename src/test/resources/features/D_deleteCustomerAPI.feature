Feature: Delete Customer

  Scenario: DELETING CUSTOMER BY ID
    
    Given The customer exists and Admin wants to delete the customer by mobile number
    When Admin wants to delete the customer with mobile '8787878787'
    Then Customer is deleted and status code is '200'

    
   #Scenario: DELETING CUSTOMER BY ID (FAIL)
#
   #Given The customer exists and Admin wants to delete the customer by mobile number
    #When Admin wants to delete the customer with mobile '85201'
    #Then Customer is not deleted and status code is '500'