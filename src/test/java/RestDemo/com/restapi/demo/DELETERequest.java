package RestDemo.com.restapi.demo;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETERequest {

	public static Response deleteRequest(String sURL) {
		
		RestAssured.baseURI = "http://localhost:3000/comments";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.delete("/89"); // here i  am deleting resources
		System.out.println(response.statusCode());
		if(response.statusCode()==200)
		{
			System.out.println(" resource deleted sucessfully");
		}
		else if(response.statusCode()==404) {
			
			System.out.println(" resource not found on the server");
		}
		return response;
		
	}

	public static void main(String[] args) {
		
		deleteRequest(null);
	}
	
}
