package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.QuyenTruyCap;

public class DAOQuyenTruyCap {
	private static Connection conn;

	public DAOQuyenTruyCap(Connection conn) {
		this.conn = conn;
	}
	
	public List<QuyenTruyCap> getQuyenTruyCapbyID(int ID){
		List<QuyenTruyCap> result = new ArrayList<QuyenTruyCap>();
		try {
			String sql = "select QuyenTruyCap.QuyenTruyCap from DSQuyenTruyCap join QuyenTruyCap on DSQuyenTruyCap.ID_Quyen=QuyenTruyCap.ID where DSQuyenTruyCap.ID_NV like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(ID));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				switch(rs.getString("QuyenTruyCap")){
				case "Quan ly nhap/xuat":
					result.add(QuyenTruyCap.ImportAndExport);
					break;
				case "Quan ly tai khoan":
					result.add(QuyenTruyCap.AccountManagement);
					break;
				case "Quan ly hang hoa":
					result.add(QuyenTruyCap.GoodsManagement);
					break;
				case "Quan ly thong ke":
					result.add(QuyenTruyCap.Report);
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
	
}
