package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOKho;
import DAO.DAONhanVien;
import DAO.DAOTaiKhoanNhanVien;
import DAO.DBConnector;
import Model.Kho;
import Model.NhanVien;
import Model.TaiKhoanNhanVien;

@WebServlet("/QuanLyTaiKhoan")
public class QuanLyTaiKhoan extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOTaiKhoanNhanVien DAOTK = new DAOTaiKhoanNhanVien(DBConnector.conn);
	private DAONhanVien DAONV = new DAONhanVien(DBConnector.conn);
	private DAOKho DAOK = new DAOKho(DBConnector.conn);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<NhanVien> listNV = DAONV.getAll();
		List<TaiKhoanNhanVien> listTKNV = DAOTK.getAll();
		List<Kho> listKho = DAOK.findAll();
		req.setAttribute("NhanVien", listNV);
		req.setAttribute("Kho", listKho);
		req.setAttribute("TaiKhoan", listTKNV);
		req.getRequestDispatcher("11.account.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
