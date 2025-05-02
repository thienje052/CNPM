package Model;

public class TaiKhoanNhanVien {
	private int ID;
	private String UserAccount;
	private String Password;
	private QuyenTruyCap Roles;
	private int ID_Employee;
	private int ID_Warehouse;
	public TaiKhoanNhanVien(int iD, String userAccount, String password, QuyenTruyCap roles, int iD_Employee,
			int iD_Warehouse) {
		super();
		ID = iD;
		UserAccount = userAccount;
		Password = password;
		Roles = roles;
		ID_Employee = iD_Employee;
		ID_Warehouse = iD_Warehouse;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserAccount() {
		return UserAccount;
	}
	public void setUserAccount(String userAccount) {
		UserAccount = userAccount;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public QuyenTruyCap getRoles() {
		return Roles;
	}
	public void setRoles(QuyenTruyCap roles) {
		Roles = roles;
	}
	public int getID_Employee() {
		return ID_Employee;
	}
	public void setID_Employee(int iD_Employee) {
		ID_Employee = iD_Employee;
	}
	public int getID_Warehouse() {
		return ID_Warehouse;
	}
	public void setID_Warehouse(int iD_Warehouse) {
		ID_Warehouse = iD_Warehouse;
	}
}
