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
		DAOTaiKhoanNhanVien.conn = conn;
	}
	public TaiKhoanNhanVien findByUsername(String username) {
		TaiKhoanNhanVien tk = null;
		DAOQuyenTruyCap tc = new DAOQuyenTruyCap(conn);
		try {
			String sql = "select * from TaiKhoanNhanVien where Ten_dang_nhap like ?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				tk = new TaiKhoanNhanVien(rs.getInt("ID"),
						rs.getString("Ten_dang_nhap"),
						rs.getString("Mat_khau"), 
						tc.getQuyenTruyCapbyID(rs.getInt("ID")),
						rs.getInt("ID_NV"),
						rs.getInt("ID_Kho"));
			}
			return tk;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
