<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản lý hàng hóa</title>
<link rel="stylesheet" href="./css/main.css">
</head>

<body>
	<div class="header">Quản lý hàng hóa - Truy xuất hàng hóa</div>

	<div class="form-container">
		<div class="input-group">
			<label class="tx" for="mahang">Mã hàng</label> <input type="text"
				id="mahang" name="mahang">
		</div>
		<div class="input-group">
			<label class="tx" for="loaihang">Loại hàng</label> <select
				id="loaihang" name="loaihang">
				<option></option>
			</select>
		</div>
		<div class="input-group">
			<label class="tx" for="tenhang">Tên hàng</label> <input type="text"
				id="tenhang" name="tenhang">
		</div>
		<div class="input-group">
			<label class="tx" for="vitri">Vị trí</label> <input type="text"
				id="vitri" name="vitri">
		</div>
		<div class="input-group">
			<label class="tx">&nbsp;</label>
			<!-- tạo khoảng trống để nút căn dòng -->
			<a href="5.QLHH-TX-sua.html"><button>Sửa</button></a>
		</div>
	</div>
	</div>

	<div class="table-container">
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
					<th>Ngày nhập</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="radio" name="selectRow" checked></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<c:forEach var="hh" items="${dsHangHoa}">
					<tr>
						<td><input type="radio" name="selectRow" /></td>
						<td>${hh.id}</td>
						<td>${hh.name}</td>
						<td>${hh.catagory}</td>
						<td>${hh.quantity}</td>
						<td>${hh.measurement}</td>
						<td>${hh.description}</td>
						<td>${hh.viTri}</td>
						<td>${hh.ngayNhap}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
