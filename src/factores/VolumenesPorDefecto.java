package factores;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class VolumenesPorDefecto {
	private LinkedHashMap<String, String> volumenes; 

	private LinkedHashMap<String, BigDecimal> rates;
	
	public static void main(String[] args) {
		VolumenesPorDefecto volumenesPorDefecto = new VolumenesPorDefecto();
		System.out.println(volumenesPorDefecto.volumenes);
		System.out.println(volumenesPorDefecto.rates);
		
	}

	public VolumenesPorDefecto() {
				
		volumenes = new LinkedHashMap<String, String>();
		volumenes.put("m3", "m3 - Metro cúbico");
		volumenes.put("dm3", "dm3 - Decímetro cúbico");
		volumenes.put("cm3", "cm3 - Centímetro cúbico");
		volumenes.put("mm3", "mm3 - Milímetro cúbico");

		
		rates = new LinkedHashMap<String, BigDecimal>();
		volumenes.forEach((key,value)->{
			volumenes.forEach((keyDos,valueDos)->{
				if (!(key==keyDos)){
					rates.put(key+"->"+keyDos, new BigDecimal("0"));					
				}
			});
		});
		
		rates.put("cm3->dm3",new BigDecimal("0.001"));
		rates.put("cm3->m3",new BigDecimal("0.000001"));
		rates.put("cm3->mm3",new BigDecimal("1000"));
		rates.put("dm3->cm3",new BigDecimal("1000"));
		rates.put("dm3->m3",new BigDecimal("0.001"));
		rates.put("dm3->mm3",new BigDecimal("1000000"));
		rates.put("m3->cm3",new BigDecimal("1000000"));
		rates.put("m3->dm3",new BigDecimal("1000"));
		rates.put("m3->mm3",new BigDecimal("0.000000001"));
		rates.put("mm3->cm3",new BigDecimal("0.001"));
		rates.put("mm3->dm3",new BigDecimal("0.000001"));
		rates.put("mm3->m3",new BigDecimal("0.000000001"));
	}

	public LinkedHashMap<String, String> getVolumenes() {
		return volumenes;
	}

	public void setVolumenes(LinkedHashMap<String, String> volumenes) {
		this.volumenes = volumenes;
	}

	public LinkedHashMap<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(LinkedHashMap<String, BigDecimal> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "VolumenesPorDefecto [rates=" + rates + "]";
	}
	
	
}
