package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.QuyenTruyCap;
import Model.TaiKhoanNhanVien;

public class main_test_connection {
    public static void main(String[] args) {
        try (Connection conn = DBConnector.getConnection()) {
            	DAOTaiKhoanNhanVien tk = new DAOTaiKhoanNhanVien(conn);
//        		TaiKhoanNhanVien TK = new TaiKhoanNhanVien(2, "TranThien", "123", new ArrayList<QuyenTruyCap>(List.of(QuyenTruyCap.HH, QuyenTruyCap.NXH)) , 2, 1);
//        		DAOTK.deleteUserAccount(TK);
//        		DAOTK.addUserAccount(TK);
        		
//            	TaiKhoanNhanVien test = tk.findByAccountID("1");
//            	System.out.println(test.toString());
        		
//            	TaiKhoanNhanVien test = tk.findByUserID("1");
//            	System.out.println(test.toString());
            	
//            	TaiKhoanNhanVien test = tk.findByUsername("ThienTran");
//            	System.out.println(test.toString());
            	
//            	TaiKhoanNhanVien test = tk.findByUserName("Tran Chi Thien");
//            	System.out.println(test.toString());
            	
            	TaiKhoanNhanVien test = tk.findByWarehouseID("1");
            	System.out.println(test.toString());
        } catch (SQLException e) {
			e.printStackTrace();
		} 
    }	
}