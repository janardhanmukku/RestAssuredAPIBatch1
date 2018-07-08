package com.w2a.RestAsssured_API_Batch1.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.w2a.RestAsssured_API_Batch1.POJO.Customers;
import com.w2a.RestAsssured_API_Batch1.POJO.Data;
import com.w2a.RestAsssured_API_Batch1.Setup.SetUp;
import com.w2a.RestAsssured_API_Batch1.StripeAPI.CustomerAPI;
import com.w2a.RestAsssured_API_Batch1.Utils.DataProviderClass;

import io.restassured.mapper.ObjectMapperType;
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
import java.util.List;
import java.util.Map;

public class TC_01 extends SetUp {
	// Execu
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "dp")
	public void validateRetriveCustomersWithInvalidKey(Map<String,String> data)
	{
		
		Response response=CustomerAPI.retriveAllCustomer(data);
		System.out.println(response.statusCode());
		//Assert.assertEquals(response.statusCode(), data.get("expectedStatusCode"));
		//System.out.println(response.asString());
		
		JsonPath json=response.jsonPath();
		//json.get("data[5].id")
		int sizeOfData=json.get("data.size()");
		System.out.println(sizeOfData);
		System.out.println(json.get("data[0]"));
		assertThat(sizeOfData).isEqualTo(Integer.parseInt(data.get("expectedDataSize")));
		for(int i=0;i<sizeOfData;i++)
		{
			String dataArray="data["+i+"]";
			//System.out.println(json.get(dataArray));
			if(json.get(dataArray+".id").equals(data.get("id")))
			{
				//System.out.println("inside if");
				System.out.println(json.get(dataArray+".email"));
				System.out.println(json.get(dataArray+".sources.url"));
				System.out.println(json.get(dataArray+".sources.size()"));
			}
		}
		
		/*List<Map<String,?>> listOfData=json.get("data");
		for(Map<String,?> list:listOfData)
		{
			
			if(list.get("id").equals(data.get("id")))
			{
				System.out.println(list.get("id"));
				System.out.println(list.get("email"));
				System.out.println(list.get("sources.url"));
			}
		}*/
		
		
		//given().header("authtoken","dsfsdf","","","","").request("", "").then().extract().response();
	}
	
	
	
	
/*
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "dp")
	public void retriveAllCustomers(Hashtable<String, String> data) {

		testCaseLogger.get().assignAuthor("Rahul Jha");

		Response response = given().auth().basic(testEnvironment.getValidKey(), "").when().get(data.get("endPoint"))
				.then().extract().response();
		
		Customers customers=	response.as(Customers.class, ObjectMapperType.JACKSON_2);
		System.out.println(customers.getObject());
		Data[] datas= customers.getData();
		System.out.println(datas.length);
		
		
		testCaseLogger.get().log(Status.INFO, "called API to retrive all customers");
		// System.out.println(response.asString());
		System.out.println("---------ASserting-------------" + response.jsonPath().get("data.size()").toString());
		// Assert.assertEquals(response.jsonPath().get("data.size()").toString(),
		// "12");
		assertThat(response.jsonPath().get("data.size()")).isEqualTo(10);

		System.out.println(response.jsonPath().get("data[0]"));
		List<String> listOfIds = response.jsonPath().get("data.id");
		List<Map<String,?>> s=response.jsonPath().get("data");
		for(Map<String,?> a:s)
		{
			if(a.get("id").equals("cus_D9ihuaPWsiQw3K"))
			{
				System.out.println(a.get("email"));
			}
		}
		
		for (String ids : listOfIds) {
			System.out.println("customer Id: " + ids);

		}

		
		 * @SuppressWarnings("unused") JsonPath jp= new
		 * JsonPath(response.asString());
		 * 
		 * 
		 * 
		 * ArrayList<Map<String,?>> jsonAsArrayList
		 * =from(response.asString()).get("data.id");
		 * System.out.println("Size of json-->"+jsonAsArrayList);
		 * System.out.println("-->"+jp.get("subscriptions.size()")); String
		 * s=jp.get("subscriptions.size()");
		 

	}*/

	/*
	 * @Test(dataProviderClass=DataProviderClass.class,dataProvider="dp") public
	 * void deleteACustomer(Hashtable<String,String> data) {
	 * testCaseLogger.get().assignAuthor("Rahul Jha");
	 * 
	 * Response response = given().auth().basic(testEnvironment.getKey(),
	 * "").when()
	 * .delete(data.get("endPoint")+"/"+data.get("customerId")).then().extract()
	 * .response();
	 * 
	 * System.out.println(response.asString());
	 * 
	 * }
	 */

}
