package factores;

import java.math.BigDecimal;
import java.util.HashMap;

public class LongitudesPorDefecto {
	public HashMap<String, String> longitudesParaApp; 

	private HashMap<String, BigDecimal> rates = new HashMap<String, BigDecimal>();
	
	public static void main(String[] args) {
		LongitudesPorDefecto longitudesPorDefecto = new LongitudesPorDefecto();
		System.out.println(longitudesPorDefecto.longitudesParaApp);
		System.out.println(longitudesPorDefecto.rates);
		
	}

	public LongitudesPorDefecto() {
				
		HashMap<String, String> longitudes = new HashMap<String, String>();
		
		longitudes.put("m", "m - Metro");
		longitudes.put("dm", "dm - Decímetro");
		longitudes.put("cm", "cm - Centímetro");
		longitudes.put("mm", "mm - Milímetro");

		
		longitudesParaApp = new HashMap<String, String>();
		
		longitudes.forEach((key,value)->{
			longitudes.forEach((keyDos,valueDos)->{
				if (!(key==keyDos)){
					longitudesParaApp.put(key+"->"+keyDos, "");					
				}
			});
		});
		
		rates.put("cm->dm",new BigDecimal("0.1"));
		rates.put("cm->m",new BigDecimal("0.01"));
		rates.put("cm->mm",new BigDecimal("10"));
		rates.put("dm->cm",new BigDecimal("10"));
		rates.put("dm->m",new BigDecimal("0.1"));
		rates.put("dm->mm",new BigDecimal("100"));
		rates.put("m->cm",new BigDecimal("100"));
		rates.put("m->dm",new BigDecimal("10"));
		rates.put("m->mm",new BigDecimal("1000"));
		rates.put("mm->cm",new BigDecimal("0.1"));
		rates.put("mm->dm",new BigDecimal("0.01"));
		rates.put("mm->m",new BigDecimal("0.001"));


	}
}
