package Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOChiTietPhieu;
import DAO.DAOPhieu;
import DAO.DBConnector;
import Model.Phieu;

/**
 * Servlet implementation class ThongKeXuat
 */
@WebServlet("/ThongKeXuat")
public class ThongKeXuat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DAOPhieu daoPhieu = new DAOPhieu(DBConnector.conn);
	private DAOChiTietPhieu daoChiTietPhieu = new DAOChiTietPhieu(DBConnector.conn);
       
    public ThongKeXuat() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/8.BCTK-KLNX.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int thang = Integer.parseInt(request.getParameter("thang"));
        int nam = Integer.parseInt(request.getParameter("nam"));
        List<Phieu> danhSachPhieuXuat = daoPhieu.findExportByDate(thang, nam);
        Map<Integer, String> maHangMap = daoChiTietPhieu.getMaHangTheoPhieu(danhSachPhieuXuat);

        request.setAttribute("dsXuat", danhSachPhieuXuat);
        request.setAttribute("mapMaHang", maHangMap);
        request.setAttribute("tongDonXuat", danhSachPhieuXuat.size());

        request.getRequestDispatcher("/8.BCTK-KLNX.jsp").forward(request, response);
	}

}
