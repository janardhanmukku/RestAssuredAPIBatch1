package com.w2a.RestAsssured_API_Batch1.StripeAPI;

import java.util.Hashtable;
import java.util.Map;

import com.aventstack.extentreports.Status;
import com.w2a.RestAsssured_API_Batch1.Setup.SetUp;
import com.w2a.RestAsssured_API_Batch1.Utils.TestUtils;

import io.restassured.response.Response;

public class CustomerAPI extends SetUp {

	public static Response createCustomerWithValidAuthKey(Hashtable<String, String> data) {
		
		requestSpec=	TestUtils.setFormParam(data.get("formParam"), requestSpec);
		extentLogger().log(Status.INFO, " Method type is: "+data.get("methodType"));
		extentLogger().info("EndPoint is: "+data.get("endPoint"));
		return requestSpec.request(data.get("methodType"),data.get("endPoint")).then()
				.extract()
				.response();
		
	}

	/*public Response createCustomerWithInValidAuthKey() {

	}*/
	
	
	public static Response deleteACustomer(Map<String,String> testData)
	{
		
		return requestSpec.request(testData.get("methodType"), testData.get("endPoint")+testData.get("customerId"))
		.then()
		.extract()
		.response();
	}
	
	public static Response retriveAllCustomer(Map<String,String> testData)
	{
		return requestSpec.request(testData.get("methodType"), testData.get("endPoint"))
		.then()
		.extract()
		.response();
	}


}
