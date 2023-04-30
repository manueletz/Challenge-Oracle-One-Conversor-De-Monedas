package factores;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MasasPorDefecto {
	private LinkedHashMap<String, String> masas; 

	private LinkedHashMap<String, BigDecimal> rates;
	
	public static void main(String[] args) {
		MasasPorDefecto masasPorDefecto = new MasasPorDefecto();
		System.out.println(masasPorDefecto.masas);
		System.out.println(masasPorDefecto.rates);
		
	}

	public MasasPorDefecto() {
				
		masas = new LinkedHashMap<String, String>();
		masas.put("t", "t - Tonelada");
		masas.put("kg", "kg - kilogramo");
		masas.put("g", "g - Gramo");
		masas.put("q", "q - Quintal");
		masas.put("lb", "lb - libra");
		masas.put("oz", "oz - Onza");
		
		rates = new LinkedHashMap<String, BigDecimal>();
		masas.forEach((key,value)->{
			masas.forEach((keyDos,valueDos)->{
				if (!(key==keyDos)){
					rates.put(key+"->"+keyDos, new BigDecimal("0"));					
				}
			});
		});
		
		rates.put("g->kg",new BigDecimal("0.001"));
		rates.put("g->lb",new BigDecimal("0.00220462262"));
		rates.put("g->oz",new BigDecimal("0.0352739619"));
		rates.put("g->q",new BigDecimal("0.0001"));
		rates.put("g->t",new BigDecimal("0.00005"));
		rates.put("kg->g",new BigDecimal("1000"));
		rates.put("kg->lb",new BigDecimal("2.20462262"));
		rates.put("kg->oz",new BigDecimal("35.2739619"));
		rates.put("kg->q",new BigDecimal("0.01"));
		rates.put("kg->t",new BigDecimal("0.001"));
		rates.put("lb->g=",new BigDecimal("453.59237"));
		rates.put("lb->kg",new BigDecimal("0.45359237"));
		rates.put("lb->oz",new BigDecimal("16"));
		rates.put("lb->q",new BigDecimal("0.0045359237"));
		rates.put("lb->t",new BigDecimal("0.00045359237"));
		rates.put("oz->g",new BigDecimal("28.3495231"));
		rates.put("oz->kg",new BigDecimal("0.0283495231"));
		rates.put("oz->lb",new BigDecimal("0.0625"));
		rates.put("oz->q",new BigDecimal("0.000283495231"));
		rates.put("oz->t",new BigDecimal("0.0000283495"));
		rates.put("q->g",new BigDecimal("100000"));
		rates.put("q->kg",new BigDecimal("100"));
		rates.put("q->lb",new BigDecimal("220.462262"));
		rates.put("q->oz",new BigDecimal("3527.39619"));
		rates.put("q->t",new BigDecimal("0.1"));
		rates.put("t->g",new BigDecimal("1000000"));
		rates.put("t->kg",new BigDecimal("1000"));
		rates.put("t->lb",new BigDecimal("2204.62262"));
		rates.put("t->oz",new BigDecimal("35273.9619"));
		rates.put("t->q",new BigDecimal("10"));
	}

	@Override
	public String toString() {
		return "MasasPorDefecto [rates=" + rates + "]";
	}

	public LinkedHashMap<String, String> getMasas() {
		return masas;
	}

	public void setMasas(LinkedHashMap<String, String> masas) {
		this.masas = masas;
	}

	public LinkedHashMap<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(LinkedHashMap<String, BigDecimal> rates) {
		this.rates = rates;
	}
}
