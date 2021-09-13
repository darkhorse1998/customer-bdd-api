package com.rvy.cucumber.bdd.stepdefs;


import static org.junit.Assert.assertEquals;


import cucumber.api.java8.En;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class D_DeleteCustomerAPISteps implements En {
	
	private static final String BASE_URL ="http://localhost:9003/rvy/api/cm/v1";
	RequestSpecification httpRequest;
	private  static  Response response;
	private static Response delResponse;
	
	
	public D_DeleteCustomerAPISteps() {
		
		
		Given("The customer exists and Admin wants to delete the customer by mobile number",() -> {
			RestAssured.baseURI = BASE_URL;
			httpRequest = RestAssured.given();
			httpRequest.header("Content-Type",  "application/json"); 
			
		});

		When("Admin wants to delete the customer with mobile {string}", (String mobile) -> {
//			JSONObject requestParams = new JSONObject();			
//			httpRequest.body(requestParams.toJSONString());
			response = httpRequest.get("/customer/"+mobile);
			JsonPath jsonPathEvaluator = response.jsonPath();
			Integer id = jsonPathEvaluator.get("customerId");
			delResponse = httpRequest.delete("/customers/"+id);
		});

		Then("Customer is deleted and status code is {string}", (String expectedstatusCode) -> {
			int statusCode = delResponse.getStatusCode();
			assertEquals(statusCode, Integer.parseInt(expectedstatusCode));		
		});
		
		Then("Customer is not deleted and status code is {string}", (String expectedstatusCode) -> {
			int statusCode = delResponse.getStatusCode();
			assertEquals(statusCode, Integer.parseInt(expectedstatusCode));
		});

	}

	
}

