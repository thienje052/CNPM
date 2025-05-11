<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Báo cáo lịch sử giao dịch</title>
<link rel="stylesheet" href="./css/main.css">
</head>
<body>

	<div class="header">Báo cáo thống kê - Lịch sử giao dịch</div>

	<div class="sectionc">
		<h4 class="title">Lịch sử giao dịch</h4>

		<form class="LSGD" action="/transaction-history" method="POST">
			<label for="month">Tháng</label> <select name="month" id="month">
				<c:forEach begin="1" end="12" var="i">
					<option value="${i}" ${param.month == i ? "selected" : ""}>${i}</option>
				</c:forEach>
			</select> <label for="year">Năm</label> <select name="year" id="year">
				<option value="2025" ${param.year == '2025' ? 'selected' : ''}>2025</option>
				<option value="2024" ${param.year == '2024' ? 'selected' : ''}>2024</option>
				<option value="2023" ${param.year == '2023' ? 'selected' : ''}>2023</option>
			</select>

			<button type="submit" class="btn-submit">Submit</button>
		</form>
	</div>

	<table>
		<thead>
			<tr>
				<th>Mã giao dịch</th>
				<th>Ngày/giờ giao dịch</th>
				<th>Loại giao dịch</th>
				<th>Mã sản phẩm</th>
				<th>Số lượng</th>
				<th>Đơn vị tính</th>
				<th>Vị trí kho</th>
				<th>Đối tác</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty dsLichSu}">
					<c:forEach var="gd" items="${dsLichSu}">
						<tr>
							<td>${gd.maGiaoDich}</td>
							<td>${gd.ngayGio}</td>
							<td>${gd.loaiGiaoDich}</td>
							<td>${gd.maSanPham}</td>
							<td>${gd.soLuong}</td>
							<td>${gd.donViTinh}</td>
							<td>${gd.viTriKho}</td>
							<td>${gd.doiTac}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="8" style="text-align: center;">Không có dữ liệu</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>

</body>
</html>
