package apis;

import java.math.BigDecimal;
import java.util.HashMap;

public class TasasPorDefecto {

	private HashMap<String, BigDecimal> rates = new HashMap<String, BigDecimal>();

	public TasasPorDefecto(){
		//rates.put("SVC->GBP", new BigDecimal("0.091862"));
		rates.put("SVC->GBP", new BigDecimal("0.09143"));
		rates.put("KRW->USD", new BigDecimal("0.000747"));
		rates.put("USD->SVC", new BigDecimal("8.749442"));
		rates.put("KRW->EUR", new BigDecimal("0.000679"));
		rates.put("EUR->GBP", new BigDecimal("0.879846"));
		rates.put("SVC->JPY", new BigDecimal("15.558363"));
		rates.put("EUR->JPY", new BigDecimal("149.72105"));
		rates.put("GBP->USD", new BigDecimal("1.250063"));
		rates.put("JPY->KRW", new BigDecimal("9.835636"));
		rates.put("SVC->USD", new BigDecimal("0.114293"));
		rates.put("JPY->GBP", new BigDecimal("0.005877"));
		rates.put("GBP->SVC", new BigDecimal("10.93735"));
		rates.put("USD->KRW", new BigDecimal("1338.895659"));
		rates.put("SVC->EUR", new BigDecimal("0.103916"));
		rates.put("EUR->USD", new BigDecimal("1.099863"));
		rates.put("USD->GBP", new BigDecimal("0.79996"));
		rates.put("USD->JPY", new BigDecimal("136.126997"));
		rates.put("KRW->SVC", new BigDecimal("0.006535"));
		rates.put("JPY->EUR", new BigDecimal("0.006679"));
		rates.put("USD->EUR", new BigDecimal("0.909204"));
		rates.put("JPY->USD", new BigDecimal("0.007346"));
		rates.put("GBP->KRW", new BigDecimal("1673.703276"));
		rates.put("GBP->JPY", new BigDecimal("170.167256"));
		rates.put("EUR->SVC", new BigDecimal("9.623188"));
		rates.put("KRW->GBP", new BigDecimal("0.000597"));
		rates.put("GBP->EUR", new BigDecimal("1.136562"));
		rates.put("KRW->JPY", new BigDecimal("0.101671"));
		rates.put("SVC->KRW", new BigDecimal("153.026398"));
		rates.put("EUR->KRW", new BigDecimal("1472.60182"));
		rates.put("JPY->SVC", new BigDecimal("0.064274"));
		
		//System.out.println(rates);
		//System.out.println(rates.get("SVC->USD"));

	}
	
	public void setRates(HashMap<String, BigDecimal> rates) {
		this.rates = rates;
	}

	public HashMap<String, BigDecimal> getRates() {
		return rates;
	}

	@Override
	public String toString() {
		return "TasasPorDefecto [rates=" + rates + "]";
	}
	
}
