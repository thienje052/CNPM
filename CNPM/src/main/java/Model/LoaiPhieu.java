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
	public static LoaiPhieu fromDescription(String desc) {
        for (LoaiPhieu lp : values()) {
            if (lp.getDescription().equals(desc)) return lp;
        }
        throw new IllegalArgumentException("Loại phiếu không hợp lệ: " + desc);
    }
}
