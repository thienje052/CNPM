package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAODoiTac;
import DAO.DBConnector;
import Model.DoiTac;
import Model.LoaiHang;

@WebServlet("/doiTac")
public class XoaDoiTac extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAODoiTac dAODoiTac = new DAODoiTac(DBConnector.conn);
	
	private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<DoiTac> dsDoiTac = dAODoiTac.getAll();
		req.setAttribute("dsDoiTac", dsDoiTac);
		req.getRequestDispatcher("/14.doitac.jsp").forward(req, resp);
	}
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            hienThiDanhSach(req, resp);
            return;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	
        String action = req.getParameter("action");


        try {
        if ("xoa".equals(action)) {
        	String chonDoiTac = req.getParameter("chonDoiTac");
        	String xacNhan = req.getParameter("xacNhan");
            if (chonDoiTac != null && !chonDoiTac.isEmpty()) {
            	 if ("true".equals(xacNhan)) {
            		DoiTac dt = new DoiTac(Integer.parseInt(req.getParameter("chonDoiTac")), null, null, null);
                 	dAODoiTac.delete(dt);
                 } else {
                     req.setAttribute("xacNhanXoa", chonDoiTac);
                 }
            } else {
                req.setAttribute("error", "Vui lòng chọn đối tác cần xóa.");
            }
        }
        hienThiDanhSach(req, resp);
       }catch (Exception e) {
           req.setAttribute("error", "Lỗi: " + e.getMessage());
           hienThiDanhSach(req, resp);
       }
    }
}
