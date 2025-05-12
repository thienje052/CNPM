<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Danh mục hàng hóa</title>
<link rel="stylesheet" href="./css/main.css">

</head>
<body>
	<div class="header">Quản lý hàng hóa - Danh mục hàng hóa</div>


	<form class="xulydanhmuc" action="DanhMucHangHoa" method="POST">
		<div class="form-top">
			<div class="foam-group">
				<label for="maLoai">Mã loại</label> <input type="text" id="maLoai"
					name="maLoai">
			</div>
			<div class="foam-group">
				<label for="tenLoai">Tên loại</label> <input type="text"
					id="tenLoai" name="tenLoai">
			</div>
			<div class="fom-buttons">
				<button type="submit" name="action" value="them">Thêm</button>
				<button type="submit" name="action" value="xoa">Xóa</button>
				<button type="submit" name="action" value="sua">Sửa</button>
			</div>
			<c:if test="${not empty xacNhanXoa}">
			    <form action="DanhMucHangHoa" method="post" style="border: 1px solid gray; padding: 10px; margin: 10px 0;">
			        <p>Bạn có chắc chắn muốn xóa loại hàng có mã: <strong>${xacNhanXoa}</strong> không?</p>
        			<input type="hidden" name="chonMaLoai" value="${xacNhanXoa}">
       				<input type="hidden" name="action" value="xoa">
        			<input type="hidden" name="xacNhan" value="true">
        			<button type="submit">Xác nhận xóa</button>
        			<a href="DanhMucHangHoa">Hủy</a>
        		</form>
        	</c:if>
		</div>

		<table>
			<thead>
				<tr>
					<th>Chọn</th>
					<th>Mã loại</th>
					<th>Tên loại</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="loai" items="${dslh}">
					<tr>
						<td><input type="radio" name="chonMaLoai" value="${loai.id}"></td>
						<td>${loai.id}</td>
						<td>${loai.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
