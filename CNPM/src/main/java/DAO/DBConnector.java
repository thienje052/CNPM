package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanlyKho;encrypt=true;trustServerCertificate=true";
	private static String URLforCreateUser = "jdbc:sqlserver://localhost:1433;databaseName=master;encrypt=true;trustServerCertificate=true";
	private static String auth = "authenticate";
	private static String sysadmin = "sysadminCon";
	private static String passwordAuth = "@uthent1cate";
	private static String passwordSysadmin = "sysadmin";
	public static Connection conn;
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch(ClassNotFoundException ex) {
			System.err.println("Không tim thấy driver SQL Server!");
			ex.printStackTrace();
		}
	}
	public static Connection getConnectionAuth() throws SQLException {
		conn = DriverManager.getConnection(URL, auth, passwordAuth);
		return conn;
	}
	public static Connection getConnectionForLogin(String username, String password) throws SQLException {
		conn = DriverManager.getConnection(URL, username, password);
		return conn;
	}
	public static Connection getConnectionCreateUser() throws SQLException {
		conn = DriverManager.getConnection(URLforCreateUser, sysadmin, passwordSysadmin);
		return conn;
	}
}
