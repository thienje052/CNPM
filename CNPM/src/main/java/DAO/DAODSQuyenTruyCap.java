package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.QuyenTruyCap;
import Model.TaiKhoanNhanVien;

public class DAODSQuyenTruyCap {
	private static Connection conn;
	public DAODSQuyenTruyCap(Connection conn) {
		DAODSQuyenTruyCap.conn = conn;
	}
	public List<QuyenTruyCap> getDSQuyenTruyCapbyIDNV(int ID){
		List<QuyenTruyCap> result = new ArrayList<QuyenTruyCap>();
		try {
			String sql = "select ID_Quyen from DSQuyenTruyCap where ID_NV like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(ID));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				switch(rs.getString("ID_Quyen")){
				case "NXH":
					result.add(QuyenTruyCap.NXH);
					break;
				case "TK":
					result.add(QuyenTruyCap.TK);
					break;
				case "HH":
					result.add(QuyenTruyCap.HH);
					break;
				case "BC":
					result.add(QuyenTruyCap.BC);
					break;
				default:
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean addDSQuyenTruyCapbyIDNV(String ID, List<QuyenTruyCap> List) {
		try {
			String sql = "insert into DSQuyenTruyCap values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			int success = 0;
			for (QuyenTruyCap qtc : List) {
				pstmt.setString(2, String.valueOf(qtc));
				success += pstmt.executeUpdate();
			}
			if(success == List.size()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteDSQuyenTruyCapbyIDNV(TaiKhoanNhanVien Account) {
		try {
			String sql = "delete from DSQuyenTruyCap where ID_NV like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(Account.getID()));
			int success = pstmt.executeUpdate();
			if(success != 0)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
