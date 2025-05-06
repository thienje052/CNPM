package DAO;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.HangHoa;
import Model.LoaiHang;
public class DAOHangHoa {
	
private static Connection conn;
	//hmmmm
	public DAOHangHoa(Connection conn) {
		DAOHangHoa.conn = conn;
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
						rs.getString("ID_LH"));
			}
			return hh;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean add(HangHoa hh) {
	    String sql = "INSERT INTO HangHoa (ID, Ten, So_Luong, Don_Vi_Tinh, Mo_ta, ID_LH) VALUES (?, ?, ?, ?, ?, ?)";
	    try {
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, hh.getID());
	        pst.setString(2, hh.getName());
	        pst.setInt(3, hh.getQuantity());
	        pst.setString(4, hh.getMeasurement());
	        pst.setString(5, hh.getDescription());
	        pst.setString(6, hh.getCatagory());

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
	    String sql = "UPDATE HangHoa SET Ten = ?, So_Luong = ?, Don_Vi_Tinh = ?, Mo_ta = ?, ID_LH = ? WHERE ID = ?";
	    try {
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, hh.getName());
	        pst.setInt(2, hh.getQuantity());
	        pst.setString(3, hh.getMeasurement());
	        pst.setString(4, hh.getDescription());
	        pst.setString(5, hh.getCatagory());
	        pst.setInt(6, hh.getID());

	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


}
