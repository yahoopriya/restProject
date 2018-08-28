package RestDemo.com.restapi.demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETRequest {

	
	public static Response getRequest(String sURL) {
		
		RestAssured.baseURI = "http://localhost:3000/comments";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		System.out.println(response.statusCode());
		System.out.println(response.getBody().asString());
		
		JsonPath jsonobj = response.getBody().jsonPath();
		System.out.println(jsonobj.get("id") + " , " + jsonobj.get("body")+" ," +jsonobj.get("postId"));
		
		return response;
	}

	public static void main(String[] args) {
		getRequest("http://localhost:3000/comments");
	}
	
}
