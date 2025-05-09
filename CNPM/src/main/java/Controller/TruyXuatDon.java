package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;

import DAO.DAODoiTac;
import DAO.DAODonHang;
import DAO.DBConnector;
import Model.Phieu;
import java.io.IOException;
import java.time.LocalDateTime;
import java.sql.*;

@WebServlet("/TruyXuatDon")
public class TruyXuatDon extends HttpServlet {
	private DAODonHang donHangDAO;
    public void init() {
        try {
            Connection conn = DBConnector.getConnectionAuth();
            donHangDAO = new DAODonHang(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        // Nhận dữ liệu từ form
        String loaiDon = request.getParameter("loaiDon");
        String maDoiTac = request.getParameter("maDoiTac");
        String ngay = request.getParameter("ngay");
        String maDon = request.getParameter("maDon");
        String maNhanVien = request.getParameter("maNhanVien");

        // Truy xuất danh sách đơn hàng phù hợp
        List<Phieu> danhSachDonHang = donHangDAO.timKiemDonHang(loaiDon, maDoiTac, ngay, maDon, maNhanVien);
        request.setAttribute("donHang", danhSachDonHang);

        // Chuyển hướng sang giao diện JSP để hiển thị kết quả
        RequestDispatcher dispatcher = request.getRequestDispatcher("/7.QLNX-truyxuat.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.getRequestDispatcher("/7.QLNX-truyxuat.jsp").forward(request, response);
    }
    
}