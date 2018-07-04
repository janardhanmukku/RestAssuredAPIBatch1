package com.w2a.RestAsssured_API_Batch1.Utils;


import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ 
	"file:src\\test\\resources\\propertyFiles\\${environment}.properties" // mention the property file name
})
public interface ConfigProperties extends  Config{

	@Key("baseURI")
	String getBaseURI();
	
	@Key("basePath")
	String getBasePath();
	
	@Key("sheetName")
	String getSheetName();
	
	@Key("validsecretKey")
	String getValidKey();
	
	@Key("invalidsecretKey")
	String getInValidKey();
}
