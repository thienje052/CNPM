package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAODSQuyenTruyCap;
import DAO.DAOKho;
import DAO.DAONhanVien;
import DAO.DAOTaiKhoanNhanVien;
import DAO.DBConnector;
import Model.ChucVu;
import Model.Kho;
import Model.NhanVien;
import Model.QuyenTruyCap;
import Model.TaiKhoanNhanVien;

@WebServlet("/QuanLyTaiKhoanThemSubmit")
public class QuanLyTaiKhoanThemSubmit extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOTaiKhoanNhanVien DAOTK = new DAOTaiKhoanNhanVien(DBConnector.conn);
	private DAONhanVien DAONV = new DAONhanVien(DBConnector.conn);
	private DAODSQuyenTruyCap DAOQTC = new DAODSQuyenTruyCap(DBConnector.conn);
	
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
		int employeeID = 0;
		List<NhanVien> newNV = DAONV.findNVbyName(name);
		for (NhanVien nhanVien : newNV) {
			if(employeeID == 0) {
				employeeID = nhanVien.getID();
			}
			else if (employeeID < nhanVien.getID())
				employeeID = nhanVien.getID();
		}
		String[] selectedPermissions = req.getParameterValues("permissions[]"); // Lấy danh sách quyền từ form

        List<QuyenTruyCap> permissionsList = new ArrayList<>();

        if (selectedPermissions != null) {
            for (String permission : selectedPermissions) {
                QuyenTruyCap p = QuyenTruyCap.fromString(permission);
                if (p != null) {
                    permissionsList.add(p);
                }
            }
        }
				
		int warehouse = Integer.parseInt(req.getParameter("warehouse"));
		DAOTK.addUserAccount(new TaiKhoanNhanVien(0, account, password, permissionsList, employeeID, warehouse));
		DAOQTC.addDSQuyenTruyCapbyIDNV(employeeID, permissionsList);
		req.getRequestDispatcher("QuanLyTaiKhoan").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
