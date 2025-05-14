package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Model.DoiTac;
import Model.LoaiPhieu;
import Model.Phieu;
import Model.TaiKhoanNhanVien;

public class DAOPhieu {
	private static Connection conn;
	
	public DAOPhieu(Connection conn) {
		DAOPhieu.conn = conn;
	}
	
	public List<Phieu> getAllPhieu() {
		List<Phieu> list = new ArrayList<Phieu>();
		try {
			String sql = "select * from Phieu";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String loaiPhieuDB = rs.getString("loaiPhieu").trim();

	            // Chuyển đổi từ mô tả sang Enum
//	            LoaiPhieu loaiPhieuEnum = null;
//	            for (LoaiPhieu lp : LoaiPhieu.values()) {
//	                if (lp.getDescription().equals(loaiPhieuDB)) {
//	                    loaiPhieuEnum = lp;
//	                    break;
//	                }
//	            }
	            
//	            if (loaiPhieuEnum == null) {
//	                System.out.println("Lỗi: Không tìm thấy enum cho giá trị " + loaiPhieuDB);
//	                continue;  // Bỏ qua nếu lỗi
	            //}
				
				list.add(new Phieu(rs.getInt("ID"), 
						rs.getInt("ID_DoiTac"), 
						rs.getInt("ID_TKNV"),
						//LoaiPhieu.Export,
						LoaiPhieu.valueOf(rs.getString("loaiPhieu")),
						rs.getTimestamp("NgayTao").toLocalDateTime()));
						//LocalDateTime.parse((CharSequence) rs.getDate("NgayNhap"))));
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Phieu> findByLoaiPhieu(LoaiPhieu phieu) {
		List<Phieu> list = new ArrayList<Phieu>();
		try {
			String sql = "select * from Phieu where loaiPhieu=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(phieu));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Phieu(rs.getInt("ID"), 
						rs.getInt("ID_DoiTac"), 
						rs.getInt("ID_TKNV"),
						LoaiPhieu.valueOf(rs.getString("loaiPhieu")),
						rs.getTimestamp("NgayTao").toLocalDateTime()));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Phieu> findByLoaiIDDoiTac(DoiTac doitac) {
		List<Phieu> list = new ArrayList<Phieu>();
		try {
			String sql = "select * from Phieu where ID_DoiTac=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, doitac.getId());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Phieu(rs.getInt("ID"), 
						rs.getInt("ID_DoiTac"), 
						rs.getInt("ID_TKNV"),
						LoaiPhieu.valueOf(rs.getString("loaiPhieu")),
						rs.getTimestamp("NgayTao").toLocalDateTime()));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Phieu> findByIDNV(TaiKhoanNhanVien account) {
		List<Phieu> list = new ArrayList<Phieu>();
		try {
			String sql = "select * from Phieu where ID_TKNV=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, account.getID_Employee());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Phieu(rs.getInt("ID"), 
						rs.getInt("ID_DoiTac"), 
						rs.getInt("ID_TKNV"),
						LoaiPhieu.valueOf(rs.getString("loaiPhieu")),
						rs.getTimestamp("NgayTao").toLocalDateTime()));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Phieu> findByIDPhieu(Phieu phieu) {
		List<Phieu> list = new ArrayList<Phieu>();
		try {
			String sql = "select * from Phieu where cast(NgayTao as Date)=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(phieu.getDateTime().toLocalDate()));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Phieu(rs.getInt("ID"), 
						rs.getInt("ID_DoiTac"), 
						rs.getInt("ID_TKNV"),
						LoaiPhieu.valueOf(rs.getString("loaiPhieu")),
						rs.getTimestamp("NgayTao").toLocalDateTime()));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean add(Phieu phieu) {
		try {
			String sql = "insert into Phieu(ID_DoiTac, ID_TKNV, NgayTao, LoaiPhieu) values (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, phieu.getID_Partner());
			pstmt.setInt(2, phieu.getID_Employee());
			pstmt.setDate(3, Date.valueOf(phieu.getDateTime().toLocalDate()));
			pstmt.setString(4, String.valueOf(phieu.getType()));
			return pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Phieu phieu) {
		try {
			String sql = "update Phieu set ID_DoiTac=?, ID_TKNV=?, NgayTao=?, LoaiPhieu=? where ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, phieu.getID_Partner());
			pstmt.setInt(2, phieu.getID_Employee());
			pstmt.setDate(3, Date.valueOf(phieu.getDateTime().toLocalDate()));
			pstmt.setString(4, String.valueOf(phieu.getType()));
			pstmt.setInt(5, phieu.getID());
			return pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(Phieu phieu) {
		try {
			String sql = "delete from Phieu where ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, phieu.getID());
			return pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
