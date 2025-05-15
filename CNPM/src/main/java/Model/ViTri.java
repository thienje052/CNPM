package Model;

public class ViTri {
	@Override
	public String toString() {
		return "ViTri [ID=" + ID + ", Ke=" + Ke + ", Hang=" + Hang + ", Tang=" + Tang + ", ID_Warehouse=" + ID_Warehouse
				+ "]";
	}
	private int ID;
	private String Ke;
	private int Hang;
	private int Tang;
	private int ID_Warehouse;
	public ViTri(int iD, String ke, int hang, int tang, int iD_Warehouse) {
		super();
		ID = iD;
		Ke = ke;
		Hang = hang;
		Tang = tang;
		ID_Warehouse = iD_Warehouse;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getKe() {
		return Ke;
	}
	public void setKe(String ke) {
		Ke = ke;
	}
	public int getHang() {
		return Hang;
	}
	public void setHang(int hang) {
		Hang = hang;
	}
	public int getTang() {
		return Tang;
	}
	public void setTang(int tang) {
		Tang = tang;
	}
	public int getID_Warehouse() {
		return ID_Warehouse;
	}
	public void setID_Warehouse(int iD_Warehouse) {
		ID_Warehouse = iD_Warehouse;
	}
}
