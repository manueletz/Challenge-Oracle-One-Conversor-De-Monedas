package factores;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LongitudesPorDefecto {
	private LinkedHashMap<String, String> longitudes;
	
	private LinkedHashMap<String, BigDecimal> rates;
	
	public static void main(String[] args) {
		LongitudesPorDefecto longitudesPorDefecto = new LongitudesPorDefecto();
		System.out.println(longitudesPorDefecto.longitudes);
		System.out.println(longitudesPorDefecto.rates);
		
	}
	

	public LongitudesPorDefecto() {
				
		longitudes = new LinkedHashMap<String, String>();
		longitudes.put("m", "m - Metro");
		longitudes.put("dm", "dm - Decímetro");
		longitudes.put("cm", "cm - Centímetro");
		longitudes.put("mm", "mm - Milímetro");

		
		rates = new LinkedHashMap<String, BigDecimal>();
		longitudes.forEach((key,value)->{
			longitudes.forEach((keyDos,valueDos)->{
				if (!(key==keyDos)){
					rates.put(key+"->"+keyDos, new BigDecimal("0"));					
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

	public LinkedHashMap<String, String> getLongitudes() {
		return longitudes;
	}


	public void setLongitudes(LinkedHashMap<String, String> longitudes) {
		this.longitudes = longitudes;
	}


	public LinkedHashMap<String, BigDecimal> getRates() {
		return rates;
	}


	public void setRates(LinkedHashMap<String, BigDecimal> rates) {
		this.rates = rates;
	}
	
	@Override
	public String toString() {
		return "LongitudesPorDefecto [rates=" + rates + "]";
	}
}
