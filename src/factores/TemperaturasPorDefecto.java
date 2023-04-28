package factores;

import java.math.BigDecimal;
import java.util.HashMap;

public class TemperaturasPorDefecto {
	
	private HashMap<String, BigDecimal> rates = new HashMap<String, BigDecimal>();

	public TemperaturasPorDefecto() {
		rates.put("C->F", new BigDecimal("33.8"));
	}
}
