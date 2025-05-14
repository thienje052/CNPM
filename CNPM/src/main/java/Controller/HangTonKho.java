package Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOHangHoa;
import DAO.DAOLoaiHang;
import DAO.DBConnector;
import Model.HangHoa;
import Model.LoaiHang;


@WebServlet("/HangTonKho")
public class HangTonKho extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DAOHangHoa daoHangHoa = new DAOHangHoa(DBConnector.conn);
	
    public HangTonKho() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	List<HangHoa> danhSachHangTon = daoHangHoa.getAllByTime();
    	 Map<Integer, Date> mapNgayNhap = new HashMap<>();
         for (HangHoa hang : danhSachHangTon) {
             Date ngayNhap = daoHangHoa.getNgayNhapForHang(hang.getId());
             mapNgayNhap.put(hang.getId(), ngayNhap);
         }
        request.setAttribute("dsTonKho", danhSachHangTon);
        request.setAttribute("mapNgay", mapNgayNhap);
        request.getRequestDispatcher("/9.BCTK-HTK.jsp").forward(request, response);
        
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	doGet(request, response);
    }

}
