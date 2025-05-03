package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyLuong;encrypt=true;trustServerCertificate=true";
	private static String user = "jdbc_user";
	private static String password = "123456";
	
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch(ClassNotFoundException ex) {
			System.err.println("Không tim thấy driver SQL Server!");
			ex.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, user, password);
	}
	public static void testConnection() {
		try {
			Connection conn = getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công đến SQL Server!");
            }
        } catch (SQLException e) {
            System.err.println("Không thể kết nối đến cơ sở dữ liệu.");
            e.printStackTrace();
        }
	}
}
