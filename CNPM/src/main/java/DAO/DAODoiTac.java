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
	
	public DoiTac findByID(int ID) {
		DoiTac dt = null;
		try {
			String sql = "select * from DoiTac where ID=?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				dt = new DoiTac(rs.getInt("ID"),
						rs.getString("Ten"),
						rs.getString("Email"),
						rs.getString("SDT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dt;
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dt;
	}
	
	public boolean add(DoiTac dt) {
        try {
        	String sql = "INSERT INTO doitac (ten, email, so_dien_thoai) VALUES (?, ?, ?)";
        	PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dt.getName());
            stmt.setString(2, dt.getEmail());
            stmt.setString(3, dt.getPhoneNumber());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public boolean delete(DoiTac dt) {
		try {
			String checkDoiTac = "select * from Phieu where ID_DoiTac=?";
			PreparedStatement pstmt = conn.prepareStatement(checkDoiTac);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next())  {
				String sql = "delete from DoiTac where ID=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dt.getID());
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(DoiTac dt) {
		try {
			String sql = "update DoiTac set Ten=?, So_dien_thoai=?, Email=? where ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dt.getName());
			pstmt.setString(2, dt.getPhoneNumber());
			pstmt.setString(3, dt.getEmail());
			pstmt.setInt(4, dt.getID());
			return pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
