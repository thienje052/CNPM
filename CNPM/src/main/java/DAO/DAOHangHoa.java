package DAO;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.HangHoa;
import Model.LoaiHang;
public class DAOHangHoa {
	
private static Connection conn;
	public DAOHangHoa(Connection conn) {
		DAOHangHoa.conn = conn;
	}
	
	public List<HangHoa> getAll() {
		List<HangHoa> list = new ArrayList<HangHoa>();
		try {
			String sql = "select * from HangHoa where ID_ViTri is not null";	
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new HangHoa(rs.getInt("ID"),
						rs.getString("Ten"), 
						rs.getInt("So_Luong"),
						rs.getString("Don_Vi_Tinh"),
						rs.getString("Mo_ta"),	
						rs.getString("ID_LH"),
						rs.getInt("ID_ViTri")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int findMAXID() {
		try {
			String sql = "select max(ID) as id from HangHoa";	
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public HangHoa findByID(int ID) {
		HangHoa hh = null;
		try {
			String sql = "select * from HangHoa where ID=?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				hh = new HangHoa(rs.getInt("ID"),
						rs.getString("Ten"), 
						rs.getInt("So_Luong"),
						rs.getString("Don_Vi_Tinh"),
						rs.getString("Mo_ta"),	
						rs.getString("ID_LH"),
						rs.getInt("ID_ViTri"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hh;
	}
	
	public HangHoa findByname(String tenhang) {
		HangHoa hh = null;
		try {
			String sql = "select * from HangHoa where Ten like ?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tenhang);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				hh = new HangHoa(rs.getInt("ID"),
						rs.getString("Ten"), 
						rs.getInt("So_Luong"),
						rs.getString("Don_Vi_Tinh"),
						rs.getString("Mo_ta"),	
						rs.getString("ID_LH"),
						rs.getInt("ID_ViTri"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hh;
	}
	
	public HangHoa findByIDLoaiHang(String IDLoaiHang) {
		HangHoa hh = null;
		try {
			String sql = "select * from HangHoa where ID_LH like ?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, IDLoaiHang);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				hh = new HangHoa(rs.getInt("ID"),
						rs.getString("Ten"), 
						rs.getInt("So_Luong"),
						rs.getString("Don_Vi_Tinh"),
						rs.getString("Mo_ta"),	
						rs.getString("ID_LH"),
						rs.getInt("ID_ViTri"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hh;
	}
	
	public HangHoa findByIDViTri(int IDViTri) {
		HangHoa hh = null;
		try {
			String sql = "select * from HangHoa ID_ViTri?";	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, IDViTri);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				hh = new HangHoa(rs.getInt("ID"),
						rs.getString("Ten"), 
						rs.getInt("So_Luong"),
						rs.getString("Don_Vi_Tinh"),
						rs.getString("Mo_ta"),	
						rs.getString("ID_LH"),
						rs.getInt("ID_ViTri"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hh;
	}
	
	public boolean add(HangHoa hh) {
	    String sql = "INSERT INTO HangHoa (Ten, So_Luong, Don_Vi_Tinh, Mo_ta, ID_LH, ID_ViTri) VALUES (?, ?, ?, ?, ?, ?)";
	    try {
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, hh.getName());
	        pst.setInt(2, hh.getQuantity());
	        pst.setString(3, hh.getMeasurement());
	        pst.setString(4, hh.getDescription());
	        pst.setString(5, hh.getCatagory());
	        pst.setInt(6, hh.getId_position());

	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public boolean delete(int id) {
	    String sql = "DELETE FROM HangHoa WHERE ID = ?";
	    try {
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, id);
	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public boolean update(HangHoa hh) {
	    String sql = "UPDATE HangHoa SET Ten=?, So_Luong=?, Don_Vi_Tinh=?, Mo_ta=?, ID_LH=?, ID_ViTri=? WHERE ID = ?";
	    try {
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, hh.getName());
	        pst.setInt(2, hh.getQuantity());
	        pst.setString(3, hh.getMeasurement());
	        pst.setString(4, hh.getDescription());
	        pst.setString(5, hh.getCatagory());
	        pst.setInt(6, hh.getId_position());
	        pst.setInt(7, hh.getId());

	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}
