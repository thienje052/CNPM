package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

import DAO.DAOLoaiHang;
import DAO.DBConnector;
import Model.LoaiHang;

@WebServlet("/SuaLoaiHang")
public class SuaLoaiHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOLoaiHang daoLoaiHang = new DAOLoaiHang(DBConnector.conn);
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String maLoai = (String) session.getAttribute("maLoaiSua");
		LoaiHang loai = daoLoaiHang.findByID(new LoaiHang(maLoai, null));
	    req.setAttribute("loaiHang", loai);
	    req.getRequestDispatcher("/3_1.QLHH-DMHH-sua.jsp").forward(req, resp);
	}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        String maLoai = req.getParameter("maLoai");
        String tenLoaiMoi = req.getParameter("tenLoai");
        if ("sua".equals(action)) {
        	if (tenLoaiMoi == null || tenLoaiMoi.trim().isEmpty()) {
        		req.setAttribute("error", "Tên loại hàng không được để trống.");
        		LoaiHang loaiHang = new LoaiHang(maLoai, "");
                req.setAttribute("loaiHang", loaiHang);
                req.getRequestDispatcher("/3_1.QLHH-DMHH-sua.jsp").forward(req, resp);
                return;
                }
        	LoaiHang lh = new LoaiHang(maLoai, tenLoaiMoi.trim());
            daoLoaiHang.update(lh);
            session.removeAttribute("maLoaiSua");
            resp.sendRedirect("DanhMucHangHoa");
        } else {
        	resp.sendRedirect("SuaLoaiHang");
        }
    }
}
