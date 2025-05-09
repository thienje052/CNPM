package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;

import Model.Phieu;

public class DAODonHang {

	private Connection conn;
	
	public DAODonHang(Connection conn) {
		this.conn=conn;
	}

	public List<Phieu> timKiemDonHang(String loaiDon, String maDoiTac, String ngay, String maDon, String maNhanVien) {

        return danhSach;
	}
}
