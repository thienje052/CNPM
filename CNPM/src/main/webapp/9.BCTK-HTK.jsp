<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Báo cáo tồn kho</title>
<link rel="stylesheet" href="./css/main.css" />
</head>
<body>
	<div class="header">Báo cáo thống kê - Hàng tồn kho</div>

	<div class="sectionb">
		<h4>Hàng tồn kho</h4>

		<form action="/inventory-report" method="POST">
			<!-- Bạn có thể thêm bộ lọc tại đây nếu muốn -->

			<table class="bangdulieu">
				<thead>
					<tr>
						<th>Mã hàng</th>
						<th>Tên hàng</th>
						<th>Số lượng</th>
						<th>Đơn vị tính</th>
						<th>Vị trí</th>
						<th>Ngày nhập</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="hang" items="${dsTonKho}">
						<tr>
							<td>${hang.id}</td>
							<td>${hang.name}</td>
							<td>${hang.quantity}</td>
							<td>${hang.measurement}</td>
							<td>${hang.id_position}</td>
							<td>${hang.ngayNhap}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>
