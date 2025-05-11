package Model;

public enum ChucVu {
	Manager("Quan Ly"), Employee("Nhan vien");
	private String description;
	ChucVu(String description){
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
}
