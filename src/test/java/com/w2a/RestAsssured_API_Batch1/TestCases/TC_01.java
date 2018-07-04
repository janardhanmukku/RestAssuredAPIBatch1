package com.w2a.RestAsssured_API_Batch1.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.w2a.RestAsssured_API_Batch1.Setup.SetUp;
import com.w2a.RestAsssured_API_Batch1.Utils.DataProviderClass;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.path.json.JsonPath.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class TC_01 extends SetUp{
	//Execu
	
	@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp")
	public void retriveAllCustomers(Hashtable<String,String> data) {
		

		testCaseLogger.get().assignAuthor("Rahul Jha");
		
		Response response = given().auth().basic(testEnvironment.getValidKey(), "").when()
				.get(data.get("endPoint")).then().extract().response();
		testCaseLogger.get().log(Status.INFO, "called API to retrive all customers");
		//System.out.println(response.asString());
		@SuppressWarnings("unused")
		JsonPath jp= new JsonPath(response.asString());
	
		
		
		ArrayList<Map<String,?>> jsonAsArrayList =from(response.asString()).get("data.id");
		System.out.println("Size of json-->"+jsonAsArrayList);
		/*System.out.println("-->"+jp.get("subscriptions.size()"));
		String s=jp.get("subscriptions.size()");
	*/
	
	}
	

	
	
/*	@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp")
	public void deleteACustomer(Hashtable<String,String> data)
	{
		testCaseLogger.get().assignAuthor("Rahul Jha");
	
		Response response = given().auth().basic(testEnvironment.getKey(), "").when()
				.delete(data.get("endPoint")+"/"+data.get("customerId")).then().extract().response();
		
		System.out.println(response.asString());
		
	}*/

}
