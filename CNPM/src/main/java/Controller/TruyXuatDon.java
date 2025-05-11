package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.List;

import DAO.DAODoiTac;
import DAO.DAOPhieu;
import DAO.DBConnector;
import Model.DoiTac;
import Model.LoaiPhieu;
import Model.Phieu;
import Model.TaiKhoanNhanVien;

import java.io.IOException;
import java.time.LocalDateTime;
import java.sql.*;

@WebServlet("/TruyXuatDon")
public class TruyXuatDon extends HttpServlet {

	private DAOPhieu phieu;

    public void init() {
        try {
            Connection conn = DBConnector.getConnectionAuth();
            phieu = new DAOPhieu(conn);
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
        List<Phieu> result = phieu.getAllPhieu();
        if(result == null)
        {
        	result = new ArrayList<>();
        }

        if (loaiDon != null && !loaiDon.isEmpty()) {
            try {
                LoaiPhieu lp = LoaiPhieu.valueOf(loaiDon);
                if(result != null)
                	result.retainAll(phieu.findByLoaiPhieu(lp));
            } catch (IllegalArgumentException e) {
                // nếu không đúng enum
            }
        }

        if (maNhanVien != null && !maNhanVien.isEmpty()) {
            try {
                int idNV = Integer.parseInt(maNhanVien);
                TaiKhoanNhanVien nv = new TaiKhoanNhanVien();
                nv.setID_Employee(idNV);
                if(result != null)
                	result.retainAll(phieu.findByIDNV(nv));
            } catch (NumberFormatException e) {
                // xử lý nếu nhập sai số
            }
        }

        if (maDoiTac != null && !maDoiTac.isEmpty()) {
            try {
                int idDoiTac = Integer.parseInt(maDoiTac);
                DoiTac dt = new DoiTac();
                dt.setID(idDoiTac);
                if(result != null)
                	result.retainAll(phieu.findByLoaiIDDoiTac(dt));
            } catch (NumberFormatException e) {
                // xử lý nếu nhập sai số
            }
        }

        if (ngay != null && !ngay.isEmpty()) {
            try {
                LocalDateTime date = LocalDateTime.parse(ngay + "T00:00:00");
                Phieu p = new Phieu();
                p.setDateTime(date);
                if(result != null)
                	result.retainAll(phieu.findByIDPhieu(p));
            } catch (Exception e) {
                // định dạng sai
            }
        }

        if (maDon != null && !maDon.isEmpty()) {
            try {
                int idPhieu = Integer.parseInt(maDon);
                List<Phieu> temp = new ArrayList<>();
                for (Phieu p : result) {
                    if (p.getID() == idPhieu) {
                        temp.add(p);
                        break;
                    }
                }
                result = temp;
            } catch (NumberFormatException e) {
                // xử lý nếu sai
            }
        }

        // Chuyển hướng sang giao diện JSP để hiển thị kết quả
        request.setAttribute("dsPhieu", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/7.QLNX-truyxuat.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.getRequestDispatcher("/7.QLNX-truyxuat.jsp").forward(request, response);
    }
    
}