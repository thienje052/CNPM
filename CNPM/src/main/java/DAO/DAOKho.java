package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Kho;

public class DAOKho {
	private static Connection conn;
	
	public DAOKho(Connection conn) {
		DAOKho.conn = conn;
	}
	
	public List<Kho> findAll(){
		List<Kho> list = new ArrayList<Kho>();
		try {
			String sql = "select * from Kho";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
				list.add(new Kho(rs.getInt("ID"),rs.getString("Dia_chi"),rs.getInt("So_luong_vi_tri_trong"),rs.getInt("Suc_chua_toi_da")));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
