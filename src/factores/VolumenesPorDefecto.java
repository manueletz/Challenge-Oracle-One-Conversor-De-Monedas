package factores;

import java.math.BigDecimal;
import java.util.HashMap;

public class VolumenesPorDefecto {
	public HashMap<String, String> volumenesParaApp; 

	private HashMap<String, BigDecimal> rates = new HashMap<String, BigDecimal>();
	
	public static void main(String[] args) {
		VolumenesPorDefecto volumenesPorDefecto = new VolumenesPorDefecto();
		System.out.println(volumenesPorDefecto.volumenesParaApp);
		System.out.println(volumenesPorDefecto.rates);
		
	}

	public VolumenesPorDefecto() {
				
		HashMap<String, String> volumenes = new HashMap<String, String>();
		
		volumenes.put("m3", "m3 - Metro cúbico");
		volumenes.put("dm3", "dm3 - Decímetro cúbico");
		volumenes.put("cm3", "cm3 - Centímetro cúbico");
		volumenes.put("mm3", "mm3 - Milímetro cúbico");

		
		volumenesParaApp = new HashMap<String, String>();
		
		volumenes.forEach((key,value)->{
			volumenes.forEach((keyDos,valueDos)->{
				if (!(key==keyDos)){
					volumenesParaApp.put(key+"->"+keyDos, "");					
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
}
