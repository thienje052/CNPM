package DAO;

import java.sql.*;
import Model.DoiTac;
public class DAOThemDoiTac {
    private Connection conn;

    public DAOThemDoiTac(Connection conn) {
        this.conn = conn;
    }
    public void them(DoiTac dt) {
        String sql = "INSERT INTO doitac (name, email, phone_number) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dt.getName());
            stmt.setString(2, dt.getEmail());
            stmt.setString(3, dt.getPhoneNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
