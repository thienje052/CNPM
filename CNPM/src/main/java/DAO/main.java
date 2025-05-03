package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        try (Connection conn = DBConnector.getConnection()) {
            String sql = "select MSBL, MaNhanVien from BangLuong";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("MSBL");
                String MSNV = rs.getString("MaNhanVien");
                System.out.println(id + " " + MSNV);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}