package otica.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/otica";
	private static final String PASSWORD = "CfWUcsCXPKzgouqfiAlIrdzwkCMjouLK";
	private static final String DATABASE_URL = "jdbc:mysql://nozomi.proxy.rlwy.net:16806/otica";

	
	public static Connection createConnectionToMySQL() throws Exception {
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD1);
		
		return connection;
	}
}
