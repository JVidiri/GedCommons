package edu.ifsp.ged.commons.models;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.json.JSONException;
import org.json.JSONObject;

import edu.ifsp.ged.commons.ranking.UserRanking;
import edu.ifsp.ged.commons.utils.hash.HashHandler;

public class User {

	private long userId;
	private String userName;
	private long birthdayDate;
	private String UserPassword;
	private String completeName;
	private String eMail;
	private UserRanking userRanking;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(long birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public String getUserPasswordHash() {
		return UserPassword;
	}

	/**
	 * return a new generated hash for the given password
	 * 
	 * @param userPassword
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public void generatePasswordHash(String userPassword)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		setUserPasswordHash(HashHandler.createHash(userPassword));
	}

	/**
	 * Use only when you have the hash! Otherwise use generatePasswordHash.
	 * 
	 * @param userPassword
	 */
	public void setUserPasswordHash(String userPassword) {
		UserPassword = userPassword;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public UserRanking getUserRanking() {
		return userRanking;
	}

	public void setUserRanking(long userRankingId) {
		// TODO
	}

	public void setUserRanking(UserRanking userRanking) {
		this.userRanking = userRanking;
	}

	/**
	 * Serialize this object into a json and return it as string.
	 * 
	 * @return
	 * @throws JSONException
	 */
	public String serializeInJson() throws JSONException {
		JSONObject jsonSerial = new JSONObject();
		jsonSerial.put("userName", this.getUserName());
		jsonSerial.put("birthdayDate", this.getBirthdayDate());
		jsonSerial.put("completeName", this.getUserPasswordHash());
		jsonSerial.put("e_mail", this.geteMail());
		jsonSerial.put("ranking", (this.getUserRanking()).getRankingId());
		return jsonSerial.toString();
	}

	/**
	 * Get json data from string and fill the class
	 * 
	 * @param json
	 * @throws JSONException
	 */
	public void deserializeFromJson(String json) throws JSONException {
		JSONObject jsonMessage = new JSONObject(json);
		this.setUserName(jsonMessage.getString("userName"));
		this.setBirthdayDate(jsonMessage.getLong("birthdayDate"));
		this.setUserPasswordHash(jsonMessage.getString("userPassword"));
		this.setCompleteName(jsonMessage.getString("completeName"));
		this.seteMail(jsonMessage.getString("e_mail"));
		this.setUserRanking(jsonMessage.getLong("ranking"));
	}

}
