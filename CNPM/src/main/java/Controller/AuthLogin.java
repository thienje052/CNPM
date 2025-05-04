package Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import DAO.DAOTaiKhoanNhanVien;
import Model.TaiKhoanNhanVien;

public class AuthLogin {
	private final DAOTaiKhoanNhanVien DAOTaiKhoanNhanVien;

    public AuthLogin(DAOTaiKhoanNhanVien DAOTaiKhoanNhanVien) {
        this.DAOTaiKhoanNhanVien = DAOTaiKhoanNhanVien;
    }

    /*
     * Xác thực user. So sánh hash của mật khẩu gửi lên với mật khẩu lưu trong DB.
     * @param username tên đăng nhập
     * @param password mật khẩu plaintext
     * @return đối tượng User nếu thành công, null nếu không
     */
    public TaiKhoanNhanVien authenticate(String username, String password) {
        try {
            TaiKhoanNhanVien taiKhoanNhanVien = DAOTaiKhoanNhanVien.findByUsername(username);
            if (taiKhoanNhanVien != null && verifyPassword(password, taiKhoanNhanVien.getPassword())) {
                return taiKhoanNhanVien;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean verifyPassword(String password, String hash) {
        // Ví dụ dùng SHA-256 (nên dùng bcrypt/argon2 cho production)
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString().equals(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
