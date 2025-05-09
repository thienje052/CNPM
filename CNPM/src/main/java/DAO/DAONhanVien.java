package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.ChucVu;
import Model.NhanVien;

public class DAONhanVien {
	private static Connection conn;
	
	public DAONhanVien(Connection conn) {
		DAONhanVien.conn = conn;
	}
	
	public NhanVien findNVbyID(int ID) {
		NhanVien result = null;
		try {
			String sql = "select * from NhanVien where ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {			
				result = new NhanVien(rs.getInt("ID"), rs.getString("Hoten"),rs.getString("Email"),rs.getString("SDT"),(rs.getString("Chucvu")).equals("Quan ly")?ChucVu.Manager:ChucVu.Employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
