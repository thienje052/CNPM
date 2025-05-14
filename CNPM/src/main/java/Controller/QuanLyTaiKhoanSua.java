package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = req.getSession();
		TaiKhoanNhanVien SessionUser = (TaiKhoanNhanVien)session.getAttribute("currentUser");
		if (selected != null && !selected.equals("null") && !selected.isEmpty()) {
			if (Integer.parseInt(selected) == SessionUser.getID()) {
				req.setAttribute("error", "Không được sửa tài khoản của chính mình!");
		        req.getRequestDispatcher("QuanLyTaiKhoan").forward(req, resp);
			} else {
				TaiKhoanNhanVien tk = DAOTK.findByAccountID(Integer.parseInt(selected));
				NhanVien nv = DAONV.findNVbyID(tk.getID_Employee());
				List<Kho> listKho = DAOK.findAll();
				req.setAttribute("lstKho", listKho);
				req.setAttribute("tk", tk);
				req.setAttribute("Kho", Kho.class);
				req.setAttribute("nv", nv);
				req.setAttribute("IDAccount", selected);
		        req.getRequestDispatcher("12.account-suatk.jsp?selectedAccount=" + selected).forward(req, resp);
			}
		} else {
			req.setAttribute("error", "Chọn tài khoản để sửa!");
	        req.getRequestDispatcher("QuanLyTaiKhoan").forward(req, resp);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
