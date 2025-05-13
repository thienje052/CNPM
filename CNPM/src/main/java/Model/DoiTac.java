package Model;

public class DoiTac {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
	public DoiTac(int id, String name, String phoneNumber, String email) {
		super();
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
	}
	public DoiTac() {
		super();
	}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
