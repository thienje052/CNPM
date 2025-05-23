package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.LoaiHang;

public class DAOLoaiHang {
	private static Connection conn;
	
	public DAOLoaiHang(Connection conn) {
		DAOLoaiHang.conn = conn;
	}
	
	public List<LoaiHang> getAll(){
		try {
			List<LoaiHang> list = new ArrayList<LoaiHang>();
			String sql = "select * from LoaiHang";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new LoaiHang(rs.getString("ID"), rs.getString("TenHang")));
			}
			if(!list.isEmpty())
				return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public LoaiHang find(LoaiHang loaihang) {
		try {
			String sql = "select * from LoaiHang where ID like ? and TenHang like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(loaihang.getId()));
			pstmt.setString(2, loaihang.getName());
			ResultSet success = pstmt.executeQuery();
			if(success.getFetchSize() != 0)
				return loaihang;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public LoaiHang findByID(LoaiHang loaihang) {
		try {
			String sql = "select * from LoaiHang where ID like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loaihang.getId());
			ResultSet success = pstmt.executeQuery();
			if(success.next())
				return new LoaiHang(success.getString("ID"), success.getString("TenHang"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public LoaiHang findByName(LoaiHang loaihang) {
		try {
			String sql = "select * from LoaiHang where ITenHang like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loaihang.getName());
			ResultSet success = pstmt.executeQuery();
			if(success.getFetchSize() != 0)
				return loaihang;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean add(LoaiHang loaiHang) {
		try {
			String sql = "insert into LoaiHang values (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(loaiHang.getId()));
			pstmt.setString(2, loaiHang.getName());
			int success = pstmt.executeUpdate();
			if(success != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(LoaiHang loaiHang) {
		try {
			String sql = "update LoaiHang set TenHang=? where ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loaiHang.getName	());
			pstmt.setString(2, loaiHang.getId());
			int success = pstmt.executeUpdate();
			if(success != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(LoaiHang loaiHang) {
		try {
			String sql = "delete from LoaiHang where ID like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(loaiHang.getId()));
			int success = pstmt.executeUpdate();
			if(success != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
