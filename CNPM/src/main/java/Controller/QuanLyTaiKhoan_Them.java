package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAONhanVien;
import DAO.DAOTaiKhoanNhanVien;
import Model.ChucVu;
import Model.NhanVien;

@WebServlet("/QuanLyTaiKhoanThem")
public class QuanLyTaiKhoan_Them extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOTaiKhoanNhanVien DAOTK;
	private DAONhanVien DAONV;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("employeeName");
		String email = req.getParameter("email");
		String SDT = req.getParameter("phone");
		ChucVu cv = req.getParameter("position").equalsIgnoreCase("Quản lý")?ChucVu.Manager:ChucVu.Employee;
		NhanVien nv = new NhanVien(0, name, email, SDT, cv);
		DAONV.add(nv);
		String account = req.getParameter("username");
		String password = req.getParameter("password");
		int warehouse = Integer.parseInt(req.getParameter("warehouse"));
		
	}
}
