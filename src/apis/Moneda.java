package apis;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

import com.google.gson.Gson;

public class Moneda{
	
    private boolean success;
    private long timestamp;
    private boolean historical;
	private String base;
    private String date;
    private Gson rates = new Gson();
//    private Map<String, String> rates;
    //private String rates;
    
    public Moneda() {
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isHistorical() {
		return historical;
	}

	public void setHistorical(boolean historical) {
		this.historical = historical;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Gson getRates() {
		return rates;
	}

	public void setRates(Gson rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "Moneda [success=" + success + ", timestamp=" + timestamp + ", historical=" + historical + ", base="
				+ base + ", date=" + date + ", rates=" + rates + "]";
	}

	

	
}
