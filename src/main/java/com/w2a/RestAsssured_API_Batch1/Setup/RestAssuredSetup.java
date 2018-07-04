package com.w2a.RestAsssured_API_Batch1.Setup;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class RestAssuredSetup {

	
	@BeforeSuite(alwaysRun=true)
	public void configureRestAssured()
	{
		
		RestAssured.baseURI="";
		RestAssured.basePath="";
		
	}
}
