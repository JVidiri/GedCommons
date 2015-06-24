package edu.ifsp.ged.commons.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.ifsp.ged.commons.models.DistributorBase;
import edu.ifsp.ged.commons.models.Sintegra;
import edu.ifsp.ged.commons.models.Station;
import edu.ifsp.ged.commons.models.StationLogin;
import edu.ifsp.ged.commons.models.User;
import edu.ifsp.ged.commons.models.UserLogin;

/**
 * Classe responsavel pala conexão e manejamento do banco de dados.
 * 
 * @author jvidiri 
 *
 */
public class DBFacade {
	//objeto de connexão com o banco.
	Connection conn = null;
	static String forNameDbClass = "org.postgresql.Driver"; 
	static String doConnString = "jdbc:postgresql://localhost:5432/gedDb";
	static String dbPass = "gedAdm123";
	static String dbName = "gedAdm";

	/**
	 * open the new connection to be used in the class.
	 */
	public void createConnection() throws Exception {
		Class.forName(forNameDbClass);
		conn = DriverManager.getConnection(doConnString, dbName, dbPass);
	}	

	/**
	 * close the actual connection.
	 */
	public void closeConnection() throws Exception {
		// verify the connection is open
		if (isConnected()) {
			// if open close
			conn.close();
		}
	}
	
	/**
	 * Verifica conexão com o banco, se existente retorna true;
	 * @return
	 */
	public boolean isConnected() throws Exception {
		// verify the connection is open
		if (conn.isValid(1000)) {
			// if open return true
			return true;
		}
		return false;
	}
	
	/**
	 * Pocura usuário na base de dados
	 * 
	 * @param userName
	 * @return
	 * @throws SQLException 
	 */
	public User getUserByUserName(String userName) throws SQLException{
		String selectUser = "select * from user where userName = ?;";		
		PreparedStatement statement = conn.prepareStatement(selectUser, Statement.RETURN_GENERATED_KEYS);
		ResultSet result;
		statement.setString(1, userName);		
		result = statement.executeQuery();
		if (result.next()){
			//creating new user to return to caller
			User newUserModel = new User();			
			newUserModel.setBirthdayDate(result.getLong("birthdayDate"));
			newUserModel.setCompleteName(result.getString("completeName"));
			newUserModel.seteMail(result.getString("e_mail"));
			newUserModel.setUserName(result.getString("userName"));
			newUserModel.setUserRanking(result.getLong("userRankingId"));
			newUserModel.setUserPasswordHash("userPassword");
			//return to caller
			return newUserModel;
		}		
		return null;
	}
	
	/**
	 * Pocura usuário na base de dados
	 * 
	 * @param userName
	 * @return
	 * @throws SQLException 
	 */
	public UserLogin getUserLoginByUserName(String userName) throws SQLException{
		String selectUser = "select * from UserLogin where userName = ?;";		
		PreparedStatement statement = conn.prepareStatement(selectUser, Statement.RETURN_GENERATED_KEYS);
		ResultSet result;
		statement.setString(1, userName);		
		result = statement.executeQuery();
		if (result.next()){
			//creating new user to return to caller
			UserLogin newUserModel = new UserLogin();
			newUserModel.setUserName(userName);
			newUserModel.setUserPassword("userPassword");
			//return to caller
			return newUserModel;
		}		
		return null;
	}
	
	/**
	 * Pocura usuário na base de dados
	 * 
	 * @param userName
	 * @return
	 * @throws SQLException 
	 */
	public StationLogin getStationLoginByCNPJ(String CNPJ) throws SQLException{										   
		String selectUser = "select * from \"stationLoginData\" where \"stationCNPJ\" = ?;";		
		PreparedStatement statement = conn.prepareStatement(selectUser);
		//add the where parameter
		statement.setString(1, CNPJ);
		System.out.println(statement);
		ResultSet result;				
		result = statement.executeQuery();
		if (result.next()){
			//creating new user to return to caller
			StationLogin newStation = new StationLogin();			
			newStation.setCNPJ(CNPJ);
			newStation.setStationPassword(result.getString("stationPassword"));						
			//return to caller
			return newStation;
		}		
		return null;
	}
	
	/**
	 * Consulta cnpj e retorna se ele já está  
	 * 
	 * @param cnpj
	 * @return
	 */
	public boolean consultCnpj(String cnpj){
		return false;
	} 
	
	/**
	 * To regist the station.
	 * 
	 * @param toResgist
	 * @return
	 */
	public int stationRegist(Station toResgist) {
		return 0;
	}

	/**
	 * To registe the distribution
	 * 
	 * @param toRegist
	 * @return
	 */
	public int distributorRegist(DistributorBase toRegist) {
		return 0;
	}
	
	/**
	 * To registe the distribution
	 * 
	 * @param toRegist
	 * @return
	 * @throws SQLException 
	 */
	public int addActiveSessionRegist(String hash) throws SQLException {
		String insertUser = "insert into \"activeSessions\"(\"hash\",\"activatedAt\") values(?,?);";
		PreparedStatement statement = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, hash);
		statement.setLong(2, System.currentTimeMillis());		
		int result =  statement.executeUpdate();
		System.out.println(statement);
		return result;
	}

	/**
	 * To regist the user.
	 * 
	 * @param toRegist
	 * @return
	 */
	public int userRegist(User toRegist) throws SQLException{		
		String insertUser = "insert into user(userName,	birthdayDate, userPassword, completeName, e_mail) values(?,?,?,?,?);";
		PreparedStatement statement = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, toRegist.getUserName());
		statement.setLong(2, toRegist.getBirthdayDate());		
		statement.setString(3, toRegist.getUserPasswordHash());		
		statement.setString(4, toRegist.getCompleteName());
		statement.setString(5, toRegist.geteMail());
		int result =  statement.executeUpdate();
		return result;
		
	}

	/**
	 * To regist the station data of a station.
	 * 
	 * @param toRegist
	 * @return
	 */
	public int sintegraDataRegist(Sintegra toRegist) {
		return 0;
	}

	/**
	 * To regist the station data of a station.
	 * 
	 * @param toRegist
	 * @return
	 */
	public int stationChange(Sintegra newData, int idToChange) {
		return 0;
	}

	/**
	 * To change the distributor data. 
	 * 
	 * @param newData
	 * @param idToChange
	 * @return
	 */
	public int distributorChange(DistributorBase newData, int idToChange) {
		return 0;
	}

	/**
	 * To change the user data of the id.
	 * 
	 * @param newData
	 * @param idToChange
	 * @return
	 */
	public int userChange(User newData, int idToChange) {
		return 0;
	}

	/**
	 * To change the sintegra data of the id.
	 * 
	 * @param newData
	 * @param idToChange
	 * @return
	 */
	public int updateSintegraChange(Sintegra newData, int idToChange) {
		return 0;
	}

	/**
	 * To delete a station data.
	 * 
	 * @param idToDelete
	 * @return
	 */
	public int stationDelete(int idToDelete) {
		return 0;
	}

	/**
	 * To delete a ditributor data.
	 * 
	 * @param idToDelete
	 * @return
	 */
	public int distributorDelete(int idToDelete) {
		return 0;
	}

	/**
	 * To delete a user data
	 * 
	 * @param idToDelete
	 * @return
	 */
	public int userDelete(int idToDelete) {
		return 0;
	}

	/**
	 * To delete sintegra data.
	 * @param idToDelete
	 * @return
	 */
	public int sintegraDelete(int idToDelete) {
		return 0;
	}

	
	
}
