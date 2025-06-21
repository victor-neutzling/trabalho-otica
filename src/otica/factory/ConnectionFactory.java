package otica.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "050105";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/otica";
	
	public static Connection createConnectionToMySQL() throws Exception {
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
}
