package com.rvy.cucumber.bdd.stepdefs;


import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.rvy.entity.Customer;

import cucumber.api.java8.En;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class B_FindCustomerbyAPISteps implements En {


	private static final String BASE_URL ="http://localhost:9003/rvy/api/cm/v1";
	RequestSpecification httpRequest;
	private  static  Response response;
	
	
	public B_FindCustomerbyAPISteps() {
		
		
		Given("Admin wants to find a customer by mobile number",() -> {
			RestAssured.baseURI = BASE_URL;
			httpRequest = RestAssured.given();
			httpRequest.header("Content-Type",  "application/json"); 
			
		});

		When("Customer mobile number is {string}", (String mobile) -> {
//			JSONObject requestParams = new JSONObject();			
//			httpRequest.body(requestParams.toJSONString());
			response = httpRequest.get("/customer/"+mobile);
//			JsonPath jsonPathEvaluator = response.jsonPath();
//			String city = jsonPathEvaluator.get("city");
//			System.out.println("City received from Response " + city);
		});

		Then("Customer is found and status code is {string}", (String expectedstatusCode) -> {
			int statusCode = response.getStatusCode();
			assertEquals(statusCode, Integer.parseInt(expectedstatusCode));
//			System.out.println("Response : "+response.asPrettyString());
//			System.out.println("Response : "+response.jsonPath());
//			System.out.println("Customer ID : "+response.asString().contains("Mumbai"));
			
		});
		
//		Then("Customer is not found and status code is {string}", (String expectedstatusCode) -> {
//			int statusCode = response.getStatusCode();
//			assertEquals(statusCode, Integer.parseInt(expectedstatusCode));
////			System.out.println("Response : "+response.asPrettyString());
////			System.out.println("Customer ID : "+response.asString().contains("Mumbai"));
//			
//		});

	}

	
}

