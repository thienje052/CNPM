<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Quản lý đối tác</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="./css/main.css">
</head>
<body>

	<div class="header">Quản lý đối tác</div>

	<form action="/delete-partner" method="POST">
		<div class="form-wrapper">
			<div class="form-group-custom">
				<label for="partnerId" class="form-label">Mã đối tác</label> <input
					type="text" class="form-control" id="partnerId" name="partnerId" />
			</div>
			<div class="form-group-custom">
				<label for="partnerName" class="form-label">Tên đối tác</label> <input
					type="text" class="form-control" id="partnerName"
					name="partnerName" />
			</div>
		</div>

		<div class="button-group">
			<a href="15.doitac-themDT.jsp" class="btn btn-primary btn-custom">Thêm</a>
			<button type="submit" class="btn btn-primary btn-custom">Xóa</button>
			<a href="16.doitac-sua.jsp" class="btn btn-primary btn-custom">Sửa</a>
		</div>
	</form>

	<div class="table-responsive px-3">
		<table class="table table-bordered">
			<thead class="table-light">
				<tr>
					<th>Chọn</th>
					<th>Mã đối tác</th>
					<th>Tên đối tác</th>
					<th>Số điện thoại</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty dsDoiTac}">
						<c:forEach var="dt" items="${dsDoiTac}">
							<tr>
								<td><input type="radio" name="chonDoiTac" value="${dt.ID}" /></td>
								<td>${dt.ID}</td>
								<td>${dt.Name}</td>
								<td>${dt.PhoneNumber}</td>
								<td>${dt.Email}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5" class="text-center">Không có dữ liệu</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>

</body>
</html>
