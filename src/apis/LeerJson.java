package apis;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LeerJson {
	
	public String[] extraerJson(String resp) {
	    JsonParser parser = new JsonParser();
	    
	    JsonElement jsonTree = parser.parse(resp);
	    
	    if (jsonTree.isJsonObject()) {
	    	JsonObject jsonObject = jsonTree.getAsJsonObject();
	    	
	    	JsonElement success = jsonObject.get("success");
	    	JsonElement timestamp = jsonObject.get("timestamp");
	    	JsonElement historical = jsonObject.get("historical");
	    	JsonElement baseMoneda = jsonObject.get("base");
	    	JsonElement date = jsonObject.get("date");
	    	JsonElement rate = jsonObject.get("rates");
	    	System.out.println(success);
	    	System.out.println(rate);
	    	
	    	
	    	if (rate.isJsonObject()) {
	    		JsonObject usdObj = rate.getAsJsonObject();
	    		JsonElement usd = usdObj.get("USD");
	    		System.out.println(usd);
	    	}
	    }
	    String [] texto = null;
	    return texto; 
	}

}
