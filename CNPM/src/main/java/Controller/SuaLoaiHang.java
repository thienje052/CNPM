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
	private DAOLoaiHang daoLoaiHang;
	
	@Override
    public void init() throws ServletException {
        super.init();
        try {
            Connection conn = DBConnector.getConnectionAuth();
            daoLoaiHang = new DAOLoaiHang(conn);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maLoai = (String) req.getSession().getAttribute("maLoaiSua");
        if (maLoai == null) {
            resp.sendRedirect(req.getContextPath() + "/3.QLHH-DMHH.jsp");
            return;
        }
        req.getRequestDispatcher("/suaLoaiHang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        String maLoai  = req.getParameter("maLoai");

        if ("xacNhan".equals(action)) {
            String tenLoaiMoi = req.getParameter("tenLoai");
            if (maLoai != null && tenLoaiMoi != null && !tenLoaiMoi.trim().isEmpty()) {
                LoaiHang lh = new LoaiHang(maLoai, tenLoaiMoi.trim());
                boolean ok = daoLoaiHang.update(lh);
                if (!ok) {
                    req.setAttribute("error", "Cập nhật thất bại, vui lòng thử lại.");
                    req.getRequestDispatcher("/suaLoaiHang.jsp").forward(req, resp);
                    return;
                }
            }
        }
        session.removeAttribute("maLoaiSua");
        resp.sendRedirect(req.getContextPath() + "/3.QLHH-DMHH.jsp");
    }
}
