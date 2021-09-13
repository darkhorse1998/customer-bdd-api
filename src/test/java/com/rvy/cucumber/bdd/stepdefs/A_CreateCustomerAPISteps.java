package com.rvy.cucumber.bdd.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.json.simple.JSONObject;

import com.rvy.entity.Customer;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class A_CreateCustomerAPISteps implements En {
	
	String programSideStatus = "Unsuccessful";
	boolean notNull = false;

	Customer customer = null;
	Customer fetchedCustomer;
//	@Autowired
//	private CustomerRepository cr;
	
	private static final String BASE_URL ="http://localhost:9003/rvy/api/cm/v1";
	RequestSpecification httpRequest;
	private  static  Response response;
	

  public A_CreateCustomerAPISteps(){
	
    Given("Admin wants to register a customer with the following attributes", (DataTable customerDt) -> {
       List<List<String>> customerData = customerDt.asLists(String.class);
       RestAssured.baseURI = BASE_URL;
       httpRequest = RestAssured.given();
	   httpRequest.header("Content-Type",  "application/json"); 

       JSONObject requestParams = new JSONObject();	
       
       requestParams.put("uin", Integer.parseInt(customerData.get(1).get(0))); 
       requestParams.put("name", customerData.get(1).get(1));
       requestParams.put("email", customerData.get(1).get(2));
       requestParams.put("mobile", Long.parseLong(customerData.get(1).get(3)));
       requestParams.put("birthdate",customerData.get(1).get(4));
       requestParams.put("doorNumber", customerData.get(1).get(5));
       requestParams.put("street", customerData.get(1).get(6));
       requestParams.put("city", customerData.get(1).get(7));
       requestParams.put("state", customerData.get(1).get(8));
       requestParams.put("country", customerData.get(1).get(9));
       requestParams.put("zipCode", Long.parseLong(customerData.get(1).get(10)));
//       requestParams.put("regionId",Integer.parseInt(customerData.get(1).get(11)));
       requestParams.put("customerId",null);
       
		httpRequest.body(requestParams.toJSONString());
		System.out.println("RequestParams : "+requestParams.toJSONString());   	


    });
    


    When("admin register the new customer", () -> {
    	response = httpRequest.post("/customers");
		System.out.println("Response : "+response.asPrettyString());   	


    });


    Then("the registration is successful and status code is {string}", (String expectedstatusCode) -> {
    	int statusCode = response.getStatusCode();
		assertEquals(statusCode, Integer.parseInt(expectedstatusCode));
		System.out.println("Response : "+response.asPrettyString());   	
    });
    
   }
}
