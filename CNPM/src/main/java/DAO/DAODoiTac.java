package DAO;
import java.sql.*;
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
	
	public boolean add(DoiTac dt) {
        String sql = "INSERT INTO doitac (name, email, phone_number) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dt.getName());
            stmt.setString(2, dt.getEmail());
            stmt.setString(3, dt.getPhoneNumber());
            int success = stmt.executeUpdate();
            if (success == 1)
            	return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
