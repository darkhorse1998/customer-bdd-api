//package com.rvy.cucumber.bdd.stepdefs;
//
//
//import static org.junit.Assert.assertEquals;
//
//import org.json.simple.JSONObject;
//
//import cucumber.api.java8.En;
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class C_updateCustomerAPISteps implements En {
//	
//	
//	private static final String BASE_URL ="http://localhost:9003/rvy/api/cm/v1";
//	RequestSpecification httpRequest;
//	RequestSpecification httpRequest1;
//	private  static  Response response;
//	private  static  Response fetchResponse;
//	private  static  Response editResponse;
//	
//	
//  public C_updateCustomerAPISteps() {
//	  	  
//    Given("The customer exists with mobile number {string} and Admin wants to update the name", (String mobile) -> {
//    	RestAssured.baseURI = BASE_URL;
//		httpRequest = RestAssured.given();
//		httpRequest1 = RestAssured.given();
//		httpRequest.header("Content-Type",  "application/json");
//		response = httpRequest.get("/customer/"+mobile);
//		
//		
//    });
//
//    When("admin updates the customer name to {string}", (String name) -> {    	
//    	
//    	JsonPath jsonPathEvaluator = response.jsonPath();
//		Integer id = jsonPathEvaluator.get("customerId");
//		fetchResponse = httpRequest.get("/customers/"+id);
//		JsonPath jsonPathEvaluator1 = fetchResponse.jsonPath();
//		JSONObject requestParams = new JSONObject();	
//	       
//       requestParams.put("uin", Integer.parseInt(jsonPathEvaluator1.get("uin"))); 
//       requestParams.put("name", name);
//       requestParams.put("email", jsonPathEvaluator1.get("email"));
//       requestParams.put("mobile", Long.parseLong(jsonPathEvaluator1.get("mobile")));
//       requestParams.put("birthdate",jsonPathEvaluator1.get("birthdate"));
//       requestParams.put("doorNumber", jsonPathEvaluator1.get("doorNumber"));
//       requestParams.put("street", jsonPathEvaluator1.get("street"));
//       requestParams.put("city", jsonPathEvaluator1.get("city"));
//       requestParams.put("state", jsonPathEvaluator1.get("state"));
//       requestParams.put("country", jsonPathEvaluator1.get("country"));
//       requestParams.put("zipCode", Long.parseLong(jsonPathEvaluator1.get("zipCode")));
//       requestParams.put("customerId",Integer.parseInt(jsonPathEvaluator1.get("customerId")));
//       
//       httpRequest1.body(requestParams.toJSONString());
//       editResponse = httpRequest1.put("/customers");
//       
//       
//    });
//
//    Then("the update is done and the status code is {string}", (String expectedstatusCode) -> {
//    	int statusCode = editResponse.getStatusCode();
//		assertEquals(statusCode, Integer.parseInt(expectedstatusCode));
//    });
//  }
//
//}
//
