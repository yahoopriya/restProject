package RestDemo.com.restapi.demo;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTRequest {
	
	public static Response putRequest(String sURL) {
		
		RestAssured.baseURI = sURL;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 89);
		jsonObject.put("body", 85);
		jsonObject.put("postId", "sun");
		httpRequest.body(jsonObject.toJSONString());
		Response response = httpRequest.put("/89"); // here it always gives the same response as it just updates the resources
		System.out.println("+++++++++++++");
		System.out.println(response.statusCode());
		if(response.statusCode()==200) {
			System.out.println("Sucessfully updated the resources");
		}else if(response.statusCode()==404) {
			System.out.println("page not found");
		}
		return response;
	}

	public static void main(String[] args) {
		putRequest("http://localhost:3000/comments");
	
}
}