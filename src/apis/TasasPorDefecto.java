package apis;

import java.math.BigDecimal;
import java.util.HashMap;

public class TasasPorDefecto {

	private HashMap<String, BigDecimal> rates = new HashMap<String, BigDecimal>();
	
	public TasasPorDefecto(){
		rates.put("SVC->GBP", new BigDecimal("0.091862"));
		rates.put("KRW->USD", new BigDecimal("0.000752"));
		rates.put("USD->SVC", new BigDecimal("8.745192"));
		rates.put("KRW->EUR", new BigDecimal("0.000684"));
		rates.put("EUR->GBP", new BigDecimal("0.883035"));
		rates.put("SVC->JPY", new BigDecimal("15.318821"));
		rates.put("EUR->JPY", new BigDecimal("147.254298"));
		rates.put("GBP->USD", new BigDecimal("1.244787"));
		rates.put("JPY->KRW", new BigDecimal("9.930729"));
		rates.put("SVC->USD", new BigDecimal("0.114349"));
		rates.put("JPY->GBP", new BigDecimal("0.005997"));
		rates.put("GBP->SVC", new BigDecimal("10.885904"));
		rates.put("USD->KRW", new BigDecimal("1330.380309"));
		rates.put("SVC->EUR", new BigDecimal("0.10403"));
		rates.put("EUR->USD", new BigDecimal("1.099191"));
		rates.put("USD->GBP", new BigDecimal("0.80335"));
		rates.put("USD->JPY", new BigDecimal("133.96602"));
		rates.put("KRW->SVC", new BigDecimal("0.006573"));
		rates.put("JPY->EUR", new BigDecimal("0.006791"));
		rates.put("USD->EUR", new BigDecimal("0.90976"));
		rates.put("JPY->USD", new BigDecimal("0.007465"));
		rates.put("GBP->KRW", new BigDecimal("1656.040657"));
		rates.put("GBP->JPY", new BigDecimal("166.759224"));
		rates.put("EUR->SVC", new BigDecimal("9.612639"));
		rates.put("KRW->GBP", new BigDecimal("0.000604"));
		rates.put("GBP->EUR", new BigDecimal("1.132457"));
		rates.put("KRW->JPY", new BigDecimal("0.100698"));
		rates.put("SVC->KRW", new BigDecimal("152.127061"));
		rates.put("EUR->KRW", new BigDecimal("1462.342518"));
		rates.put("JPY->SVC", new BigDecimal("0.065279"));
		
		//System.out.println(rates);
		//System.out.println(rates.get("SVC->USD"));

	}

	public HashMap<String, BigDecimal> getRates() {
		return rates;
	}

	@Override
	public String toString() {
		return "TasasPorDefecto [rates=" + rates + "]";
	}
	
}
