package Controller;

import java.io.IOException;
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

@WebServlet("/QuanLyTaiKhoanSua")
public class QuanLyTaiKhoanSua extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOTaiKhoanNhanVien DAOTK = new DAOTaiKhoanNhanVien(DBConnector.conn);
	private DAONhanVien DAONV = new DAONhanVien(DBConnector.conn);
	private DAOKho DAOK = new DAOKho(DBConnector.conn);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selected = req.getParameter("selectedAccount");
		if (selected != null && !selected.equals("null") && !selected.isEmpty()) {
			TaiKhoanNhanVien tk = DAOTK.findByAccountID(Integer.parseInt(selected));
			NhanVien nv = DAONV.findNVbyID(tk.getID_Employee());
			List<Kho> listKho = DAOK.findAll();
			req.setAttribute("lstKho", listKho);
			req.setAttribute("tk", tk);
			req.setAttribute("Kho", Kho.class);
			req.setAttribute("nv", nv);
	        req.getRequestDispatcher("12.account-suatk.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("error", "Chọn tài khoản để sửa!");
	        req.getRequestDispatcher("QuanLyTaiKhoan").forward(req, resp);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
