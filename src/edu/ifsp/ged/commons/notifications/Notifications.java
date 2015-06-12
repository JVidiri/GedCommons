package edu.ifsp.ged.commons.notifications;

import edu.ifsp.ged.commons.utils.Utils.NotificantionsTypes;

/**
 * Notifications type.
 * 
 * @author jvidiri
 *
 */
public class Notifications {

	NotificantionsTypes type;
	/*
	 * we need a new type, for both the client and the station,
	 * generic to be placed here, for the notifications “from”
	 * and to “being” generic.
	 */
	String receiver; 
	String message;
	NotificationActions[] actions;

	public NotificantionsTypes getType() {
		return type;
	}

	public void setType(NotificantionsTypes type) {
		this.type = type;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NotificationActions[] getActions() {
		return actions;
	}

	public void setActions(NotificationActions[] actions) {
		this.actions = actions;
	}

}
