package Model;

public enum QuyenTruyCap {
	ImportAndExport("Quản lý nhập/xuất"), AccountManagement("Quản lý tài khoản"), GoodsManagement("Quản lý hàng hóa"), Report("Báo cáo thống kê");
	private String description;
	QuyenTruyCap(String description) {
		this.description = description;
	}
}
