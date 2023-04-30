package factores;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TemperaturasPorDefecto {
	
	private LinkedHashMap<String, String> temperaturas;
	
	private LinkedHashMap<String, BigDecimal> rates;
	
	public static void main(String[] args) {
		TemperaturasPorDefecto temperaturasPorDefecto = new TemperaturasPorDefecto();
		System.out.println(temperaturasPorDefecto.temperaturas);
		System.out.println(temperaturasPorDefecto.rates);
		
	}
	
	public TemperaturasPorDefecto() {
				
		temperaturas = new LinkedHashMap<String, String>();
		temperaturas.put("C", "C - Grados Celsius");
		temperaturas.put("F", "F - Grados Fahrenheit");
		temperaturas.put("K", "K - Kelvin");

		
		rates = new LinkedHashMap<String, BigDecimal>();
		temperaturas.forEach((key,value)->{
			temperaturas.forEach((keyDos,valueDos)->{
				if (!(key==keyDos)){
					rates.put(key+"->"+keyDos, new BigDecimal("0"));					
				}
			});
		});

		rates.put("C->F",new BigDecimal("1"));
		rates.put("C->K",new BigDecimal("1"));
		rates.put("F->C",new BigDecimal("1"));
		rates.put("F->K",new BigDecimal("1"));
		rates.put("K->C",new BigDecimal("1"));
		rates.put("K->F",new BigDecimal("1"));
	}

	public LinkedHashMap<String, String> getTemperaturas() {
		return temperaturas;
	}

	public void setTemperaturas(LinkedHashMap<String, String> temperaturas) {
		this.temperaturas = temperaturas;
	}

	public LinkedHashMap<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(LinkedHashMap<String, BigDecimal> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "TemperaturasPorDefecto [rates=" + rates + "]";
	}

}
