package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.QuyenTruyCap;
import Model.TaiKhoanNhanVien;

public class DAOTaiKhoanNhanVien {
	private static Connection conn;
	
	public DAOTaiKhoanNhanVien(Connection conn) {
		this.conn = conn;
	}
	public static TaiKhoanNhanVien findByUsername(String username) {
		try {
			String sql = "select * from TaiKhoanNhanVien where Ten_dang_nhap like ?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				return new TaiKhoanNhanVien(rs.getInt("ID"), rs.getString("Ten_dang_nhap"),
						rs.getString("Mat_khau"), QuyenTruyCap.ImportAndExport, rs.getInt("ID_NV"), rs.getInt("ID_Kho"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
