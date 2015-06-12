package edu.ifsp.ged.commons.models;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginModel {
	private String CNPJ;
	private String stationPassword;
	
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getStationPassword() {
		return stationPassword;
	}
	public void setStationPassword(String stationPassword) {
		this.stationPassword = stationPassword;
	}
	
	/**
	 * Serialize this object into a json and 
	 * return it as string.  
	 * 
	 * @return
	 * @throws JSONException 
	 */
	public String serializeInJson() throws JSONException{
		JSONObject jsonSerial = new JSONObject();
		jsonSerial.put("CNPJ", this.getCNPJ());
		jsonSerial.put("stationPassword", this.getStationPassword());				
		return jsonSerial.toString();		
	}
	
	/**
	 * Get json data from string and fill the class
	 * 
	 * @param json
	 * @throws JSONException 
	 */
	public void deserializeFromJson(String json) throws JSONException{
		JSONObject jsonMessage = new JSONObject(json);
		this.setCNPJ(jsonMessage.getString("CNPJ"));
		this.setStationPassword(jsonMessage.getString("stationPassword"));		
	}
	
	public LoginModel(String cNPJ, String stationPassword) {
		super();
		CNPJ = cNPJ;
		this.stationPassword = stationPassword;
	}	
	
}
