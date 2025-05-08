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

    @Override
    public void init() {
        try {
            Connection conn = DBConnector.getConnectionAuth();
            daoDoiTac = new DAODoiTac(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
}
