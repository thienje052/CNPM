package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.sql.*;

import Model.LoaiPhieu;
import Model.Phieu;
import DAO.DAOPhieu;
import DAO.DBConnector;

@WebServlet("/XuLyPhieu")
public class XuLyPhieu extends HttpServlet {
	
	private DAOPhieu phieudao;
	@Override
    public void init() {
        try {
            Connection conn = DBConnector.getConnection();
<<<<<<< HEAD
            DAOPhieu = new DAOPhieu(conn);
=======
            phieudao = new PhieuDaoImpl(conn);
>>>>>>> branch 'main' of https://github.com/thienje052/CNPM
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            int idPartner = Integer.parseInt(req.getParameter("id_partner"));
            int idEmployee = Integer.parseInt(req.getParameter("id_employee"));
            LoaiPhieu type = LoaiPhieu.valueOf(req.getParameter("type"));
            LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("datetime"));

            Phieu phieu = new Phieu(id, idPartner, idEmployee, type, dateTime);

           

            req.setAttribute("message", "Tạo phiếu thành công!");
        } catch (Exception e) {
            req.setAttribute("error", "Lỗi khi tạo phiếu: " + e.getMessage());
        }
        req.getRequestDispatcher("/WEB-INF/tao_phieu.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/tao_phieu.jsp").forward(req, resp);
    }
}

