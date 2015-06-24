package edu.ifsp.ged.commons.models;

import org.json.JSONException;
import org.json.JSONObject;

public class UserLogin {
	private long userLogin_id;
    private String userName;
    private String userPassword;
    private long user_id;

    public UserLogin(){
    	
    }
    
    public UserLogin(String userName,String userPassword){
    	this.userName = userName;
    	this.userPassword = userPassword;
    }
    
	public long getUserLogin_id() {
		return userLogin_id;
	}
	public void setUserLogin_id(long userLogin_id) {
		this.userLogin_id = userLogin_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
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
		jsonSerial.put("userLogin_id", this.getUserLogin_id());
		jsonSerial.put("userName", this.getUserName());
		jsonSerial.put("userPassword", this.getUserPassword());
		jsonSerial.put("user_id", this.getUser_id());		
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
		this.setUserLogin_id(jsonMessage.getLong("userLogin_id"));
		this.setUserName(jsonMessage.getString("stationPassword"));
		this.setUserPassword(jsonMessage.getString("stationPassword"));
		this.setUser_id(jsonMessage.getLong("stationPassword"));
	}
}
