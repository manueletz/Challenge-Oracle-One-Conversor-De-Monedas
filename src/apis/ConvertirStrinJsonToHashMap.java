package apis;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ConvertirStrinJsonToHashMap {
	

	
	public static void main(String[] args) {
		String texto ='{' +
			    " \"success\": true,\n";
		
		String texto1 = "{\n"+
		    "\"success\": true,\n"+
		    "\"query\": {\n"+
		        "\"from\": \"EUR\",\n"+
		        "\"to\": \"USD\",\n"+
		        "\"amount\": 100\n"+
		    "},\n" +
		    "\"info\": {\n"+
		        "\"timestamp\": 1682182323,\n"+ 
		        "\"rate\": 1.10975\n"+
		    "},"+
		    "\"date\": \"2023-04-22\",\n"+
		    "\"result\": 110.975\n"+
		"}";
				
		//System.out.println(texto1);
		
		StringBuilder sb = new StringBuilder();
		sb.append("{").append(System.lineSeparator());
		sb.append(" \"success\": true,").append(System.lineSeparator());
		//System.out.println(sb.toString());
		
		String texto3 = """
		{
		    "success": true,
		    "query": {
		        "from": "EUR",
		        "to": "USD",
		        "amount": 100
		    },
		    "info": {
		        "timestamp": 1682182323,
		        "rate": 1.10975
		    },
		    "date": "2023-04-22",
		    "result": 110.975
		}
		""";
		System.out.println(texto3);
		
		//ObjectMapper mapper = new ObjectMapper();
		
		// Map<String, String> map = mapper.readValue(json, Map.class);
		//{"USD":0.114349,"EUR":0.104039,"JPY":15.332597,"GBP":0.091893,"KRW":152.125911}
		HashMap<String, BigDecimal> rates = new HashMap<String, BigDecimal>();
		rates.put("USD", new BigDecimal("0.114349"));
		rates.put("EUR", new BigDecimal("0.104039"));
		rates.put("JPY", new BigDecimal("15.332597"));
		rates.put("GBP", new BigDecimal("0.091893"));
		rates.put("KRW", new BigDecimal("152.125911"));

		
		System.out.println(rates);
		
		rates.forEach((key,value)->{
			System.out.println(key+" = "+value);
		});
	}		
	
}
