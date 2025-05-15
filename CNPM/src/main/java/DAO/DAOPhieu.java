package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public int countImport() {
	    int count = 0;
	    
	    String sql = "SELECT COUNT(*) FROM Phieu WHERE LoaiPhieu = 'Import'";

	    try (PreparedStatement ps = conn.prepareStatement(sql)) {


	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	
	public int countExport() {
	    int count = 0;
	    
	    String sql = "SELECT COUNT(*) FROM Phieu WHERE LoaiPhieu = 'Export'";

	    try (PreparedStatement ps = conn.prepareStatement(sql)) {


	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	
	public List<Phieu> findImportByDate(int thang, int nam) {
		List<Phieu> list = new ArrayList<>();
        String sql = "SELECT * FROM Phieu " +
                     "WHERE MONTH(NgayTao) = ? AND YEAR(NgayTao) = ? AND loaiPhieu = 'Import'";

        try (
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, thang);
            ps.setInt(2, nam);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                	String loaiPhieuDB = rs.getString("loaiPhieu").trim();
    				list.add(new Phieu(rs.getInt("ID"), 
    						rs.getInt("ID_DoiTac"), 
    						rs.getInt("ID_TKNV"),
    						LoaiPhieu.valueOf(rs.getString("loaiPhieu")),
    						rs.getTimestamp("NgayTao").toLocalDateTime()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public List<Phieu> findExportByDate(int thang, int nam) {
		List<Phieu> list = new ArrayList<>();
        String sql = "SELECT * FROM Phieu " +
                     "WHERE MONTH(NgayTao) = ? AND YEAR(NgayTao) = ? AND LoaiPhieu = 'Export'";

        try (
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, thang);
            ps.setInt(2, nam);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                	String loaiPhieuDB = rs.getString("loaiPhieu").trim();
    				list.add(new Phieu(rs.getInt("ID"), 
    						rs.getInt("ID_DoiTac"), 
    						rs.getInt("ID_TKNV"),
    						LoaiPhieu.valueOf(rs.getString("loaiPhieu")),
    						rs.getTimestamp("NgayTao").toLocalDateTime()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public int countByType(int thang, int nam, LoaiPhieu loaiPhieu) {
	    int count = 0;
	    int loaiValue = (loaiPhieu == LoaiPhieu.Import) ? 0 : 1;
	    String sql = "SELECT COUNT(*) FROM Phieu WHERE MONTH(NgayTao) = ? AND YEAR(NgayTao) = ? AND LoaiPhieu = ?";

	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, thang);
	        ps.setInt(2, nam);
	        ps.setInt(3, loaiValue);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	
	public List<Integer> getMaHang(int id_don){
		List<Integer> maHangList = new ArrayList<>(); // Danh sách chứa các mã hàng
        String sql = "SELECT ID_HangHoa FROM ChiTietPhieu WHERE ID_Phieu = ?";

        try (
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_don);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    maHangList.add(rs.getInt("ID_HangHoa")); // Thêm mã hàng vào danh sách
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return maHangList;
    
	}
	
	public List<Phieu> getAllPhieu() {
		List<Phieu> list = new ArrayList<Phieu>();
		try {
			String sql = "select * from Phieu";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				String loaiPhieuDB = rs.getString("loaiPhieu").trim();
				list.add(new Phieu(rs.getInt("ID"), 
						rs.getInt("ID_DoiTac"), 
						rs.getInt("ID_TKNV"),
						LoaiPhieu.valueOf(rs.getString("loaiPhieu")),
						rs.getTimestamp("NgayTao").toLocalDateTime()));
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
			pstmt.setString(1, String.valueOf(doitac.getId()));
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
	
	public int addAndReturnId(Phieu phieu) {
		try {
			String sql = "insert into Phieu(ID_DoiTac, NgayTao, ID_TKNV, LoaiPhieu) values (?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, phieu.getID_Partner());
			pstmt.setDate(2, Date.valueOf(phieu.getDateTime().toLocalDate()));
			pstmt.setInt(3, phieu.getID_Employee());
			pstmt.setString(4, String.valueOf(phieu.getType()));
	        int affected = pstmt.executeUpdate();
	        if (affected == 0) {
	            throw new SQLException("Tạo phiếu thất bại.");
	        }
			try (ResultSet rs = pstmt.getGeneratedKeys()){
				if (rs.next()) {
	                return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
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
