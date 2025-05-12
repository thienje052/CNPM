<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Quản lý tài khoản</title>
<link rel="stylesheet" href="./css/main.css" />
</head>
<body>

	<div class="header">Quản lý tài khoản</div>

	<div class="containeraccount">

		<!-- FORM INPUT -->
		<div class="faho-row">
			<div class="form-left">
				<div class="faho-group">
					<label for="accountId">Mã tài khoản</label> <input type="text"
						id="accountId" name="accountId">
				</div>

				<div class="faho-group">
					<label for="employeeId">Mã nhân viên</label> <input type="text"
						id="employeeId" name="employeeId">
				</div>

				<div class="faho-group">
					<label for="employeeName">Tên nhân viên</label> <input type="text"
						id="employeeName" name="employeeName">
				</div>
			<div class="faho-group">
				<label for="warehouse">Kho phụ trách</label> <select id="warehouse"
					name="warehouse">
					<option value="">-Chọn kho-</option>
					<c:if test="${empty Kho}">
					    <p>Không có dữ liệu kho.</p>
					</c:if>
					<c:forEach var="kho" items="${Kho}">
				        <option value="${kho.ID}">${kho.ID}</option>
				    </c:forEach>
				</select>
			</div>
		</div>
			<div class="button-group1">
				<a href="QuanLyTaiKhoanThemInterface" class="button">Thêm</a> <a
					href="/xoa-tai-khoan" class="button">Xóa</a> <a
					href="12.account-suatk.jsp" class="button">Sửa</a>
			</div>
		</div>
		<!-- BẢNG TÀI KHOẢN -->
	<table class="bangtaikhoan">
		<thead>
			<tr>
				<th>Chọn</th>
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
			<c:choose>
				<c:when test="${not empty TaiKhoan}">
					<c:forEach var="tk" items="${TaiKhoan}">
						<tr>
					        <td><input type="radio" name="selectedAccount" value="${tk.ID}" /></td>
					        <td>${tk.ID}</td>
					        
					        <!-- Tìm nhân viên phù hợp với mã nhân viên -->
					        <c:set var="matchedNV" value="" />
					        <c:forEach var="nv" items="${NhanVien}">
					            <c:if test="${nv.ID == tk.ID_Employee}">
					                <c:set var="matchedNV" value="${nv}" />
					            </c:if>
					        </c:forEach>
							<td>${tk.ID}</td>
					        <td>${matchedNV.name}</td>
					        <td>${tk.userAccount}</td>
					        <td>${tk.password}</td>
					        <td>${matchedNV.email}</td>
					        <td>${matchedNV.phoneNumber}</td>
					        <td>${tk.roles}</td>
					    </tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="9" style="text-align: center;">Không có dữ liệu</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	</div>
</body>
</html>
