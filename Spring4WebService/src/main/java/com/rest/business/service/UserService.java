/**
 * 
 */
package com.rest.business.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rest.business.domain.User;
import com.rest.business.integration.DBUtility;

/**
 * @author Admin
 *
 */
public class UserService {
	
	private Connection connection;

	/**
	 * 
	 */
	public UserService() {


		connection = DBUtility.getConnection();
	}

	public List<User> getUsers(){
		
		List<User> users = new ArrayList<User>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery("select * from restuser limit 15");
			
			while (res.next()) {
				
				User user = new User();
				user.setUserid(res.getInt("userid"));
				user.setFirstName(res.getString("firstname"));
				user.setLastName(res.getString("lastname"));
				user.setEmail(res.getString("email"));

				users.add(user);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
public User getUserById(int userId){
		
	User user = new User();
		try {
			PreparedStatement  preparedStatement = connection.prepareStatement("select * from restuser where userid=?");
			preparedStatement.setInt(1, userId);	
			ResultSet res = preparedStatement.executeQuery();

			
			while (res.next()) {
				
				
				user.setUserid(res.getInt("userid"));
				user.setFirstName(res.getString("firstname"));
				user.setLastName(res.getString("lastname"));
				user.setEmail(res.getString("email"));

			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
