package Model;

public class DoiTac {
	private int ID;
	private String Name;
	private String Email;
	private String PhoneNumber;
	public DoiTac(int iD, String name, String email, String phoneNumber) {
		super();
		ID = iD;
		Name = name;
		Email = email;
		PhoneNumber = phoneNumber;
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
}
