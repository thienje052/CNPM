package Controller;

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
	private DAODoiTac daoDoiTac = new DAODoiTac(DBConnector.conn);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String idParam = req.getParameter("id");
		if (idParam == null || idParam.trim().isEmpty()) {
			resp.sendRedirect("doiTac");
	      return;
		}
	
		int maDT = Integer.parseInt(idParam);
		DoiTac dt = daoDoiTac.findByID(maDT);
		req.setAttribute("dt", dt);
		req.getRequestDispatcher("/16.doitac-sua.jsp").forward(req, resp);
	}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        int maDT = Integer.parseInt(req.getParameter("id"));
        String tenDT = req.getParameter("partnerName");
        String sdt = req.getParameter("phone");
        String email = req.getParameter("email");
        
        if ("sua".equals(action)) {
        	if (tenDT == null || tenDT.trim().isEmpty() ||
        		sdt == null || sdt.trim().isEmpty() ||
        		email == null || email.trim().isEmpty()) {
        		req.setAttribute("error", "không được để trống dữ liệu.");
        		DoiTac dt = new DoiTac (maDT, "", "", "");
                req.setAttribute("dt", dt);
                req.getRequestDispatcher("/16.doitac-sua.jsp").forward(req, resp);
                return;
                }
        	DoiTac dt = new DoiTac(maDT, tenDT.trim(), sdt.trim(), email.trim());
            daoDoiTac.update(dt);
            session.removeAttribute("suaMaDT");
            resp.sendRedirect("doiTac");
        } else {
        	resp.sendRedirect("suaDoiTac");
        }
    }
}
