package Model;

public class Kho {
	private int ID;
	private String Address;
	private int EmptyShelves;
	private int ShelvesAmount;
	public Kho(int iD, String address, int emptyShelves, int shelvesAmount) {
		super();
		ID = iD;
		Address = address;
		EmptyShelves = emptyShelves;
		ShelvesAmount = shelvesAmount;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getEmptyShelves() {
		return EmptyShelves;
	}
	public void setEmptyShelves(int emptyShelves) {
		EmptyShelves = emptyShelves;
	}
	public int getShelvesAmount() {
		return ShelvesAmount;
	}
	public void setShelvesAmount(int shelvesAmount) {
		ShelvesAmount = shelvesAmount;
	}
	@Override
	public String toString() {
		return "Kho " + ID;
	}
}
