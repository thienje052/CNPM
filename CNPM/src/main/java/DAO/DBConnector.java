package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanlyKho;encrypt=true;trustServerCertificate=true";
	private static String auth = "jdbc_user";
	private static String passwordAuth = "123456";
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch(ClassNotFoundException ex) {
			System.err.println("Không tim thấy driver SQL Server!");
			ex.printStackTrace();
		}
	}
	public static Connection getConnectionAuth() throws SQLException {
		return DriverManager.getConnection(URL, auth, passwordAuth);
	}
	public static Connection getConnectionForLogin(String username, String password) throws SQLException {
		return DriverManager.getConnection(URL, username, password);
	}
}
