package Model;

public class HangHoa {
	private int ID;
	private String Name;
	private int Quantity;
	private String Measurement;
	private String Description;
	private String Catagory;
	public HangHoa(int iD, String name, int quantity, String measurement, String description, String catagory) {
		super();
		ID = iD;
		Name = name;
		Quantity = quantity;
		Measurement = measurement;
		Description = description;
		Catagory = catagory;
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
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getMeasurement() {
		return Measurement;
	}
	public void setMeasurement(String measurement) {
		Measurement = measurement;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCatagory() {
		return Catagory;
	}
	public void setCatagory(String catagory) {
		Catagory = catagory;
	}
}
