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


	<form class="xulydanhmuc" action="SuaLoaiHang" method="post">
		<div class="form-top">
			<div class="foam-group">
				<label for="tenLoai">Tên loại</label> 
				<input type="hidden" name="maLoai" value="${loaiHang.id}" />
				<input type="text" id="tenLoai" name="tenLoai" value="${loaiHang.name}">
			</div>
			<div class="fom-buttons">
				<button type="submit" name="action" value="sua">Sửa</button>
				<button type="button" onclick="window.history.back()" class="button-cancel">Hủy</button>
			</div>
			<div class="foam-group">
				<c:if test="${not empty error}">
        			<p style="color:red">${error}</p>
    			</c:if>	
    		</div>
		</div>
	</form>
</body>
</html>
