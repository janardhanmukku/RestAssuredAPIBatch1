package com.w2a.RestAsssured_API_Batch1.TestCases;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.RestAsssured_API_Batch1.Setup.SetUp;
import com.w2a.RestAsssured_API_Batch1.StripeAPI.CustomerAPI;
import com.w2a.RestAsssured_API_Batch1.Utils.DataProviderClass;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;
import static io.restassured.path.json.JsonPath.*;

public class DeleteCustomerAPITest extends SetUp{

	
	@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp")
	public void validateDeleteCustomerAPIOfValidCustomer(Map<String,String> testData) {

		
	Response response=	CustomerAPI.deleteACustomer(testData);
	
	System.out.println(response.jsonPath().get("id"));
	
	
	}

	public void validateDeleteCustomerAPIWithValidSecretKey() {

	}

	public void validateDeleteCustomerAPIWithInValidSecretKey() {

	}

	public void validateDeleteCustomerAPIWithoutCustomerId6() {

	}

}
