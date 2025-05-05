package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.TaiKhoanNhanVien;

public class main {
    public static void main(String[] args) {
        try (Connection conn = DBConnector.getConnection()) {
            	DAOTaiKhoanNhanVien tk = new DAOTaiKhoanNhanVien(conn);
            	TaiKhoanNhanVien test = tk.findByUsername("ThienTran");
            	System.out.println(test.toString());
        } catch (SQLException e) {
			e.printStackTrace();
		} 
    }	
}