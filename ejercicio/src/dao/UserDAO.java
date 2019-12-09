 package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.UserBean;
import utils.ConnectionUtils;

public class UserDAO {
//En esta clase compruebo si el login es correcto
	public UserBean checkLogin(String userName, String pass) {
		try {
			//Abro la conexión
			ConnectionUtils connectionUtils = new ConnectionUtils();
			Connection connection = connectionUtils.openConnection();
			//Preparo el statement
			PreparedStatement s = connection.prepareStatement("select * from user_login where user_name = ? and pass = ?");
			s.setString(1, userName);
			s.setString(2, pass);
			ResultSet rs = s.executeQuery();
			UserBean userBean = null;
			if (rs.next()) {
				userBean = new UserBean(userName, pass);
			}
			connectionUtils.closeConnection(connection);
			return userBean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
