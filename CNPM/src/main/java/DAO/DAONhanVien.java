package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.ChucVu;
import Model.NhanVien;

public class DAONhanVien {
	private static Connection conn;
	
	public DAONhanVien(Connection conn) {
		DAONhanVien.conn = conn;
	}
	
	public List<NhanVien> getAll(){
		try {
			List<NhanVien> list = new ArrayList<NhanVien>();
			String sql = "select * from NhanVien";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
				list.add(new NhanVien(rs.getInt("ID"), rs.getString("Hoten"),rs.getString("Email"),rs.getString("SDT"),(rs.getString("Chucvu")).equalsIgnoreCase("Quan ly")?ChucVu.Manager:ChucVu.Employee));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public NhanVien findNVbyID(int ID) {
		NhanVien result = null;
		try {
			String sql = "select * from NhanVien where ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {			
				result = new NhanVien(rs.getInt("ID"), rs.getString("Hoten"),rs.getString("Email"),rs.getString("SDT"),(rs.getString("Chucvu")).equalsIgnoreCase("Quan ly")?ChucVu.Manager:ChucVu.Employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<NhanVien> findNVbyName(String name) {
		try {
			List<NhanVien> list = new ArrayList<NhanVien>();
			String sql = "select * from NhanVien where Hoten like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
				list.add(new NhanVien(rs.getInt("ID"), rs.getString("Hoten"),rs.getString("Email"),rs.getString("SDT"),(rs.getString("Chucvu")).equalsIgnoreCase("Quan ly")?ChucVu.Manager:ChucVu.Employee));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean add(NhanVien nv) {
		NhanVien find = findNVbyID(nv.getID());
		try {
			if(find==null) {
				String sql = "insert into NhanVien values (?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, nv.getName());
				pstmt.setString(2, nv.getEmail());
				pstmt.setString(3, nv.getPhoneNumber());
				pstmt.setString(4, String.valueOf(nv.getPosition()));
				return pstmt.executeUpdate() != 0;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(NhanVien nv) {
		try {
			String sql = "update NhanVien set hoten=?, email=?, sdt=?, chucvu=? where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nv.getName());
			pstmt.setString(2, nv.getEmail());
			pstmt.setString(3, nv.getPhoneNumber());
			pstmt.setString(4, String.valueOf(nv.getPosition()));
			pstmt.setInt(5, nv.getID());
			return pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(int ID) {
		try {
			String sql = "delete from NhanVien where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ID);
			return pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
