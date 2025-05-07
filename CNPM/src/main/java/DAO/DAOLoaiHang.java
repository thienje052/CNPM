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
				list.add(new LoaiHang(Integer.parseInt(rs.getString("ID")), rs.getString("TenHang")));
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
			pstmt.setString(1, String.valueOf(loaihang.getID()));
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
			pstmt.setString(1, String.valueOf(loaihang.getID()));
			ResultSet success = pstmt.executeQuery();
			if(success.getFetchSize() != 0)
				return loaihang;
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
			pstmt.setString(1, String.valueOf(loaiHang.getID()));
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
			String sql = "update LoaiHang set TenHang=? where ID like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loaiHang.getName());
			pstmt.setString(2, String.valueOf(loaiHang.getID()));
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
			pstmt.setString(1, String.valueOf(loaiHang.getID()));
			int success = pstmt.executeUpdate();
			if(success != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
