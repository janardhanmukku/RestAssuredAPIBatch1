package com.w2a.RestAsssured_API_Batch1.TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;
import java.util.Hashtable;

import com.w2a.RestAsssured_API_Batch1.Setup.SetUp;
import com.w2a.RestAsssured_API_Batch1.StripeAPI.CustomerAPI;
import com.w2a.RestAsssured_API_Batch1.Utils.DataProviderClass;
import com.w2a.RestAsssured_API_Batch1.Utils.TestUtils;

import io.restassured.path.json.JsonPath;
import static io.restassured.path.json.JsonPath.*;
import io.restassured.response.Response;
//import static io.restassured.

public class ValidateCreateCustomerAPI extends SetUp {

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "dp")
	public void validateCreateCustomerWithValidAuthKey(Hashtable<String, String> data) {

		testCaseLogger.get().assignAuthor("Rahul Jha");
		testCaseLogger.get().assignCategory("Regression");

		Response response = CustomerAPI.createCustomerWithValidAuthKey(data);
		TestUtils.appendResponseInReport(response);
	/*	int i = from(response.asString()).getInt("subscriptions.length()");
		System.out.println("length-->" + i);*/
		// System.out.println(response.asString());
		JsonPath jsonResponse = response.jsonPath();
		System.out.println("Response Email Id-" + jsonResponse.get("email"));
		
		//assertThat(jsonResponse.get("email")).isEqualTo(data.get("expectedEmailId"));
		
	//	System.out.println("Subscription URL-" + jsonResponse.get("subscriptions.length()"));
		
		System.out.println(response.asString());
		//System.out.println(jsonResponse.getList("subscriptions").size());
	
		JsonPath jp= new JsonPath(response.asString());
		System.out.println("-->"+jp.get("subscriptions.size()"));
		System.out.println(jp.get("id").toString());
		

	}

}
