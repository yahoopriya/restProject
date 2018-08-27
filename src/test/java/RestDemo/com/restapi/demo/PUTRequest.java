package RestDemo.com.restapi.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTRequest {
	
	public static Response putRequest(String sURL) {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.put("/1");
		response.statusCode();
		return response;
	}

}
