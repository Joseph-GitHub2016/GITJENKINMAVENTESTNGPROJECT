package com.webservice;



import java.util.List;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;




public class Weather {
	@Test(enabled=true)
	public void testA()
	{
		Response res =RestAssured. given()
				.queryParam("zip", "10461,us")
				.queryParam("appid","4e3bbf32569b944ce895e2ca4984f56a")
				.when()
				.get("http://samples.openweathermap.org/data/2.5/weather");
		//http://samples.openweathermap.org/data/2.5/weather?zip=94040,us&appid=b1b15e88fa797225412429c1c50c122a1
		String sbody = res.body().asString();
		System.out.println(sbody);
		
	String n=	res.then().extract().jsonPath().get("name");
				
		System.out.println(res.contentType());
		System.out.println(res.statusCode());
		System.out.println(n);
	
		
/*		String title = JsonPath.from(res.getBody().asString()).getString("title");
		System.out.println(title);
		
		String explanation=JsonPath.from(res.getBody().asString()).get("explanation");
		System.out.println(explanation);*/
	}
	
	@Test(enabled=false)
	public void testB()
	{
	
				
		Response res =RestAssured.given()
				.queryParam("api_key","DEMO_KEY").queryParam("begin", "2014-02-01").queryParam("lat", "1.5").queryParam("lon", "100.75")
				.get("https://api.nasa.gov/planetary/earth/assets");
		//System.out.println(res.contentType());
		System.out.println(res.statusCode());
		//System.out.println(res.asString());
		
		String s=res.asString();
		/*JsonPath jp=JsonPath.from(s);
		System.out.println(jp.prettyPrint());*/
	
		
		/*JsonPath apple = JsonPath.from(res.getBody().asString());
		System.out.println(apple.get("$..id"));*/
		
		JsonPath js = new JsonPath(s).setRoot("results");
		int tid = js.getInt("results");
		System.out.println(tid);
		List<Integer> alid = js.get("id");
		System.out.println(alid.size());
				
		/*
		String s=res.jsonPath().getString("$.results..id");
		System.out.println(s);*/
		
		
		
		
	}

	private Object given() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
