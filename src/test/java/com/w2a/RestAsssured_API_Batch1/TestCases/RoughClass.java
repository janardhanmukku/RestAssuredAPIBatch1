package com.w2a.RestAsssured_API_Batch1.TestCases;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.RestAsssured_API_Batch1.POJO.Customers;
import com.w2a.RestAsssured_API_Batch1.POJO.Data;
import com.w2a.RestAsssured_API_Batch1.POJO.Subscriptions;
import com.w2a.RestAsssured_API_Batch1.Setup.SetUp;
import com.w2a.RestAsssured_API_Batch1.StripeAPI.CustomerAPI;
import com.w2a.RestAsssured_API_Batch1.Utils.DataProviderClass;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class RoughClass extends SetUp {

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "dp")
	public void verifyCustomerUsingPOJO(Map<String, String> data) {

		Response response = CustomerAPI.retriveAllCustomer(data);

		System.out.println(response.asString());

		Customers customers = response.as(Customers.class, ObjectMapperType.JACKSON_2);
		assertTrue(customers.getHas_more());
		Data[] dataArray = customers.getData();
		Assert.assertEquals(dataArray.length, 10);

		for (Data d : dataArray) {
			if (d.getId().equals(data.get("id"))) {

				System.out.println(d.getEmail());
				Subscriptions subscription=d.getSubscriptions();
				System.out.println(subscription.getUrl());
			}
		}

	}

}
