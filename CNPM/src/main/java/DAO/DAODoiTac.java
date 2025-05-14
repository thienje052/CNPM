package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.DoiTac;
import Model.LoaiHang;
public class DAODoiTac {
	private static Connection conn;

	public DAODoiTac(Connection conn) {
		this.conn = conn;
	}
	
	public List<DoiTac> getAll(){
		try {
			List<DoiTac> list = new ArrayList<DoiTac>();
			String sql = "select * from DoiTac";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new DoiTac(rs.getInt("ID"), rs.getString("Ten"), rs.getString("So_Dien_Thoai"), rs.getString("Email")));
			}
			if(!list.isEmpty())
				return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
						rs.getString(""),
						rs.getString("Email"));
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
						rs.getString("SDT"),
						rs.getString("Email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dt;
	}
	
	public boolean add(DoiTac dt) {
        try {
        	String sql = "INSERT INTO doitac (ten, so_dien_thoai, email) VALUES (?, ?, ?)";
        	PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dt.getName());
            stmt.setString(2, dt.getPhoneNumber());
            stmt.setString(3, dt.getEmail());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public boolean delete(DoiTac dt) {
		try {
			String checkDoiTac = "select * from Phieu where ID_DoiTac=?";
			PreparedStatement checkStmt  = conn.prepareStatement(checkDoiTac);
			checkStmt .setInt(1, dt.getId());
			ResultSet rs = checkStmt .executeQuery();
	        if (rs.next()) {
	            return false;
	        }
			String deleteSql  = "delete from DoiTac where ID=?";
			PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
			deleteStmt .setInt(1, dt.getId());
			int affected = deleteStmt.executeUpdate();
	        return affected > 0;
	        
		} catch (SQLException e) {
	        e.printStackTrace();
	        return false;
		}
	}
	
	public boolean update(DoiTac dt) {
		try {
			String sql = "update DoiTac set Ten=?, So_dien_thoai=?, Email=? where ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dt.getName());
			pstmt.setString(2, dt.getPhoneNumber());
			pstmt.setString(3, dt.getEmail());
			pstmt.setInt(4, dt.getId());
			return pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
