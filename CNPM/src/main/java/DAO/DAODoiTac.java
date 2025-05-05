package DAO;

import java.sql.Connection;

public class DAODoiTac {
	private static Connection conn;
	public DAODoiTac(Connection conn) {
		DAODoiTac.conn = conn;
	}

}
