<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Quản lý tài khoản</title>
    <link rel="stylesheet" href="./css/11.account.css" />
</head>
<body>

  <div class="header">Quản lý tài khoản</div>

  <div class="container">

    <!-- FORM INPUT -->
    <div class="form-row">
      <div class="form-group">
        <label for="accountId">Mã tài khoản</label>
        <input type="text" id="accountId" name="accountId">
      </div>

      <div class="form-group">
        <label for="employeeId">Mã nhân viên</label>
        <input type="text" id="employeeId" name="employeeId">
      </div>

      <div class="form-group">
        <label for="employeeName">Tên nhân viên</label>
        <input type="text" id="employeeName" name="employeeName">
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
      </div>

      <div class="button-group">
        <a href="13.account-themtk.jsp" class="button">Thêm</a>
        <a href="/xoa-tai-khoan" class="button">Xóa</a>
        <a href="12.account-suatk.html" class="button">Sửa</a>
      </div>
    </div>

    <!-- BẢNG TÀI KHOẢN -->
    <table>
      <thead>
        <tr>
          <th>Mã tài khoản</th>
          <th>Mã nhân viên</th>
          <th>Tên nhân viên</th>
          <th>Tên tài khoản</th>
          <th>Mật khẩu</th>
          <th>Email</th>
          <th>Kho phụ trách</th>
          <th>Quyền truy cập</th>
        </tr>
      </thead>
      <tbody>
        <tr><td colspan="8">Không có dữ liệu</td></tr>
      </tbody>
    </table>

  </div>
</body>
</html>
