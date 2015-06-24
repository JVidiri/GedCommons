package edu.ifsp.ged.commons.utils;
/**
 * Class with utils variables for the project.
 * 
 * @author jvidiri
 *
 */
public class Utils {
	
	public static final String PRIVATE_KEY = "/home/jvidiri/Dropbox/RSA/pkcs8_key";	
	public static final String PUBLIC_KEY = "/home/jvidiri/Dropbox/RSA/public_key.der";
	
	/**
	 * notifications types.
	 * 
	 */
	public enum NotificantionsTypes {
		SYSTEM, STATION, USER, STATIONPROMOTION
	}
	
	public enum enumUserJsonMessagesTypes{
		REGIST,MODIFY,DELETE
	}
	
	public enum clientsTypes{
		MOBILE, ADMIN_CONSOLE
	}	
	
	public enum enumGasTypes{
		COMUM, ADITIVADA, PREMIUM
	}
	
	public enum enumEtanolTypes{
		COMUM, PREMIUM
	}
	
	public enum enumDieselType{
		S10, S500
	}
}
