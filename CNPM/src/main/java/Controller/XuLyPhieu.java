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
import DAO.DBConnector;
import Model.HangHoa;
import Model.LoaiPhieu;
import Model.Phieu;
@WebServlet("/XuLyPhieu")
public class XuLyPhieu extends HttpServlet {
    private DAOPhieu daoPhieu;
    private DAOHangHoa daoHangHoa;
	
	@Override
    public void init() {
        try {
            Connection conn = DBConnector.getConnectionAuth();
            daoPhieu = new DAOPhieu(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();

		List<HangHoa> dshh = (List<HangHoa>) session.getAttribute("dshh");
        if (dshh == null) {
            dshh = new ArrayList<>();
            session.setAttribute("dshh", dshh);
        }

        switch (action) {
            case "themHang":
                int maHang    = Integer.parseInt(req.getParameter("maHang"));
                String ten    = req.getParameter("tenHang");
                String loai   = req.getParameter("loaiHang");
                String viTri  = req.getParameter("viTri");
                int soLuong   = Integer.parseInt(req.getParameter("soLuong"));
                String dvt    = req.getParameter("donViTinh");
                String moTa   = req.getParameter("moTa");
                HangHoa hh = new HangHoa(maHang, ten, soLuong, dvt, moTa, loai);
                dshh.add(hh);
                req.setAttribute("message", "Đã thêm hàng " + ten);
                req.getRequestDispatcher("/QLNX_TaoDon.jsp").forward(req, resp);
                break;

            case "xoaHang":
                // Lấy mã hàng đã chọn qua radio button
                String selected = req.getParameter("selectedMaHang");
                if (selected != null && !selected.isEmpty()) {
                    int selId = Integer.parseInt(selected);
                    dshh.removeIf(item -> item.getID() == selId);
                    req.setAttribute("message", "Đã xóa mã hàng " + selId);
                } else {
                    req.setAttribute("error", "Vui lòng chọn một hàng để xóa.");
                }
                req.getRequestDispatcher("/QLNX_TaoDon.jsp").forward(req, resp);
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
                    req.getRequestDispatcher("/QLNX_TaoDon.jsp").forward(req, resp);
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
        req.getRequestDispatcher("/QLNX_TaoDon.jsp").forward(req, resp);
    }
}

