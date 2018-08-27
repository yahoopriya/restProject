package RestDemo.com.restapi.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETRequest {

	
	public static Response getRequest(String sURL) {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		System.out.println(response.statusCode());
		return response;
	}

	public static void main(String[] args) {
		getRequest("https://jsonplaceholder.typicode.com/posts");
	}
	
}
