package com.w2a.RestAsssured_API_Batch1.Utils;

import com.aventstack.extentreports.Status;
import com.w2a.RestAsssured_API_Batch1.Setup.SetUp;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestUtils extends SetUp {
	
	public static RequestSpecification setFormParam(String formParam, RequestSpecification reqSpec)
	{
		String[] splittedFormParam=formParam.split(",");
		//System.out.println("NoOfFormParam:"+splittedFormParam.length);
		for(String s:splittedFormParam)
		{
			//System.out.println("FormParam:-"+s);
			String[] keyValue=s.split(":");
			//System.out.println("key-->"+keyValue[0]);
			//System.out.println("Value-->"+keyValue[1]);
			reqSpec.formParam(keyValue[0], keyValue[1]);
			testCaseLogger.get().log(Status.INFO, "Added "+keyValue[0]+" as FormParam with value "+keyValue[1]);
		}
		
		
		return reqSpec;
		
	}
	
	public static void appendResponseInReport(Response response)
	{
		extentLogger().info("<details>" + "<summary>" + "<b>" + "<font color=" + "Green>" + "Click here to see Response"
						+ "</font>" + "</b >" + "</summary>" + response.asString() + "</details>"
						+ " \n");
	}

}
