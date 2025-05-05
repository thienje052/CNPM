package Model;

import java.util.List;

public class TaiKhoanQuanLy extends TaiKhoanNhanVien {
	private List<Integer> ManagingID;
	public TaiKhoanQuanLy(int iD, String userAccount, String password, List<QuyenTruyCap> roles, int iD_Employee,
			int iD_Warehouse) {
		super(iD, userAccount, password, roles, iD_Employee, iD_Warehouse);
		ManagingID = null;
	}
	public List<Integer> getManagingID() {
		return ManagingID;
	}
	public void setManagingID(List<Integer> managingID) {
		ManagingID = managingID;
	}
}
