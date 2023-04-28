package apis;

import java.io.*;
import okhttp3.*;

public class ConsultarApi{
  
	public ConsultarApi(){
		
	}
	public String convertirMoneda(String to, String from, String amount) throws IOException {
	    //to = "USD";
	    //from = "EUR";
	    //amount = "100";
	    OkHttpClient client = new OkHttpClient().newBuilder().build();
	    client.newBuilder().build();
	    Request request = new Request.Builder()
	      .url("https://api.apilayer.com/fixer/convert?to="+ to+"&from="+from+"&amount="+amount)
	      .addHeader("apikey", "T5lxIUvLY5jAjIlw9ZbFD68UFLtpzuDi")
	      .method("GET", null)
	      .build();
	    Response response = client.newCall(request).execute();
	    return response.body().string();
	} 
	

	public String consultarTasasDeCambioPorFecha(String start_date, String end_date) throws IOException {
		//start_date = "2023-04-23";
	    //end_date = "2023-04-23";
	    OkHttpClient client = new OkHttpClient().newBuilder().build();
	    client.newBuilder().build();
	    Request request = new Request.Builder()
	      .url("https://api.apilayer.com/currency_data/change?start_date={start_date}&end_date={end_date}")
	      .addHeader("apikey", "T5lxIUvLY5jAjIlw9ZbFD68UFLtpzuDi")
	      .method("GET", null)
	      .build();
	    Response response = client.newCall(request).execute();
	    return response.body().string();
	} 
		
	public String FactoresDeMonedas(String fecha, String base, String simbolos) throws IOException {
		//fecha = "2023-04-23";
	    //base = "SVC";
	    //simbolos = "USD,EUR,JPY,GBP,KRW";
	    OkHttpClient client = new OkHttpClient().newBuilder().build();
	    client.newBuilder().build();
	    Request request = new Request.Builder()
	      .url("https://api.apilayer.com/fixer/"+fecha+"?base="+base+"&symbols="+simbolos)
	      .addHeader("apikey", "T5lxIUvLY5jAjIlw9ZbFD68UFLtpzuDi")
	      .method("GET", null)
	      .build();
	    Response response = client.newCall(request).execute();
	    //response.close();
	    //response.body().close();
	    return response.body().string();
	} 
    
}