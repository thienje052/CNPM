package Model;

public enum LoaiPhieu {
	Export("Phiếu xuất"), Import("Phiếu nhập");
	private String description;
	LoaiPhieu(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}	
}
