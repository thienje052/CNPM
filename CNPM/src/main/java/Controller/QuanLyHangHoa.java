package Controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

import DAO.DBConnector;
import DAO.DAOLoaiHang;
import Model.LoaiHang;

@WebServlet("/3.QLHH-DMHH")
public class QuanLyHangHoa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String action = req.getParameter("action");     // "them", "sua", "xoa"
        String ID = req.getParameter("maLoai");
        String Name = req.getParameter("tenLoai");
        String message = "";

        try (Connection conn = DBConnector.getConnection()) {
            DAOLoaiHang dao = new DAOLoaiHang(conn);

            int maLoai;
            try {
                maLoai = Integer.parseInt(ID);
            } catch (NumberFormatException e) {
                message = "Mã loại phải là số nguyên.";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/webapp/html/3.QLHH-DMHH.html").forward(req, resp);
                return;
            }

            switch (action) {
            case "them":
                if (dao.them(new LoaiHang(maLoai, Name))) {
                    message = "Đã thêm loại hàng.";
                } else {
                    message = "Không thể thêm. Có thể Mã loại đã tồn tại.";
                }
                break;
            case "sua":
                if (dao.sua(new LoaiHang(maLoai, Name))) {
                    message = "Đã cập nhật loại hàng.";
                } else {
                    message = "Không thể sửa. Kiểm tra lại Mã loại.";
                }
                break;
            case "xoa":
                if (dao.xoa(maLoai)) {
                    message = "Đã xóa loại hàng.";
                } else {
                    message = "Không tìm thấy Mã loại cần xóa.";
                }
                break;
            default:
                message = "Hành động không hợp lệ.";
        }
            req.setAttribute("dsLoaiHang", dao.getAll());  // Lấy danh sách mới

    } catch (SQLException e) {
        message = "Lỗi SQL: " + e.getMessage();
    }
        


        //phần này chưa biết cách để nó hiện lên html
        req.setAttribute("message", message);
        RequestDispatcher rd = req.getRequestDispatcher("/webapp/html/3.QLHH-DMHH.html");
        rd.forward(req, resp);
    }
}
