package edu.ifsp.ged.commons.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.ifsp.ged.commons.models.DistributorBaseModel;
import edu.ifsp.ged.commons.models.SintegraModel;
import edu.ifsp.ged.commons.models.StationModel;
import edu.ifsp.ged.commons.models.UserModel;

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
	static String doConnString = "jdbc:postgresql://localhost:5432/testdb";
	static String dbPass = "gedAdm123";
	static String dbName = "gedControl";

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
		if (conn.isValid(1000)) {
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
	public UserModel getUserByUserName(String userName) throws SQLException{
		String selectUser = "select * from user where userName = ?;";		
		PreparedStatement statement = conn.prepareStatement(selectUser, Statement.RETURN_GENERATED_KEYS);
		ResultSet result;
		statement.setString(1, userName);		
		result = statement.executeQuery();
		if (result.next()){
			//creating new user to return to caller
			UserModel newUserModel = new UserModel();			
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
	public int stationRegist(StationModel toResgist) {
		return 0;
	}

	/**
	 * To registe the distribution
	 * 
	 * @param toRegist
	 * @return
	 */
	public int distributorRegist(DistributorBaseModel toRegist) {
		return 0;
	}

	/**
	 * To regist the user.
	 * 
	 * @param toRegist
	 * @return
	 */
	public int userRegist(UserModel toRegist) throws SQLException{		
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
	public int sintegraDataRegist(SintegraModel toRegist) {
		return 0;
	}

	/**
	 * To regist the station data of a station.
	 * 
	 * @param toRegist
	 * @return
	 */
	public int stationChange(SintegraModel newData, int idToChange) {
		return 0;
	}

	/**
	 * To change the distributor data. 
	 * 
	 * @param newData
	 * @param idToChange
	 * @return
	 */
	public int distributorChange(DistributorBaseModel newData, int idToChange) {
		return 0;
	}

	/**
	 * To change the user data of the id.
	 * 
	 * @param newData
	 * @param idToChange
	 * @return
	 */
	public int userChange(UserModel newData, int idToChange) {
		return 0;
	}

	/**
	 * To change the sintegra data of the id.
	 * 
	 * @param newData
	 * @param idToChange
	 * @return
	 */
	public int updateSintegraChange(SintegraModel newData, int idToChange) {
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
