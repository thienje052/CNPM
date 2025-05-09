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
	private DAOLoaiHang daoLoaiHang;

    @Override
    public void init() throws ServletException {
        try {
            Connection conn = DBConnector.getConnectionAuth();
            daoLoaiHang = new DAOLoaiHang(conn);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<LoaiHang> dslh = daoLoaiHang.getAll();
        req.setAttribute("danhSachLoai", dslh);
        req.getRequestDispatcher("danhmucLoaiHang.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        String maLoai = req.getParameter("maLoai");
        String tenLoai = req.getParameter("tenLoai");

        if ("them".equals(action)) {
        	daoLoaiHang.add(new LoaiHang(maLoai, tenLoai));
        } else if ("xoa".equals(action)) {
        	daoLoaiHang.delete(new LoaiHang(maLoai, null));
        } else if ("sua".equals(action)) {
            req.getSession().setAttribute("maLoaiSua", maLoai);
            resp.sendRedirect("suaLoaiHang.jsp");
            return;
        }

        doGet(req, resp);
    }
}
