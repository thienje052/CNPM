package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        try (Connection conn = DBConnector.getConnection()) {
            String sql = "select mat_khau from TaiKhoanNhanVien";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("mat_khau");
                System.out.println(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}	