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


	<form class="xulydanhmuc" action="/xu-ly-danh-muc" method="POST">
		<div class="form-top">
			
			<div class="foam-group">
				<label for="tenLoai">Tên loại</label> <input type="text"
					id="tenLoai" name="tenLoai">
			</div>
			<div class="fom-buttons">
				<button type="submit" name="action" value="sua">Sửa</button>
				<button type="button" onclick="window.history.back()" class="button-cancel">Hủy</button>
				
			</div>
		</div>

		
	</form>
</body>
</html>
