package edu.ifsp.ged.commons.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Session {
	private int sessionId;
	private String sessionHash;
	private long activatedAt;
	private long clientType;
	
	public long getClientType() {
		return clientType;
	}
	public void setClientType(long clientType) {
		this.clientType = clientType;
	}
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public String getSessionHash() {
		return sessionHash;
	}
	public void setSessionHash(String sessionHash) {
		this.sessionHash = sessionHash;
	}
	public long getActivatedAt() {
		return activatedAt;
	}
	public void setActivatedAt(long activatedAt) {
		this.activatedAt = activatedAt;
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
		jsonSerial.put("sessionId", this.getSessionId());
		jsonSerial.put("sessionHash", this.getSessionHash());
		jsonSerial.put("activatedAt", this.getActivatedAt());
		jsonSerial.put("clientType", this.getClientType());						
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
		this.setSessionId(jsonMessage.getInt("sessionId"));
		this.setSessionHash(jsonMessage.getString("sessionHash"));
		this.setActivatedAt(jsonMessage.getLong("activatedAt"));
		this.setClientType(jsonMessage.getInt("clientType"));		
	}
	
}
