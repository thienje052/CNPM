package Controller;

import java.io.IOException;
import java.sql.Connection;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAO.DAODoiTac;
import DAO.DBConnector;
import Model.DoiTac;

@WebServlet("/suaDoiTac")
public class SuaDoiTac extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAODoiTac daoDoiTac;
	private DoiTac dt;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try (Connection conn = DBConnector.getConnectionAuth()) {
        	daoDoiTac = new DAODoiTac(conn);
            DoiTac dt = daoDoiTac.findByID(id);
            request.setAttribute("doitac", dt);
            request.getRequestDispatcher("/16.doitac-sua.html").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("name");
        String email = request.getParameter("email");
        String sdt = request.getParameter("phone");

        dt = new DoiTac(id, ten, email, sdt);

        try (Connection conn = DBConnector.getConnectionAuth()) {
        	daoDoiTac = new DAODoiTac(conn);
            boolean success = daoDoiTac.update(dt);
            if (success) {
                response.sendRedirect("/14.doitac.html");
            } else {
                request.setAttribute("error", "Cập nhật thất bại!");
                request.setAttribute("doitac", dt);
                request.getRequestDispatcher("/16.doitac-sua.html").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
