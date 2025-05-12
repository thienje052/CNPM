<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Thêm tài khoản</title>
    <link rel="stylesheet" href="./css/13.account-themtk.css">
</head>
<body>

  <div class="header">Quản lý tài khoản - Thêm tài khoản</div>

  <div class="container">
    <form method="POST" action="QuanLyTaiKhoanThemSubmit">
      <div class="form-column">
        <div class="form-group">
          <label for="employeeName">Tên nhân viên</label>
          <input type="text" id="employeeName" name="employeeName" required>
        </div>
        <div class="form-group">
          <label for="phone">Số điện thoại</label>
          <input type="text" id="phone" name="phone">
        </div>
        <div class="form-group">
          <label for="email">Email</label>
          <input type="email" id="email" name="email">
        </div>
        <div class="form-group">
          <label for="position">Vị trí</label>
          <select id="position" name="position">
            <option value="">-- Chọn vị trí --</option>
            <option value="nhanvien">Nhân viên</option>
            <option value="quanly">Quản lý</option>
          </select>
        </div>
      </div>

      <div class="form-column">
        <div class="form-group">
          <label for="username">Tên đăng nhập</label>
          <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
          <label for="password">Mật khẩu</label>
          <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
          <label for="warehouse">Kho phụ trách</label>
          <select id="warehouse" name="warehouse">
			<c:if test="${empty Kho}">
			    <p>Không có dữ liệu kho.</p>
			</c:if>
			<c:forEach var="kho" items="${Kho}">
		        <option value="${kho}">${kho}</option>
		    </c:forEach>
        </select>
          </select>
        </div>
        <div class="form-group">
          <label>Quyền truy cập <span class="required">( * )</span></label>
          <div class="checkbox-group">
            <label><input type="checkbox" name="permissions[]" value="NXH"> Quản lý nhập/xuất</label>
            <label><input type="checkbox" name="permissions[]" value="HH"> Quản lý hàng hóa</label>
            <label><input type="checkbox" name="permissions[]" value="TK"> Quản lý tài khoản</label>
            <label><input type="checkbox" name="permissions[]" value="BC"> Báo cáo thống kê</label>
          </div>
        </div>
      </div>

      <div class="button-group" style="width: 100%;">
        <button type="submit" class="button-confirm">Xác nhận</button>
        <button type="button" onclick="window.history.back()" class="button-cancel">Hủy</button>
      </div>
    </form>
  </div>

</body>
</html>