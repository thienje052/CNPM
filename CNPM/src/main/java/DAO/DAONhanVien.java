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
	
	public NhanVien findNVbyID(String ID) {
		try {
			String sql = "select * from NhanVien where ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {			
				NhanVien result = new NhanVien(rs.getInt("ID"),
<<<<<<< HEAD
				rs.getString("HoTen"),
=======
				rs.getString("Hoten"),
>>>>>>> branch 'main' of https://github.com/thienje052/CNPM.git
				rs.getString("Email"),
				rs.getString("SDT"),
<<<<<<< HEAD
				(rs.getString("ChucVu")).equals("Quan ly")?ChucVu.Manager:ChucVu.Employee);
=======
				(rs.getString("Chucvu")).equals("Quan ly")?ChucVu.Manager:ChucVu.Employee);
>>>>>>> branch 'main' of https://github.com/thienje052/CNPM.git
				return result;}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
