package Model;

import java.util.List;

public class TaiKhoanQuanLy extends TaiKhoanNhanVien {
	private List<Integer> ManagingID;
	public TaiKhoanQuanLy(int iD, String userAccount, String password, QuyenTruyCap roles, int iD_Employee,
			int iD_Warehouse) {
		super(iD, userAccount, password, roles, iD_Employee, iD_Warehouse);
		ManagingID = null;
		// TODO Auto-generated constructor stub
	}
	public List<Integer> getManagingID() {
		return ManagingID;
	}
	public void setManagingID(List<Integer> managingID) {
		ManagingID = managingID;
	}
}
