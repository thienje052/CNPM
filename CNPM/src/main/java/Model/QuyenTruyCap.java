package Model;

public enum QuyenTruyCap {
	NXH("Quan ly nhap/xuat"), TK("Quan ly tai khoan"), HH("Quan ly hang hoa"), BC("Quan ly thong ke");
	private String description;
	QuyenTruyCap(String description) {
		this.description = description;
	}
	public static QuyenTruyCap fromString(String value) {
        try {
            return QuyenTruyCap.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
