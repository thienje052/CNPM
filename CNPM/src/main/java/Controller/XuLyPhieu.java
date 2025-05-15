package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.websocket.Session;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOChiTietPhieu;
import DAO.DAODoiTac;
import DAO.DAOHangHoa;
import DAO.DAOLoaiHang;
import DAO.DAOPhieu;
import DAO.DAOViTri;
import DAO.DBConnector;
import Model.DoiTac;
import Model.HangHoa;
import Model.LoaiHang;
import Model.LoaiPhieu;
import Model.Phieu;
import Model.TaiKhoanNhanVien;
import Model.ViTri;

@WebServlet("/XuLyPhieu")
public class XuLyPhieu extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOPhieu daoPhieu = new DAOPhieu(DBConnector.conn);
    private DAOHangHoa daoHangHoa = new DAOHangHoa(DBConnector.conn);
    private DAOViTri daoViTri = new DAOViTri(DBConnector.conn);
    private DAODoiTac daoDoiTac = new DAODoiTac(DBConnector.conn);
    private DAOLoaiHang daoLoaiHang = new DAOLoaiHang(DBConnector.conn);
    private DAOChiTietPhieu daoChiTietPhieu = new DAOChiTietPhieu(DBConnector.conn);

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	String action = req.getParameter("action");
        HttpSession session = req.getSession();
        List<HangHoa> dshh = (List<HangHoa>) session.getAttribute("dshh");
        if (dshh == null) {
            dshh = new ArrayList<>();
        }
        LocalDate date;
        try {
        	 date = LocalDate.parse(req.getParameter("ngay"));
        } catch (Exception e) {
			// TODO: handle exception
        	date = LocalDate.now();
		}
        session.setAttribute("date", date);
        switch (action) {
            case "themHang":
                String ten    = req.getParameter("tenHang");
                String loai   = req.getParameter("loaiHang");
                int viTri  = Integer.parseInt(req.getParameter("viTri"));
                int soLuong   = Integer.parseInt(req.getParameter("soLuong"));
                String dvt    = req.getParameter("donViTinh");
                String moTa   = req.getParameter("moTa");
                HangHoa hh = new HangHoa( 0, ten, soLuong, dvt, moTa, loai, viTri);
                int maxId = 0;
                for (HangHoa h : dshh) {
                    if (h.getId() > maxId) maxId = h.getId();
                }
                hh.setId(maxId + 1);
                dshh.add(hh);
                session.setAttribute("dshh", dshh);
                resp.sendRedirect("XuLyPhieu");
                break;

            case "xoaHang":
                // Lấy mã hàng đã chọn qua radio button
                String selected = req.getParameter("selectedHang");
                if (selected != null && !selected.isEmpty()) {
                    int id = Integer.parseInt(selected);
                    dshh.removeIf(item -> item.getId() == id );
                    session.setAttribute("selected", selected);
                    session.setAttribute("dshh", dshh);
                } else {
                    req.setAttribute("error", "Vui lòng chọn một hàng để xóa.");
                }
                resp.sendRedirect("XuLyPhieu");
                return;

            case "xacNhan":
                try {
                    int idPartner  = Integer.parseInt(req.getParameter("maDoiTac"));
                    TaiKhoanNhanVien currentUser = (TaiKhoanNhanVien) session.getAttribute("currentUser");
                    int idEmployee = currentUser.getID();
                    LoaiPhieu type = LoaiPhieu.fromDescription((String)req.getParameter("loaiDon"));
                    
                    List<HangHoa> dsHangHoa = (List<HangHoa>) session.getAttribute("dshh");
                    List<Integer> listIDHangHoa = new ArrayList<Integer>();
                    for(HangHoa h: dsHangHoa) {
                    	int id = daoHangHoa.addAndReturnId(h);
                    	listIDHangHoa.add(id);
                    }
                    Phieu phieu = new Phieu(0, idPartner, idEmployee, type, date.atStartOfDay());
                    int idPhieu = daoPhieu.addAndReturnId(phieu);
                    
                    if (listIDHangHoa != null) {
                    	daoChiTietPhieu = new DAOChiTietPhieu(DBConnector.conn);
                    	for (Integer items: listIDHangHoa) {
                    		daoChiTietPhieu.add(idPhieu, items);
                    	}
                    }
                    session.removeAttribute("dshh");
                    resp.sendRedirect("XuLyPhieu");
                } catch (Exception ex) {
                	ex.printStackTrace();
                    req.setAttribute("error", "Lỗi khi lưu đơn: " + ex.getMessage());
                    req.getRequestDispatcher("/6.QLNX-taodon.jsp").forward(req, resp);
                }
                break;

            case "huy":
                session.removeAttribute("dshh");
                req.getRequestDispatcher("/2.trangchu.jsp").forward(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	HttpSession session = req.getSession();
    	
    	TaiKhoanNhanVien currentUser = (TaiKhoanNhanVien) session.getAttribute("currentUser");
    	int id_kho = currentUser.getID_Warehouse();
    	List<ViTri> dsViTri = daoViTri.findTrong(id_kho);
    	req.setAttribute("dsViTri", dsViTri);
    	
    	List<LoaiHang> dsLoaiHang = daoLoaiHang.getAll();
    	req.setAttribute("dsLoaiHang", dsLoaiHang);

    	List<DoiTac> dsDoiTac = daoDoiTac.getAll();
    	req.setAttribute("dsDoiTac", dsDoiTac);
    	
    	req.getRequestDispatcher("/6.QLNX-taodon.jsp").forward(req, resp);
    }
}

