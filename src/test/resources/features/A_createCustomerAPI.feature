Feature: Registering a customer

	Mandatory details for registering a new customer can be his/her name,Unique ID and mobile number.
	
  Scenario: For registering a new customer, his/her Unique ID should not be blank.
	
    Given Admin wants to register a customer with the following attributes
      | uin  | name         | email             | mobile     | birthdate | doorNumber   | street   |city   | state       | country |zipCode |regionId |
    	| 111518  | Andhera kayam | ak@gmail.com | 8787878787 | 2009-01-01| Door 9	    | Street 7  |Mumbai   | Maharashtra | India   |769007  |1211  |
    When admin register the new customer
    Then the registration is successful and status code is '200'
    
    #Scenario Outline: For registering a new customer, his/her UIN and mobile should not be repeated.
	
    #Given Admin wants to register a customer with the following attributes
      #| uin  | name         | email             | mobile     | birthdate | doorNumber   | street   |city   | state       | country |zipCode |regionId |
    #	| "<uin>"  | Andhera kayam | ak@gmail.com | "<mobile>" | 2009-01-01| Door 9	    | Street 7  |Mumbai   | Maharashtra | India   |769007  |1214  |
    #When admin register the new customer
    #Then the registration is "<status>" and status code is "<statuscode>"
    #
    #Examples:
  #	
  #	|      uin     |   mobile    |status      | statuscode |
  #	|15058         | 8989898989  |Unsuccessful|     500		|
  #	|15058			   | 7070707777  |Unsuccessful|			500   |
  #	|14589			   | 8989898989  |Unsuccessful|			500		|
  
    
    
    
    
    
  
  	
  	
