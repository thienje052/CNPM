package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOKho;
import DAO.DBConnector;
import Model.Kho;

@WebServlet("/QuanLyTaiKhoanThemInterface")
public class QuanLyTaiKhoanThemInterface extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = DBConnector.conn;
		DAOKho DAOK = new DAOKho(conn);
		List<Kho> listKho = DAOK.findAll();
		req.setAttribute("Kho", listKho);
		req.getRequestDispatcher("13.account-themtk.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
