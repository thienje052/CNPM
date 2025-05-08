package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.LoaiHang;
import Model.LoaiPhieu;
import Model.NhanVien;
import Model.QuyenTruyCap;
import Model.TaiKhoanNhanVien;

public class main_test_connection {
    public static void main(String[] args) {
        try (Connection conn = DBConnector.getConnectionAuth()) {
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
            	
//            	TaiKhoanNhanVien test = tk.findByWarehouseID("1");
//            	System.out.println(test.toString());
            	
//            	DAOLoaiHang lh = new DAOLoaiHang(conn);
//            	LoaiHang test = new LoaiHang(1, "De vo");
//            	if(lh.find(test) != null)
//            		System.out.println("Tim thay!");
            	
//            	TaiKhoanNhanVien taiKhoanNhanVien = tk.findByUserAccount("Tuan");
//            	DAONhanVien daoNhanVien = new DAONhanVien(conn);
//            	NhanVien test = daoNhanVien.findNVbyID(String.valueOf(taiKhoanNhanVien.getID_Employee()));
//            	if(test != null) {
//            		test.toString();
//            		System.out.println(test.toString());
//            	}
            	
            	TaiKhoanNhanVien test = new TaiKhoanNhanVien(2, "KyAnh", "Ky@nh2004", new ArrayList<QuyenTruyCap>(List.of(QuyenTruyCap.NXH)), 2, 1);
            	tk.addUserAccount(test);
        } catch (SQLException e) {
			e.printStackTrace();
		} 
    }	
}