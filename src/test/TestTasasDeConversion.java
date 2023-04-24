package test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import apis.ConsultarApi;

public class TestTasasDeConversion {
	
	static ConsultarApi api = new ConsultarApi();
	private static String base = "";
	private static String simbolos = "";
	
	public static void main(String[] args) throws IOException {
		
		/*
		String fechaConsulta = "2023-04-23";
		String baseConsulta = "SVC";
		String simbolosConsulta = "USD,EUR,JPY,GBP,KRW";
		
		String resp = api.FactoresDeMonedas(fechaConsulta, baseConsulta, simbolosConsulta); 
		System.out.println(resp);
		*/
		
		HashMap<String, String> divisas = new HashMap<String, String>();
		
		divisas.put("SVC", "SVC - Colón Salvadoreño");
		divisas.put("USD", "USD - Dólar Estadounidense");
		divisas.put("EUR", "EUR - Euros");
		divisas.put("GBP", "GBP - Libras Esterlinas");
		divisas.put("JPY", "JPY - Yen Japonés");
		divisas.put("KRW", "KRW - Won Surcoreano");
		
		HashMap<String, String> divisasParaApi = new HashMap<String, String>();
		

		/*
		for (Map.Entry<String, String> entryPrimera : divisas.entrySet()) {
	        base = entryPrimera.getKey();
	        simbolos = "";
			for (Map.Entry<String, String> entrySegunda : divisas.entrySet()) {
				if (!(entryPrimera.getKey()==entrySegunda.getKey())){
					//System.out.println(entryPrimera.getKey()+"->"+entrySegunda.getKey());
					simbolos += entrySegunda.getKey()+",";
				}
			}
			simbolos = simbolos.substring(0, simbolos.length()-1);
			divisasParaApi.put(base, simbolos);
	    }
		System.out.println(divisasParaApi);
		*/
		
		
		divisas.forEach((key,value)->{
			base = key;
			simbolos = "";
			System.out.println(key+" = "+value);
			divisas.forEach((keyDos,valueDos)->{
				if (!(key==keyDos)){
					//System.out.println(entryPrimera.getKey()+"->"+entrySegunda.getKey());
					simbolos += keyDos+",";
				}
			});
			simbolos = simbolos.substring(0, simbolos.length()-1);
			divisasParaApi.put(base, simbolos);
		});
		
		System.out.println(divisasParaApi);
		
		HashMap<String, BigDecimal> rates = new HashMap<String, BigDecimal>();
		
		divisasParaApi.forEach((key,value)->{
			String fecha = "2023-04-23";
			String base = key;
			String simbolos = value;
			String [] divisasSplit = null;
			try {
				String resp = api.FactoresDeMonedas(fecha, base, simbolos);
				divisasSplit= simbolos.split(",");
				
			    JsonParser parser = new JsonParser();
			    JsonElement jsonTree = parser.parse(resp);
			    if (jsonTree.isJsonObject()) {
			    	JsonObject jsonObject = jsonTree.getAsJsonObject();
			    	JsonElement rate = jsonObject.get("rates");
			    	
			    	if (rate.isJsonObject()) {
			    		JsonObject divisasObj = rate.getAsJsonObject();
			    		
			    		for (Object divisa: divisasSplit) {
			    			System.out.println(divisa);
			    			//JsonElement tasa = usdObj.get("USD");
			    			JsonElement tasa = divisasObj.get(divisa.toString());
			    			rates.put(base+"->"+divisa, new BigDecimal(tasa.toString()));
			    		}
			    	}
			    }
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		});
		
		System.out.println(rates);
		
	}
	

	
}
