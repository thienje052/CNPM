package DAO;

import java.sql.Connection;

public class DAOPhieu {
	private static Connection conn;
	public DAOPhieu(Connection conn) {
		DAOPhieu.conn = conn;
	}
}
