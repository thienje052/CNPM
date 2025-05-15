package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.QuyenTruyCap;
import Model.TaiKhoanNhanVien;

public class DAOTaiKhoanNhanVien {
	private static Connection conn;
	
	public DAOTaiKhoanNhanVien(Connection conn) {
		DAOTaiKhoanNhanVien.conn = conn;
	}
	
	public List<TaiKhoanNhanVien> getAll() {
		DAODSQuyenTruyCap tc = new DAODSQuyenTruyCap(conn);
		try {
			List<TaiKhoanNhanVien> list = new ArrayList<TaiKhoanNhanVien>();
			String sql = "select * from TaiKhoanNhanVien";	
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new TaiKhoanNhanVien(rs.getInt("ID"),
						rs.getString("TenDangNhap"),
						rs.getString("MatKhau"),
						tc.getDSQuyenTruyCapbyIDNV(rs.getInt("ID")),
						rs.getInt("ID_NV"),
						rs.getInt("ID_Kho")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<TaiKhoanNhanVien> getAllByIDWarehouse(int ID) {
		DAODSQuyenTruyCap tc = new DAODSQuyenTruyCap(conn);
		try {
			List<TaiKhoanNhanVien> list = new ArrayList<TaiKhoanNhanVien>();
			String sql = "select * from TaiKhoanNhanVien where ID_Kho=?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new TaiKhoanNhanVien(rs.getInt("ID"),
						rs.getString("TenDangNhap"),
						rs.getString("MatKhau"),
						tc.getDSQuyenTruyCapbyIDNV(rs.getInt("ID")),
						rs.getInt("ID_NV"),
						rs.getInt("ID_Kho")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public TaiKhoanNhanVien findByUserAccount(String userAccount) {
		TaiKhoanNhanVien tk = null;
		DAODSQuyenTruyCap tc = new DAODSQuyenTruyCap(conn);
		try {
			String sql = "select * from TaiKhoanNhanVien where TenDangNhap like ?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userAccount);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				tk = new TaiKhoanNhanVien(rs.getInt("ID"),
						rs.getString("TenDangNhap"),
						rs.getString("MatKhau"),
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
	
	public TaiKhoanNhanVien findByUserName(String username) {
		TaiKhoanNhanVien tk = null;
		DAODSQuyenTruyCap tc = new DAODSQuyenTruyCap(conn);
		try {
			String sql = "select TaiKhoanNhanVien.* from TaiKhoanNhanVien "
					+ "join NhanVien on TaiKhoanNhanVien.ID_NV=NhanVien.ID"
					+ " where Ho_ten like ?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				tk = new TaiKhoanNhanVien(rs.getInt("ID"),
						rs.getString("TenDangNhap"),
						rs.getString("MatKhau"), 
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
	
	public TaiKhoanNhanVien findByAccountID(int accountID) {
		TaiKhoanNhanVien tk = null;
		DAODSQuyenTruyCap tc = new DAODSQuyenTruyCap(conn);
		try {
			String sql = "select * from TaiKhoanNhanVien where ID like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				tk = new TaiKhoanNhanVien(rs.getInt("ID"),
						rs.getString("TenDangNhap"),
						rs.getString("MatKhau"), 
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
	
	public TaiKhoanNhanVien findByUserID(int userID) {
		TaiKhoanNhanVien tk = null;
		DAODSQuyenTruyCap tc = new DAODSQuyenTruyCap(conn);
		try {
			String sql = "select TaiKhoanNhanVien.* from TaiKhoanNhanVien "
					+ "join NhanVien on TaiKhoanNhanVien.ID_NV=NhanVien.ID"
					+ " where NhanVien.ID like ?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				tk = new TaiKhoanNhanVien(rs.getInt("ID"),
						rs.getString("TenDangNhap"),
						rs.getString("MatKhau"), 
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
	
	public TaiKhoanNhanVien findByWarehouseID(int warehouseID) {
		TaiKhoanNhanVien tk = null;
		DAODSQuyenTruyCap tc = new DAODSQuyenTruyCap(conn);
		try {
			String sql = "select TaiKhoanNhanVien.* from TaiKhoanNhanVien "
					+ "join Kho on TaiKhoanNhanVien.ID_Kho=Kho.ID"
					+ " where Kho.ID like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, warehouseID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				tk = new TaiKhoanNhanVien(rs.getInt("ID"),
						rs.getString("TenDangNhap"),
						rs.getString("MatKhau"), 
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
	
	public int findNewestID() {
		TaiKhoanNhanVien tk = null;
		DAODSQuyenTruyCap tc = new DAODSQuyenTruyCap(conn);
		try {
			String sql = "select max(id) as ID from TaiKhoanNhanVien";
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				return rs.getInt("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean addUserAccount(TaiKhoanNhanVien newAccount) {
		DAOTaiKhoanNhanVien DAOTK = new DAOTaiKhoanNhanVien(conn);
		DAODSQuyenTruyCap DAODSQTC = new DAODSQuyenTruyCap(conn);
		TaiKhoanNhanVien existed = DAOTK.findByAccountID(newAccount.getID());
		if(existed == null) {
			try {
				String sql = "INSERT INTO TaiKhoanNhanVien VALUES (?, ?, ?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newAccount.getUserAccount());
				pstmt.setString(2, newAccount.getPassword());
				pstmt.setString(3, String.valueOf(newAccount.getID_Employee()));
				pstmt.setString(4, String.valueOf(newAccount.getID_Warehouse()));
				return pstmt.executeUpdate() != 0;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteUserAccount(int id) {
		DAOTaiKhoanNhanVien DAOTK = new DAOTaiKhoanNhanVien(conn);
		DAODSQuyenTruyCap DAOQTC = new DAODSQuyenTruyCap(conn);
		TaiKhoanNhanVien existed = DAOTK.findByAccountID(id);
		if(existed != null) {
			try {
				boolean deleteQuyenTruyCap = DAOQTC.deleteDSQuyenTruyCapbyIDNV(id);		
				String sql = "delete from TaiKhoanNhanVien where ID=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				return pstmt.executeUpdate() != 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateUserAccount(TaiKhoanNhanVien ID) {
		TaiKhoanNhanVien existed = findByAccountID(ID.getID());
		if(existed != null) {
			try {
				String sql = "update TaiKhoanNhanVien"
						+ " set TenDangNhap=?, MatKhau=?, ID_Kho=?"
						+ " where ID=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ID.getUserAccount());
				pstmt.setString(2, ID.getPassword());
				pstmt.setInt(3, ID.getID_Warehouse());
				pstmt.setInt(4, ID.getID());
				return pstmt.executeUpdate() != 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
