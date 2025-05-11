<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8">
<title>Quản lý nhập/xuất - Tạo đơn</title>
<link rel="stylesheet" href="./css/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<div class="header">Quản lý nhập/xuất - Tạo đơn</div>

	<form class="xulytaodon" action="XuLyPhieu" method="POST">
		<div class="form-grid">

			<!-- Hàng 1 -->
			<div class="fimi-group">
				<label for="loaiDon">Loại đơn</label> <select id="loaiDon"
					name="loaiDon">
					<option value="Nhập" ${param.loaiDon == 'Nhập' ? 'selected' : ''}>Nhập</option>
					<option value="Xuất" ${param.loaiDon == 'Xuất' ? 'selected' : ''}>Xuất</option>
				</select>
			</div>


			<div class="fimi-group">
				<label for="maDoiTac">Mã đối tác</label> <input type="text"
					id="maDoiTac" name="maDoiTac" value="${param.maDoiTac}" />
			</div>

			<div class="fimi-group">
				<label for="ngay">Ngày</label> <input type="date" id="ngay"
					name="ngay" value="${param.ngay}" />
			</div>
			<div class="fimi-group">
				<label>&nbsp;</label>
				<!-- chỗ trống hoặc dùng sau nếu cần -->
			</div>
			<!-- Hàng 2 -->
			
			<div class="fimi-group">
				<label for="tenHang">Tên hàng</label> <input type="text"
					id="tenHang" name="tenHang" value="${param.tenHang}" />
			</div>
			<div class="fimi-group">
				<label for="loaiHang">Loại hàng</label> <input type="text"
					id="loaiHang" name="loaiHang" value="${param.loaiHang}" />
			</div>
			<div class="fimi-group">
				<label for="viTri">Vị trí</label> <input type="text" id="viTri"
					name="viTri" value="${param.viTri}" />
			</div>

			<!-- Hàng 3 -->

			<div class="fimi-group">
				<label for="soLuong">Số lượng</label> <input type="number"
					id="soLuong" name="soLuong" value="${param.soLuong}" />
			</div>
			<div class="fimi-group">
				<label for="donViTinh">Đơn vị tính</label> <input type="text"
					id="donViTinh" name="donViTinh" value="${param.donViTinh}" />
			</div>
			<div class="fimi-group">
				<label for="moTa">Mô tả</label> <input type="text" id="moTa"
					name="moTa" value="${param.moTa}" />
			</div>


			<div class="fimi-group buttons-cell">
				<label>&nbsp;</label>
				<div class="action-buttons">
					<button type="submit" name="action" value="themHang">Thêm
						hàng</button>
					<button type="submit" name="action" value="xoaHang">Xóa
						hàng</button>
				</div>
			</div>
		</div>

		<!-- Bảng dữ liệu -->
		<table>
			<thead>
				<tr>
					<th>Chọn</th>
					<th>Mã hàng</th>
					<th>Tên hàng</th>
					<th>Loại hàng</th>
					<th>Số lượng</th>
					<th>Đơn vị tính</th>
					<th>Mô tả</th>
					<th>Vị trí</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty sessionScope.dshh}">
					<c:forEach var="hh" items="${sessionScope.dshh}">
						<tr>
							<td><input type="radio" name="selectedHang" value="${hh.id}" /></td>
							<td>${hh.id}</td>
							<td>${hh.name}</td>
							<td>${hh.catagory}</td>
							<td>${hh.quantity}</td>
							<td>${hh.measurement}</td>
							<td>${hh.description}</td>
							<td><c:choose>
									<c:when test="${not empty param.viTri}">${param.viTri}</c:when>
									<c:otherwise></c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>

		<div class="footer-buttons">
			<button type="submit" name="action" value="xacNhan">Xác nhận</button>
			<button type="submit" name="action" value="huy">Hủy</button>
		</div>
	</form>
</body>

</html>