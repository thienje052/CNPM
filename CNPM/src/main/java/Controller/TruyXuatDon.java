package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;
import DAO.DAODonHang;
import Model.Phieu;
import java.io.IOException;
import java.time.LocalDateTime;
import java.sql.*;

@WebServlet("/truyxuat")
public class TruyXuatDon extends HttpServlet {
    //private static final long serialVersionUID = 1L;
	private DAODonHang donHangDAO;

    public void init() {
        donHangDAO = new DAODonHang();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Nhận dữ liệu từ form
        String loaiDon = request.getParameter("loaiDon");
        String maDoiTac = request.getParameter("maDoiTac");
        String ngay = request.getParameter("ngay");
        String maDon = request.getParameter("maDon");
        String maNhanVien = request.getParameter("maNhanVien");

        // Truy xuất danh sách đơn hàng phù hợp
        List<Phieu> danhSachDonHang = donHangDAO.timKiemDonHang(loaiDon, maDoiTac, ngay, maDon, maNhanVien);
        request.setAttribute("donHangs", danhSachDonHang);

        // Chuyển hướng sang giao diện JSP để hiển thị kết quả
        RequestDispatcher dispatcher = request.getRequestDispatcher("ketqua.jsp");
        dispatcher.forward(request, response);
    }
}