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
		DAODSQuyenTruyCap tc = new DAODSQuyenTruyCap(conn);
		try {
			String sql = "select * from TaiKhoanNhanVien where Ten_dang_nhap like ?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				tk = new TaiKhoanNhanVien(rs.getInt("ID"),
						rs.getString("Ten_dang_nhap"),
						rs.getString("Mat_khau"), 
						tc.getDSQuyenTruyCapbyIDNV(rs.getInt("ID")),
						rs.getInt("ID_NV"),
						rs.getInt("ID_Kho"));
			}
			return tk;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean addUserAccount(TaiKhoanNhanVien newAccount) {
		DAOTaiKhoanNhanVien DAOTK = new DAOTaiKhoanNhanVien(conn);
		DAODSQuyenTruyCap DAODSQTC = new DAODSQuyenTruyCap(conn);
		TaiKhoanNhanVien existed = DAOTK.findByUsername(newAccount.getUserAccount());
		if(existed == null) {
			String sql = "insert into TaiKhoanNhanVien values(?,?,?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, String.valueOf(newAccount.getID()));
				pstmt.setString(2, newAccount.getUserAccount());
				pstmt.setString(3, newAccount.getPassword());
				pstmt.setString(4, String.valueOf(newAccount.getID_Employee()));
				pstmt.setString(5, String.valueOf(newAccount.getID_Warehouse()));
				int success = pstmt.executeUpdate();
				if(success != 0 && DAODSQTC.addDSQuyenTruyCapbyIDNV(String.valueOf(newAccount.getID()), newAccount.getRoles()))
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean deleteUserAccount(TaiKhoanNhanVien Account) {
		DAOTaiKhoanNhanVien DAOTK = new DAOTaiKhoanNhanVien(conn);
		DAODSQuyenTruyCap DAOQTC = new DAODSQuyenTruyCap(conn);
		TaiKhoanNhanVien existed = DAOTK.findByUsername(Account.getUserAccount());
		if(existed != null) {
			try {
				boolean deleteQuyenTruyCap = DAOQTC.deleteDSQuyenTruyCapbyIDNV(Account);
				String sql = "delete from TaiKhoanNhanVien where Ten_dang_nhap like ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, Account.getUserAccount());
				int success = pstmt.executeUpdate();
				if(success != 0 && deleteQuyenTruyCap)
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
