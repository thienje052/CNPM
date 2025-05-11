<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản lý nhập/xuất - Truy xuất đơn</title>
<link rel="stylesheet" href="./css/main.css">
</head>
<body>
	<div class="header">Quản lý nhập/xuất - Truy xuất đơn</div>
	<div class="container">

		<form method="post" action="TruyXuatDon" class="fami-form">
			<div class="fami-group">
				<label for="loaiDon">Loại đơn</label> <select id="loaiDon"
					name="loaiDon" onchange="this.form.submit()">
					<option value="">-- Chọn --</option>
					<option value="Export"
						${param.loaiDon == 'Export' ? 'selected' : ''}>Phiếu Xuất</option>
					<option value="Import"
						${param.loaiDon == 'Import' ? 'selected' : ''}>Phiếu Nhập</option>
				</select>
			</div>

			<div class="fami-group">
				<label for="maDoiTac">Mã đối tác</label> <input type="text"
					id="maDoiTac" name="maDoiTac" value="${param.maDoiTac}"
					onchange="this.form.submit()">
			</div>

			<div class="fami-group">
				<label for="ngay">Ngày</label> <input type="date" id="ngay"
					name="ngay" value="${param.ngay}" onchange="this.form.submit()">
			</div>

			<div class="fami-group">
				<label for="maDon">Mã đơn</label> <input type="text" id="maDon"
					name="maDon" value="${param.maDon}" onchange="this.form.submit()">
			</div>

			<div class="fami-group">
				<label for="maNhanVien">Mã nhân viên</label> <input type="text"
					id="maNhanVien" name="maNhanVien" value="${param.maNhanVien}"
					onchange="this.form.submit()">
			</div>
		</form>

		<table class="data-table">
			<thead>
				<tr>
					<th>Mã đơn</th>
					<th>Ngày lập</th>
					<th>Loại đơn</th>
					<th>Người lập</th>
					<th>Đối tác</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="phieu" items="${dsPhieu}">
					<tr>
						<td>${phieu.ID}</td>
						<td>${phieu.dateTime.toLocalDate()}</td>
						<td>${phieu.type}</td>
						<td>${phieu.ID_Employee}</td>
						<td>${phieu.ID_Partner}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>