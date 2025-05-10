package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

import Model.DoiTac;
import DAO.DAODoiTac;
import DAO.DBConnector;

@WebServlet("/themDoiTac")
public class ThemDoiTac extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAODoiTac dAODoiTac;

    @Override
    public void init() {
        try {
            Connection conn = DBConnector.getConnectionAuth();
            dAODoiTac = new DAODoiTac(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/15.doitac-themDT.html").forward(req, resp);
    }

    // Xử lý thêm đối tác
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        DoiTac doiTac = new DoiTac(0, name, email, phone);
        dAODoiTac.add(doiTac);
        req.getRequestDispatcher("/15.doitac-themDT.html").forward(req, resp);
    }
}
