package RestDemo.com.restapi.demo;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTRequest {

	
	@SuppressWarnings("unchecked")
	public static Response postRequest(String sTestStepData) {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.headers("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
	
	    	jsonObject.put("userId", 890);
		     jsonObject.put("id", 890);
		     jsonObject.put("title", "sun");
		     jsonObject.put("body", "jjjjjj");
		     httpRequest.body(jsonObject.toJSONString());
		     Response response = httpRequest.post();
	    	System.out.println(response.statusCode());
	    	return response;
	}
		
	public static void main(String[] args) {
		postRequest(null);
	}
	}

