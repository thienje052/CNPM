package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAODoiTac;
import DAO.DBConnector;
import Model.DoiTac;

@WebServlet("/doiTac")
public class XoaDoiTac extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAODoiTac DAODT;

    @Override
    public void init() {
        try {
            Connection conn = DBConnector.getConnectionAuth();
            DAODT = new DAODoiTac(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
        	DoiTac dt = new DoiTac(Integer.parseInt(req.getParameter("id")), null, null, null);
            DAODT.delete(dt);
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Mã đối tác không hợp lệ.");
        }
        resp.sendRedirect(req.getContextPath() + "/webapp/doitac.html");
    }
}
