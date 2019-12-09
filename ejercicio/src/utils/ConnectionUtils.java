package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Como esto lo van a usar cuatro métodos diferentes en dos clases diferentes, 
//lo creo en una clase aparte para evitar duplicar código 
public class ConnectionUtils {
	public Connection openConnection() throws SQLException, ClassNotFoundException{
		Connection connection = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jstl" 
					+ "?useUnicode=true&useJDBCCompliantTimezone"
					+ "Shift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Madrid",
					"root", "");//Este churro es porque no me coge bien la conexión si no lo escribo, rollos del eclipse

		return connection;
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
