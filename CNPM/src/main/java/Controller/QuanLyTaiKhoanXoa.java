package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAONhanVien;
import DAO.DAOTaiKhoanNhanVien;
import DAO.DBConnector;
import Model.TaiKhoanNhanVien;

@WebServlet("/QuanLyTaiKhoanXoa")
public class QuanLyTaiKhoanXoa extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOTaiKhoanNhanVien DAOTK = new DAOTaiKhoanNhanVien(DBConnector.conn);
	private DAONhanVien DAONV = new DAONhanVien(DBConnector.conn);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selected = req.getParameter("selectedAccount");
        System.out.println(selected);
	    if (selected != null) {
	    	DAOTK.deleteUserAccount(Integer.parseInt(selected));
	        req.getRequestDispatcher("QuanLyTaiKhoan").forward(req, resp);
	    } else {
	    	req.setAttribute("error", "Chọn tài khoản để xóa!");
	        req.getRequestDispatcher("QuanLyTaiKhoan").forward(req, resp);
	    }
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
