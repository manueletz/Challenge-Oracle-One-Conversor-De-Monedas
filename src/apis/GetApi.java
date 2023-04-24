package apis;

import java.io.*;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.*;

public class GetApi{
  public static void main(String []args) throws IOException{
    OkHttpClient client = new OkHttpClient().newBuilder().build();
    client.newBuilder().build();
    
    String to = "USD";
    String from = "EUR";
    String amount = "100";
    /*
    Request request = new Request.Builder()
      //.url("https://api.apilayer.com/currency_data/change?start_date={start_date}&end_date={end_date}")
      .url("https://api.apilayer.com/fixer/convert?to="+ to+"&from="+from+"&amount="+amount)
      .addHeader("apikey", "T5lxIUvLY5jAjIlw9ZbFD68UFLtpzuDi")
      .method("GET", null)
      .build();
    Response response = client.newCall(request).execute();
    */
    
    
    
//    String destinos = "USD";
//    String origen = "EUR";
    String base = "SVC";
    String simbolos = "USD,EUR,JPY,GBP,KRW";
    Request request = new Request.Builder() // 2023-03-10
      //.url("https://api.apilayer.com/fixer/"+fecha+"?symbols="+destinos+"&base="+origen)
       //String resp=  api.factorConversion(fechaActual+"", codigopais, "USD,EUR,JPY,GBP,KRW");
      //.url("https://api.apilayer.com/fixer/"+"2023-04-23"+"?symbols="+destinos+"&base="+origen)
      .url("https://api.apilayer.com/fixer/"+"2023-04-23"+"?base="+base+"&symbols="+simbolos)
      .addHeader("apikey", "uSBX1EqIFt5bSPxpSkb0XgqBByaFGS4C")
      .method("GET", null)
      .build();
      Response response = client.newCall(request).execute();
      // System.out.println(response.body().string());
      //return response.body().string();
    
   
    //System.out.println(response.body().string());

    //String resp=  api.factorConversion(fechaActual+"", codigopais, "USD,EUR,JPY,GBP,KRW");
    String resp = response.body().string();
    
    response.close();
    response.body().close();
    
    System.out.println(resp);
    ApiResponse data = Converter.fromJsonString(resp);
    
    System.out.println(data.getRates());

   
    System.out.println(resp);
    Gson gson = new Gson();
    Moneda moneda = gson.fromJson(resp, Moneda.class);
   
    System.out.println(moneda.getRates());
    /*****************/
    
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
    
    
  }
}