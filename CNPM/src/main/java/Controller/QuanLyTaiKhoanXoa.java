package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAODSQuyenTruyCap;
import DAO.DAONhanVien;
import DAO.DAOTaiKhoanNhanVien;
import DAO.DBConnector;

@WebServlet("/QuanLyTaiKhoanXoa")
public class QuanLyTaiKhoanXoa extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOTaiKhoanNhanVien DAOTK = new DAOTaiKhoanNhanVien(DBConnector.conn);
	private DAONhanVien DAONV = new DAONhanVien(DBConnector.conn);
	private DAODSQuyenTruyCap DAOQTC = new DAODSQuyenTruyCap(DBConnector.conn);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selected = req.getParameter("selectedAccount");
        int idNV = DAOTK.findByAccountID(Integer.parseInt(selected)).getID_Employee();
	    if (selected != null && !selected.equals("null") && !selected.isEmpty()) {
	    	DAOQTC.deleteDSQuyenTruyCapbyIDNV(Integer.parseInt(selected));
	    	DAOTK.deleteUserAccount(Integer.parseInt(selected));
	    	DAONV.delete(idNV);
	        req.getRequestDispatcher("QuanLyTaiKhoan").forward(req, resp);
	    } else {
	    	req.setAttribute("error", "Chọn tài khoản để xóa!");
	        req.getRequestDispatcher("QuanLyTaiKhoan").forward(req, resp);
	    }
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
