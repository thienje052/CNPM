package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAODSQuyenTruyCap;
import DAO.DAONhanVien;
import DAO.DAOPhieu;
import DAO.DAOTaiKhoanNhanVien;
import DAO.DBConnector;
import Model.ChucVu;
import Model.NhanVien;
import Model.QuyenTruyCap;
import Model.TaiKhoanNhanVien;

/**
 * Servlet implementation class QuanLyTaiKhoanSuaSubmit
 */
@WebServlet("/QuanLyTaiKhoanSuaSubmit")
public class QuanLyTaiKhoanSuaSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOTaiKhoanNhanVien DAOTK = new DAOTaiKhoanNhanVien(DBConnector.conn);
	private DAONhanVien DAONV = new DAONhanVien(DBConnector.conn);
	private DAODSQuyenTruyCap DAOQTC = new DAODSQuyenTruyCap(DBConnector.conn);
	private DAOPhieu DAOP = new DAOPhieu(DBConnector.conn);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyTaiKhoanSuaSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int AccountId = Integer.parseInt(request.getParameter("ID"));
        TaiKhoanNhanVien account = DAOTK.findByAccountID(AccountId);
        NhanVien employee = DAONV.findNVbyID(account.getID_Employee());
        
        // Update thông tin nhân viên
        if(employee != null) {
            String name = request.getParameter("employeeName");
    		String email = request.getParameter("email");
    		String SDT = request.getParameter("phone");
    		ChucVu cv = request.getParameter("position").equalsIgnoreCase("Quản lý")?ChucVu.Manager:ChucVu.Employee;
    		NhanVien newNV = new NhanVien(employee.getID(), name, email, SDT, cv);
    		DAONV.update(newNV);
        }
        
        // Update DSQuyenTruyCap
        String[] selectedPermissions = request.getParameterValues("permissions[]");
        List<QuyenTruyCap> permissionsList = new ArrayList<>();
        if (selectedPermissions != null) {
            for (String permission : selectedPermissions) {
                QuyenTruyCap p = QuyenTruyCap.fromString(permission);
                if (p != null)
                    permissionsList.add(p);
            }
        }
        DAOQTC.deleteDSQuyenTruyCapbyIDNV(AccountId);
        DAOQTC.addDSQuyenTruyCapbyIDNV(AccountId, permissionsList);
        
        // Update tài khoản nhân viên
        int warehouse = Integer.parseInt((String)request.getParameter("warehouse"));
        String accountnew = request.getParameter("username");
		String password = request.getParameter("password");
		account.setUserAccount(accountnew);
		account.setPassword(password);
		account.setRoles(permissionsList);
		account.setID_Warehouse(warehouse);
		DAOTK.updateUserAccount(account);
		
		// Chuyển hướng
		request.getRequestDispatcher("QuanLyTaiKhoan").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
