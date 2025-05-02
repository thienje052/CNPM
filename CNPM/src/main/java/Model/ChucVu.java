package Model;

public enum ChucVu {
	Manager("Quản lý"), Employee("Nhân viên");
	private String description;
	ChucVu(String description){
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
}
