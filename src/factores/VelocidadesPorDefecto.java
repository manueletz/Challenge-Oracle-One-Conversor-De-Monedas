package factores;

import java.math.BigDecimal;
import java.util.HashMap;

public class VelocidadesPorDefecto {
	public HashMap<String, String> velocidadesParaApp; 

	private HashMap<String, BigDecimal> rates = new HashMap<String, BigDecimal>();
	
	public static void main(String[] args) {
		VelocidadesPorDefecto velocidadesPorDefecto = new VelocidadesPorDefecto();
		System.out.println(velocidadesPorDefecto.velocidadesParaApp);
		System.out.println(velocidadesPorDefecto.rates);
		
	}

	public VelocidadesPorDefecto() {
				
		HashMap<String, String> velocidades = new HashMap<String, String>();
		
		velocidades.put("m/s", "m/s - Metros por segundo");
		velocidades.put("km/h", "km/h - Kilómetros por hora");
		velocidades.put("mph", "mph - Millas por hora");

		
		velocidadesParaApp = new HashMap<String, String>();
		
		velocidades.forEach((key,value)->{
			velocidades.forEach((keyDos,valueDos)->{
				if (!(key==keyDos)){
					velocidadesParaApp.put(key+"->"+keyDos, "");					
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
}
