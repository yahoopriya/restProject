package RestDemo.com.restapi.demo;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTRequest {

	@SuppressWarnings("unchecked")
	public static Response postRequest(String sTestStepData) {
		RestAssured.baseURI = "http://localhost:3000/comments";
		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.headers("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("id", 89);
		jsonObject.put("body", 87);
		jsonObject.put("postId", "sun");
		httpRequest.body(jsonObject.toJSONString());
		Response response = httpRequest.post();

		if (response.statusCode() == 201) {
			System.out.println("Resorce created sucessfully");
			System.out.println(" here is the created response body" + response.getBody().asString());

		} else if (response.statusCode() == 500) {
			System.out.println("duplcate entry found");
		}
		return response;
	}

	public static void main(String[] args) {
		postRequest(null);
	}
}
