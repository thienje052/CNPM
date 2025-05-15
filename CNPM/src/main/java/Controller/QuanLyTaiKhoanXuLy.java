package Controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

@WebServlet("/QuanLyTaiKhoanXyLy")
public class QuanLyTaiKhoanXuLy extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOTaiKhoanNhanVien DAOTK = new DAOTaiKhoanNhanVien(DBConnector.conn);
	private DAONhanVien DAONV = new DAONhanVien(DBConnector.conn);
	private DAOKho DAOK = new DAOKho(DBConnector.conn);
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
	    } else if ("Tìm kiếm".equals(action)) {
			String accountId = req.getParameter("accountId");
			String employeeId = req.getParameter("employeeId");
			String employeeName = req.getParameter("employeeName");
			String warehouseId = req.getParameter("warehouse");
	
			// Lấy toàn bộ dữ liệu
			List<TaiKhoanNhanVien> dsTK = DAOTK.getAll();
			List<NhanVien> dsNV = DAONV.getAll();
			List<Kho> listKho = DAOK.findAll(); 
	
			// Lọc dữ liệu
			if (accountId != null && !accountId.trim().isEmpty()) {
				dsTK = dsTK.stream()
						.filter(tk -> String.valueOf(tk.getID()).contains(accountId.trim()))
						.collect(Collectors.toList());
			}
	
			if (employeeId != null && !employeeId.trim().isEmpty()) {
				dsTK = dsTK.stream()
						.filter(tk -> String.valueOf(tk.getID_Employee()).contains(employeeId.trim()))
						.collect(Collectors.toList());
			}
	
			if (employeeName != null && !employeeName.trim().isEmpty()) {
				dsTK = dsTK.stream()
						.filter(tk -> {
							for (NhanVien nv : dsNV) {
								if (nv.getID() == tk.getID_Employee() &&
									nv.getName().toLowerCase().contains(employeeName.toLowerCase())) {
									return true;
								}
							}
							return false;
						})
						.collect(Collectors.toList());
			}
	
			if (warehouseId != null && !warehouseId.trim().isEmpty()) {
				dsTK = dsTK.stream()
						.filter(tk -> String.valueOf(tk.getID_Warehouse()).equals(warehouseId.trim()))
						.collect(Collectors.toList());
			}
	
			// Gửi dữ liệu về JSP
			req.setAttribute("TaiKhoan", dsTK);
			req.setAttribute("NhanVien", dsNV);
			req.setAttribute("Kho", listKho);
			req.getRequestDispatcher("/11.account.jsp").forward(req, resp);
	    }
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
