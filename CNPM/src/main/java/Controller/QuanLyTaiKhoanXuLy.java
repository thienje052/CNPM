package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QuanLyTaiKhoanXyLy")
public class QuanLyTaiKhoanXuLy extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String selected = req.getParameter("selectedAccount");
		String action = req.getParameter("action");
	    if ("Thêm".equals(action)) {
	        resp.sendRedirect("QuanLyTaiKhoanThemInterface");
	    } else if ("Xóa".equals(action)) {
	    	resp.sendRedirect("QuanLyTaiKhoanXoa?selectedAccount=" + selected);
	    } else if ("Sửa".equals(action)) {
	    	resp.sendRedirect("QuanLyTaiKhoanSua?selectedAccount=" + selected);
	    }
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
