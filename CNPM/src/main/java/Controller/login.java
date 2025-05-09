package Controller;


import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAO.DAONhanVien;
import DAO.DAOTaiKhoanNhanVien;
import DAO.DBConnector;
import Model.ChucVu;
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
		            HttpSession session = req.getSession();
		            session.setAttribute("currentUser", taiKhoanNhanVien);
		            DAONhanVien daoNhanVien = new DAONhanVien(conn);
		            daoNhanVien.findNVbyID(String.valueOf(taiKhoanNhanVien.getID_Employee())).getPosition().toString();
		            if(daoNhanVien.findNVbyID(String.valueOf(taiKhoanNhanVien.getID_Employee())).getPosition()==ChucVu.Manager) {
		            	try {
							conn.close();
							conn = DBConnector.getConnectionForLogin(taiKhoanNhanVien.getUserAccount(), taiKhoanNhanVien.getPassword());
			                resp.sendRedirect(req.getContextPath() + "/1.sidebar.html");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						try {
							conn.close();
							conn = DBConnector.getConnectionForLogin(taiKhoanNhanVien.getUserAccount(), taiKhoanNhanVien.getPassword());
							resp.sendRedirect(req.getContextPath() + "/TKNV_sidebar.html");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		        } else {
		            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
		            req.getRequestDispatcher("/0.login.html").forward(req, resp);
		        }
		} catch (Exception e) {
		      throw new RuntimeException(e);
		}
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/0.login.html").forward(req, resp);
    }
}
