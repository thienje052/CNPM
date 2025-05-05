package Controller;


import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAO.DAOTaiKhoanNhanVien;
import DAO.DBConnector;
import Model.TaiKhoanNhanVien;

@WebServlet("/login")
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AuthLogin authLogin;

    @Override
    public void init() {
        // Khởi tạo kết nối DB và service
        try {
            Connection conn = DBConnector.getConnection();
            authLogin = new AuthLogin(new DAOTaiKhoanNhanVien(conn));
            System.out.println("Kết nối thành công");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        TaiKhoanNhanVien taiKhoanNhanVien = authLogin.authenticate(username, password);
        if (taiKhoanNhanVien != null) {
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", taiKhoanNhanVien);
            resp.sendRedirect(req.getContextPath() + "./homepage.html");
        } else {
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
            req.getRequestDispatcher("/WEB-INF/login.html").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }
}
