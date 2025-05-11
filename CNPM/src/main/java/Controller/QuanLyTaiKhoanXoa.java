package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] selectedParams = req.getParameterValues("selectedItems");

	    if (selectedParams != null) {
	        List<Integer> selectedList = new ArrayList<Integer>();

	        // Chuyển đổi từ String sang Integer
	        for (String item : selectedParams) {
	            try {
	                selectedList.add(Integer.parseInt(item)); // Chuyển từ String sang int
	            } catch (NumberFormatException e) {
	                System.out.println("Lỗi định dạng số: " + item);
	            }
	        }

	        // Gửi danh sách về JSP để hiển thị
	        req.setAttribute("selectedList", selectedList);
	        req.getRequestDispatcher("DanhSach.jsp").forward(req, resp);
	    } else {
	        System.out.println("Không có dữ liệu được chọn!");
	        resp.sendRedirect("DanhSach.jsp");
	    }
	}
}
