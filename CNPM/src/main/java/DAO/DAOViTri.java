package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ViTri;

public class DAOViTri {
	private static Connection conn;
	
	public DAOViTri(Connection conn) {
		DAOViTri.conn = conn;
	}
	
	public ViTri findViTri(int ID) {
		try {
			String sql = "select * from ViTri where ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				return new ViTri(rs.getInt("ID"),
						rs.getInt("Ke"), rs.getInt("Hang"),
						rs.getInt("Tang"),
						rs.getInt("Kho"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int soKeTrong(int ID_Kho) {
		try {
			String sql = "select count(ID) as Number from ViTri where ID_Kho=? and ID not in (SELECT ID_ViTri from HangHoa)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ID_Kho);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
				return rs.getInt("Number");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<ViTri> findTrong(int ID_Kho) {
		List<ViTri> list = new ArrayList<ViTri>();
		try {
			String sql = "select * from ViTri where ID_Kho=? and ID not in (SELECT ID_ViTri from HangHoa)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ID_Kho);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
				list.add(new ViTri(rs.getInt("ID"),
						rs.getString("Ke"), rs.getInt("Hang"),
						rs.getInt("Tang"),
						rs.getInt("ID_Kho")));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
