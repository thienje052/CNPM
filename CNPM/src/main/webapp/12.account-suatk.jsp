<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi"><head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sửa tài khoản</title>
<link rel="stylesheet" href="./css/main.css">
</head>
<body><div class="custom-acc-header">Quản lý tài khoản - Sửa tài khoản</div>
	<%
	    int ID = Integer.parseInt((String)request.getAttribute("IDAccount")) ;
	%>
	<div class="custom-acc-container">
		<form class="custom-acc-form" method="POST" action="QuanLyTaiKhoanSuaSubmit">
			<input type="hidden" name="ID" value="<%= ID %>">
			<div class="custom-acc-columns">
				<!-- Cột bên trái -->
				<div class="custom-acc-column">
					<div class="custom-acc-group">
						<label for="employeeName">Tên nhân viên</label> <input type="text"
							id="employeeName" name="employeeName" class="custom-acc-input"
							value="${nv.name}" required>
					</div>
					<div class="custom-acc-group">
						<label for="phone">Số điện thoại</label> <input type="text"
							id="phone" name="phone" class="custom-acc-input"
							value="${nv.phoneNumber}">
					</div>
					<div class="custom-acc-group">
						<label for="email">Email</label> <input type="email" id="email"
							name="email" class="custom-acc-input" value="${nv.email}">
					</div>
					<div class="custom-acc-group">
						<label for="position">Vị trí</label> <select id="position"
							name="position" class="custom-acc-select">
							<option value="">-- Chọn vị trí --</option>
							<option value="nhanvien"
								${nv.position eq 'Employee' ? 'selected="selected"' : ''}>Nhân
								viên</option>
							<option value="quanly"
								${nv.position eq 'Manager' ? 'selected="selected"' : ''}>Quản
								lý</option>
						</select>
					</div>
				</div>

				<!-- Cột bên phải -->
				<div class="custom-acc-column">
					<div class="custom-acc-group">
						<label for="username">Tên đăng nhập</label> <input type="text"
							id="username" name="username" class="custom-acc-input"
							value="${tk.userAccount}" required>
					</div>
					<div class="custom-acc-group">
						<label for="password">Mật khẩu</label> <input type="password"
							id="password" name="password" class="custom-acc-input"
							value="${tk.password}" required>
					</div>
					<div class="custom-acc-group">
						<label for="warehouse">Kho phụ trách</label> 
						<select id="warehouse" name="warehouse" class="custom-acc-select">
			              <option value="">-- Chọn kho --</option>
			              <c:if test="${empty Kho}">
			                <option disabled>Không có dữ liệu kho.</option>
			              </c:if>
			              <c:forEach var="kho" items="${lstKho}">
			                <option value="${kho.ID}">${kho.ID}</option>
			              </c:forEach>
			            </select>
					</div>

					<div class="custom-acc-group">
						<label>Quyền truy cập <span class="custom-acc-required">(
								* )</span></label>
						<div class="custom-acc-checkbox-grid">
							<div class="custom-acc-checkbox-col">
				                <label><input type="checkbox" name="permissions[]" value="NXH" class="custom-acc-checkbox"> Quản lý nhập/xuất</label>
				                <label><input type="checkbox" name="permissions[]" value="HH" class="custom-acc-checkbox"> Quản lý hàng hóa</label>
				              </div>
				              <div class="custom-acc-checkbox-col">
				                <label><input type="checkbox" name="permissions[]" value="TK" class="custom-acc-checkbox"> Quản lý tài khoản</label>
				                <label><input type="checkbox" name="permissions[]" value="BC" class="custom-acc-checkbox"> Báo cáo thống kê</label>
				              </div>
						</div>
					</div>
				</div>
			</div>

			<!-- Nút -->
			<div class="custom-acc-btn-group">
				<button type="submit" class="custom-acc-btn custom-acc-btn-confirm">Xác
					nhận</button>
				<button type="button" onclick="window.history.back()"
					class="custom-acc-btn custom-acc-btn-cancel">Hủy</button>
			</div>
		</form>
	</div>
</body>
</html>
