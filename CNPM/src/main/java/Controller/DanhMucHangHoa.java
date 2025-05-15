package Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import DAO.DAOLoaiHang;
import Model.LoaiHang;
import DAO.DBConnector;

@WebServlet("/DanhMucHangHoa")
public class DanhMucHangHoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOLoaiHang daoLoaiHang = new DAOLoaiHang(DBConnector.conn);

	private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<LoaiHang> dslh = daoLoaiHang.getAll();
		req.setAttribute("dslh", dslh);
		req.getRequestDispatcher("/3.QLHH-DMHH.jsp").forward(req, resp);
	}
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            // Khi lần đầu truy cập, load danh sách
            hienThiDanhSach(req, resp);
            return;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	
        String action = req.getParameter("action");
        String maLoai = req.getParameter("maLoai");
        String tenLoai = req.getParameter("tenLoai");

        try {
        if ("them".equals(action)) {
        	if(maLoai != null && !maLoai.isEmpty() && tenLoai != null && !tenLoai.isEmpty())
        		daoLoaiHang.add(new LoaiHang(maLoai, tenLoai));
        	else
        		req.setAttribute("error", "Nhập mã và tên loại cần thêm.");
        } else if ("xoa".equals(action)) {
        	String chonMaLoai = req.getParameter("chonMaLoai");
        	String xacNhan = req.getParameter("xacNhan");
            if (chonMaLoai != null && !chonMaLoai.isEmpty()) {
            	 if ("true".equals(xacNhan)) {
                     daoLoaiHang.delete(new LoaiHang(chonMaLoai, null));
                 } else {
                     req.setAttribute("xacNhanXoa", chonMaLoai);
                 }
            } else {
                req.setAttribute("error", "Vui lòng chọn một hàng để xóa.");
            }
        } else if ("sua".equals(action)) {
        	String chonMaLoai = req.getParameter("chonMaLoai");
            if (chonMaLoai != null && !chonMaLoai.isEmpty()) {
                req.getSession().setAttribute("maLoaiSua", chonMaLoai);
                resp.sendRedirect("SuaLoaiHang");
                return;
            } else {
                req.setAttribute("error", "Vui lòng chọn một hàng để sửa.");
            }
        }
        hienThiDanhSach(req, resp);
       }catch (Exception e) {
           req.setAttribute("error", "Lỗi: " + e.getMessage());
           hienThiDanhSach(req, resp);
       }
    }
}
