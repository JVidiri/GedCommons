package edu.ifsp.ged.commons.notifications;

/**
 * Actions for the notifications class.
 * 
 * @author jvidiri
 *
 */
public class NotificationActions {
	String name;//name of the action
    String jsonData;//data to be send for receiver
    String receiver; //rest client web service to be called with data.
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getJsonData() {
		return jsonData;
	}
	
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	
	public String getReceiver() {
		return receiver;
	}
	
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
    
}
