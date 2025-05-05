package DAO;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.HangHoa;
import Model.LoaiHang;
public class DAOHangHoa {
	
private static Connection conn;
	
	public DAOHangHoa(Connection conn) {
		DAOHangHoa.conn = conn;
	}
	public HangHoa findByUsername(String tenhang) {
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
}
