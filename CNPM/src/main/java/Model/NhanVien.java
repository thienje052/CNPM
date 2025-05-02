package Model;

public class NhanVien {
	private int ID;
	private String Name;
	private String Email;
	private String PhoneNumber;
	private ChucVu Position;
	public NhanVien(int iD, String name, String email, String phoneNumber, ChucVu position) {
		super();
		ID = iD;
		Name = name;
		Email = email;
		PhoneNumber = phoneNumber;
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
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public ChucVu getPosition() {
		return Position;
	}
	public void setPosition(ChucVu position) {
		Position = position;
	}
}
