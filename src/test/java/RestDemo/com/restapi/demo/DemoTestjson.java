package RestDemo.com.restapi.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
/*
 * This exmaple parse the json response by using json simple
 */
public class DemoTestjson {

	public static void main(String[] args) {

		URL url = null;
		try {
			url = new java.net.URL("http://services.groupkt.com/country/get/all");
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		java.net.HttpURLConnection conn;
		try {
			conn = (java.net.HttpURLConnection) url.openConnection();
			/*
			 * String username = "test"; String password = "test";
			 * 
			 * sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder(); String
			 * userpassword = username + ":" + password; String encodedAuthorization =
			 * enc.encode( userpassword.getBytes() );
			 * conn.setRequestProperty("Authorization", "Basic "+encodedAuthorization);
			 * conn.setAllowUserInteraction(true);
			 */

			java.io.BufferedReader br = new BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(br);
			JSONObject obj1 = (JSONObject) obj.get("RestResponse");
			System.out.println(obj1.toString());
			JSONArray array = (JSONArray) obj1.get("result");

			Iterator<JSONObject> objaray = array.iterator();
			while (objaray.hasNext()) {
				JSONObject obj3 = objaray.next();
				String Name = (String) obj3.get("name");
				System.out.println("name :" + Name);
				String alpha2_code = (String) obj3.get("alpha2_code");
				System.out.println("alpha2_code :" + alpha2_code);
				String alpha3_code = (String) obj3.get("alpha3_code");
		    	System.out.println(" alpha3_code :" + alpha3_code);
			}

		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
	}
}
