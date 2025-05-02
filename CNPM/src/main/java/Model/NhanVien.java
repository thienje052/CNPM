package Model;

public class NhanVien {
	private int ID;
	private String Name;
	private String Email;
	private String SDT;
	private ChucVu Position;
	public NhanVien(int iD, String name, String email, String sDT, ChucVu position) {
		super();
		ID = iD;
		Name = name;
		Email = email;
		SDT = sDT;
		Position = position;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public ChucVu getPosition() {
		return Position;
	}
	public void setPosition(ChucVu position) {
		Position = position;
	}
}
