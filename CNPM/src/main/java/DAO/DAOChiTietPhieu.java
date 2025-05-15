package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Model.Phieu;

public class DAOChiTietPhieu {
	private static Connection conn;
	public DAOChiTietPhieu(Connection conn)
	{
		this.conn=conn;
	}
	public Map<Integer, String> getMaHangTheoPhieu(List<Phieu> dsPhieu) {
        Map<Integer, String> result = new HashMap<>();

        if (dsPhieu == null || dsPhieu.isEmpty()) {
            return result;
        }

        String sql = "SELECT ID_Phieu, STRING_AGG(CAST(ID_HangHoa AS NVARCHAR), ', ') AS MaHang " +
                     "FROM ChiTietPhieu WHERE ID_Phieu IN (%s) GROUP BY ID_Phieu";

        // Tạo chuỗi dấu hỏi cho PreparedStatement
        String placeholders = dsPhieu.stream().map(p -> "?").collect(Collectors.joining(","));
        sql = String.format(sql, placeholders);

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            int index = 1;
            for (Phieu p : dsPhieu) {
                ps.setInt(index++, p.getID());
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int idPhieu = rs.getInt("ID_Phieu");
                    String maHang = rs.getString("MaHang");
                    result.put(idPhieu, maHang);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
	
	public boolean add(int idPhieu, int idHangHoa) {
	    String sql = "INSERT INTO ChiTietPhieu (ID_Phieu, ID_HangHoa) VALUES (?, ?)";
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, idPhieu);
	        ps.setInt(2, idHangHoa);
	        return ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

}
