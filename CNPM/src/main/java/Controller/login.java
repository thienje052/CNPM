package Controller;
	

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
	
import DAO.DAONhanVien;
import DAO.DAOTaiKhoanNhanVien;
import DAO.DBConnector;
import Model.ChucVu;
import Model.NhanVien;
import Model.QuyenTruyCap;
import Model.TaiKhoanNhanVien;
	
@WebServlet("/login")
public class login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AuthLogin authLogin;
	private Connection conn;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        conn = DBConnector.getConnectionAuth();
	        authLogin = new AuthLogin(new DAOTaiKhoanNhanVien(conn));
	        String username = req.getParameter("username");
	        String password = req.getParameter("password");
	        TaiKhoanNhanVien taiKhoanNhanVien = authLogin.authenticate(username, password);
	        if (taiKhoanNhanVien != null) {
	        	DAONhanVien DAONV = new DAONhanVien(conn);
	        	NhanVien nv = DAONV.findNVbyID(taiKhoanNhanVien.getID_Employee());
	        	ChucVu chucVu = nv.getPosition();
	            HttpSession session = req.getSession();
	            session.setAttribute("currentUser", taiKhoanNhanVien);
	            List<QuyenTruyCap> userPermissions = taiKhoanNhanVien.getRoles();
                req.setAttribute("permissions", userPermissions);
                req.setAttribute("ChucVu", chucVu);
                req.setAttribute("QuanLyRole", ChucVu.Manager);
                req.setAttribute("QuyenTruyCap_HH", QuyenTruyCap.HH);
                req.setAttribute("QuyenTruyCap_NXH", QuyenTruyCap.NXH);
                req.setAttribute("QuyenTruyCap_TK", QuyenTruyCap.TK);
                req.setAttribute("QuyenTruyCap_BC", QuyenTruyCap.BC);
                req.getRequestDispatcher("/frame.jsp").forward(req, resp);
	        } else {
	            req.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
	            req.getRequestDispatcher("/login.jsp").forward(req, resp);
	        }
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
}
