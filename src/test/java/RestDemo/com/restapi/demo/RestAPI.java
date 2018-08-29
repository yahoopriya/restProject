package RestDemo.com.restapi.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.parser.JSONParser;
import org.xml.sax.SAXException;

import 	io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;

public class RestAPI {

	
		io.restassured.response.Response response;	
		String base_url = "";
		String expectedResponseHeaderType = "";
		Map<String, String> urlParameters = new HashMap<String, String>();
		String responseString;
		
		public RestAPI(){
			super();
		}
		
		public void RequestURL(String sURL, String sOperation, String sTestStepData, Map<String, String> urlParameters){
			boolean bNoTestStepData = false;
			if(sTestStepData==null||sTestStepData==""){
				bNoTestStepData =true;
			}
			boolean isGetOperation = sOperation.equalsIgnoreCase("get");
			boolean isPostOperation = sOperation.equalsIgnoreCase("post");
			boolean isDeleteOperation = sOperation.equalsIgnoreCase("delete");
			boolean isPutOperation = sOperation.equalsIgnoreCase("put");
			
			if(bNoTestStepData){
				if(isGetOperation){
					response = GETRequest.getRequest(sURL);
				}
				else if(isPostOperation){
					response = POSTRequest.postRequest(sURL);
				}
				else if(isDeleteOperation){
					response = DELETERequest.deleteRequest(sURL);
				}
				else if(isPutOperation){
					response = PUTRequest.putRequest(sURL);
				}
				else {
					response = POSTRequest.postRequest(sURL);
				}
			}
			
			}
		
		
		public boolean validateResponseCode(String sresponseCode) throws
			NumberFormatException, IOException {
			
			Integer iActualResponseCode = response.getStatusCode();
			if(Integer.parseInt(sresponseCode)==(iActualResponseCode)){
				return true;			
			}
			return false;		
		}
		
		
		public boolean validateHeaderType(String expectedResponseHeaderType) throws IOException {
			String actualResponseHeaderType = response.getHeader("Content-Type");
			
			if(actualResponseHeaderType.equalsIgnoreCase(expectedResponseHeaderType)){
				return true;
			}
			return false;

		}
		
		public boolean IsValidateData(String sExpTestData){
			
			if(sExpTestData==null||sExpTestData==""){
				return false;
			}		
				return true;		
		}

		public String[] validateData(String sTag) throws SAXException, IOException, ParserConfigurationException{
			boolean isXMLResponseType = expectedResponseHeaderType.contains("xml");
			
			String tagToCheck = null;
			String attributeToCheck = null;
			
			String[] splitColumnStr = sTag.split("&");
			attributeToCheck = splitColumnStr[1];
			String[] splitStr = splitColumnStr[0].split("=");
			tagToCheck = splitStr[1];
			
			return new String[]  {tagToCheck, attributeToCheck};		
		}
		
	public boolean validateJsonAttribute(String sTag) throws SAXException, IOException, ParserConfigurationException {
			
			String[] arr1 = validateData(sTag);
			
			String sTagName = arr1[0];
			String sAttributeValue = arr1[1];
			
			responseString = response.asString();
			/*JSONParser parserFactory = JSONParser.getInstance();
			com.codesnippets4all.json.parsers.JSONParser parser = parserFactory.newJsonParser();
			Map jsonData = parser.parseJson(responseString);
			System.out.println(jsonData);
			Set arr=jsonData.keySet();		
			 String value=(String)jsonData.get(sTagName); 
			
			 if(value.equalsIgnoreCase(sAttributeValue)){
				 return true;
			 }*/
			return false;
		}
		
	}

