package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DoiTac;
public class DAODoiTac {
	private static Connection conn;

	public DAODoiTac(Connection conn) {
		this.conn = conn;
	}
	public DoiTac findByName(String username) {
		DoiTac dt = null;
		try {
			String sql = "select * from DoiTac where Ten like ?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				dt = new DoiTac(rs.getInt("ID"),
						rs.getString("Ten"),
						rs.getString("Email"),
						rs.getString("SDT"));
			}
			return dt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
