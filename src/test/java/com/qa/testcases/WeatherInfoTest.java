package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.utils.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class WeatherInfoTest {
	@Test(dataProviderClass=TestUtil.class,dataProvider="getData")
	public void getWeatherDetailswithCity(String city,String method,String temp,String humidity,String windspeed,String windDirection){
		//Define base Url
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//define http request
		
		RequestSpecification  httpRequest =RestAssured.given();
		
		//make the request 
		Response response= httpRequest.request(Method.GET,"/"+city);
		
		//get response body
		
		String  body =response.getBody().asString();
		System.out.println(body);
		Assert.assertEquals(body.contains(city), true);
		
		//get status code
		int statuscode =response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
		//fethch headers
		Headers  headers =response.headers();
		
		System.out.println(headers);
		Assert.assertEquals("application/json", headers.getValue("Content-Type"));
		
		//fetch key value pair by using jsonPath
		
		JsonPath jsonPathvalue = response.jsonPath();
		Assert.assertEquals(jsonPathvalue.get("City"), city);
		
		Assert.assertEquals(jsonPathvalue.get("Humidity"), humidity);
		
		
		
	}
	
	@Test
	public void sampleTestforGit(){
		System.out.println("This test is a sample test for Git");
	}
}
