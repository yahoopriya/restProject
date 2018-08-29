package RestDemo.com.restapi.demo;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETERequest {

	public static Response deleteRequest(String sURL) {

		RestAssured.baseURI = sURL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.delete("/89"); // here i am deleting resources
		if (response.statusCode() == 200) {
			System.out.println(" resource deleted sucessfully :" + response.statusCode());
		} else if (response.statusCode() == 404) {

			System.out.println(" resource not found on the server :" + response.statusCode());
		}
		return response;

	}

	public static void main(String[] args) {

		deleteRequest("http://localhost:3000/comments");
	}

}
