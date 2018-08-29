package RestDemo.com.restapi.demo;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class POJOClinet {

	public static LinkedHashMap<String, String> dataContext = null;
	
	public static MyPojo dataCotext2 = null;
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		File jsonfile = new File("D:\\MyNewwork-Space\\com.restapi.demo\\data\\mydata.json");
		ObjectMapper mapper = new ObjectMapper();
		
		// here i am mapping json file to linkedhashmap
		dataContext = mapper.readValue(jsonfile, LinkedHashMap.class);
		
		// here i am mapping json file to POjo class directly
		dataCotext2 = mapper.readValue(jsonfile, MyPojo.class);
		
		System.out.println(dataCotext2.getId()+ " , "+dataCotext2.getName() +" , "+dataCotext2.getPermanent()+" ," +dataCotext2.getAddress());
		
	}
}

