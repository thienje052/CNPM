package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOHangHoa;
import DAO.DAOPhieu;
import DAO.DAOViTri;
import DAO.DBConnector;
import Model.HangHoa;
import Model.LoaiPhieu;
import Model.Phieu;

@WebServlet("/XuLyPhieu")
public class XuLyPhieu extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOPhieu daoPhieu = new DAOPhieu(DBConnector.conn);
    private DAOHangHoa daoHangHoa = new DAOHangHoa(DBConnector.conn);
    private DAOViTri daoViTri;
    List<HangHoa> dshh;
    int MAXID = daoHangHoa.findMAXID();   
	
    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	String action = req.getParameter("action");
        HttpSession session = req.getSession();
             
        switch (action) {
            case "themHang":
            	int maHang;
            	if (MAXID == 0) {
            		maHang = 1;
                }
            	else {
            		maHang=MAXID+1;
            	}
                MAXID +=1;
                String ten    = req.getParameter("tenHang");
                String loai   = req.getParameter("loaiHang");
                String viTri  = req.getParameter("viTri");
                int soLuong   = Integer.parseInt(req.getParameter("soLuong"));
                String dvt    = req.getParameter("donViTinh");
                String moTa   = req.getParameter("moTa");
                HangHoa hh = new HangHoa(maHang, ten, soLuong, dvt, moTa, loai);
                dshh.add(hh);
                req.setAttribute("MAXID", MAXID);
                req.setAttribute("message", "Đã thêm hàng " + ten);
                req.getRequestDispatcher("/6.QLNX-taodon.jsp").forward(req, resp);
                break;

            case "xoaHang":
                // Lấy mã hàng đã chọn qua radio button
                String selected = req.getParameter("selectedHang");
                List<HangHoa> dshh = (List<HangHoa>) session.getAttribute("dshh");
                if (selected != null && !selected.isEmpty()) {
                    int id = Integer.parseInt(selected);
                    dshh.removeIf(item -> item.getId() == id );
                    session.setAttribute("selected", selected);
                    session.setAttribute("dshh", dshh);
                    MAXID -=1;
                } else {
                    req.setAttribute("error", "Vui lòng chọn một hàng để xóa.");
                }
                req.getRequestDispatcher("/6.QLNX-taodon.jsp").forward(req, resp);
                break;

            case "xacNhan":
                try {
                    int idPartner  = Integer.parseInt(req.getParameter("maDoiTac"));
                    int idEmployee = (int) session.getAttribute("currentUserId");
                    LoaiPhieu type = LoaiPhieu.valueOf(req.getParameter("loaiDon"));
                    LocalDate date = LocalDate.parse(req.getParameter("ngay"));
                    Phieu phieu = new Phieu(0, idPartner, idEmployee, type, date.atStartOfDay());

                    boolean ok = daoPhieu.add(phieu);
                    if (!ok) throw new RuntimeException("Lưu phiếu thất bại");

                    // TODO: Lưu chi tiết phiếu với DAOChiTietPhieu

                    session.removeAttribute("dshh");
                    resp.sendRedirect("danhsach-phieu?msg=success");
                } catch (Exception ex) {
                    req.setAttribute("error", "Lỗi khi lưu đơn: " + ex.getMessage());
                    req.getRequestDispatcher("/6.QLNX-taodon.jsp").forward(req, resp);
                }
                break;

            case "huy":
                session.removeAttribute("dshh");
                resp.sendRedirect("1.sidebar.html");
                break;

            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	req.getRequestDispatcher("/6.QLNX-taodon.jsp").forward(req, resp);
    }
}

