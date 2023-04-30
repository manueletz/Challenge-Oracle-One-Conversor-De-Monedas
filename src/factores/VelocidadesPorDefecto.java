package factores;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class VelocidadesPorDefecto {
	private LinkedHashMap<String, String>  velocidades; 

	private LinkedHashMap<String, BigDecimal> rates;
	
	public static void main(String[] args) {
		VelocidadesPorDefecto velocidadesPorDefecto = new VelocidadesPorDefecto();
		System.out.println(velocidadesPorDefecto.velocidades);
		System.out.println(velocidadesPorDefecto.rates);
		
	}

	public VelocidadesPorDefecto() {
				
		velocidades = new LinkedHashMap<String, String>();
		velocidades.put("m/s", "m/s - Metros por segundo");
		velocidades.put("km/h", "km/h - Kilómetros por hora");
		velocidades.put("mph", "mph - Millas por hora");

		
		rates = new LinkedHashMap<String, BigDecimal>();
		velocidades.forEach((key,value)->{
			velocidades.forEach((keyDos,valueDos)->{
				if (!(key==keyDos)){
					rates.put(key+"->"+keyDos, new BigDecimal("0"));					
				}
			});
		});
		
		rates.put("km/h->m/s",new BigDecimal("0.277777778"));
		rates.put("km/h->mph",new BigDecimal("0.6213711192"));
		rates.put("m/s->km/h",new BigDecimal("3.6"));
		rates.put("m/s->mph",new BigDecimal("2.23693629"));
		rates.put("mph->km/h",new BigDecimal("1.609344"));
		rates.put("mph->m/s",new BigDecimal("0.44704"));
	}

	@Override
	public String toString() {
		return "VelocidadesPorDefecto [rates=" + rates + "]";
	}

	public LinkedHashMap<String, String> getVelocidades() {
		return velocidades;
	}

	public void setVelocidades(LinkedHashMap<String, String> velocidades) {
		this.velocidades = velocidades;
	}

	public LinkedHashMap<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(LinkedHashMap<String, BigDecimal> rates) {
		this.rates = rates;
	}
}
