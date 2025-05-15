<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Quản lý nhập/xuất kho</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/1.sidebar.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
#sub-frame-error {
	display: none;
}
</style>
</head>

<body>
	<div class="row">
		<div class="col-2 sidebar" style="padding: 0;" id="sidebar">
			<div class="sidebar-header">
				<img
					src="${pageContext.request.contextPath}/image-source/User_fill.svg"
					alt="User avatar" />
				<div class="user-info">
					<strong>User: ${sessionScope.currentUser.userAccount}</strong><br />
					ID: ${sessionScope.currentUser.ID_Employee}
				</div>
			</div>

			<div class="menu" id="menu-accordion">
				<ul>
					<li><img
						src="${pageContext.request.contextPath}/image-source/home-1.svg"
						alt=""> <a
						href="${pageContext.request.contextPath}/2.trangchu.jsp"
						target="main-frame">Trang chủ</a></li>

					<c:if test="${permissions.contains(QuyenTruyCap_HH)}">
						<li><img
							src="${pageContext.request.contextPath}/image-source/QLHH.svg"
							alt=""> <a class="collapsible" data-bs-toggle="collapse"
							href="#collapseHangHoa">Quản lý hàng hóa</a></li>
						<div class="collapse" id="collapseHangHoa"
							data-bs-parent="#menu-accordion">
							<ul>
								<li class="submenu"><a href="DanhMucHangHoa"
									target="main-frame"> > Danh mục hàng hóa</a></li>
								<li class="submenu"><a
									href="${pageContext.request.contextPath}/4.QLHH-TX.jsp"
									target="main-frame"> > Truy xuất hàng hóa</a></li>
							</ul>
						</div>
					</c:if>

					<c:if test="${permissions.contains(QuyenTruyCap_NXH)}">
						<li><img
							src="${pageContext.request.contextPath}/image-source/qlnx.svg"
							alt=""> <a class="collapsible" data-bs-toggle="collapse"
							href="#collapsenx">Quản lý nhập xuất</a></li>
						<div class="collapse" id="collapsenx"
							data-bs-parent="#menu-accordion">
							<ul>
								<li class="submenu"><a href="XuLyPhieu"
									target="main-frame"> > Tạo đơn</a></li>
								<li class="submenu"><a href="TruyXuatDon"
									target="main-frame"> > Truy xuất đơn</a></li>
							</ul>
						</div>
					</c:if>

					<c:if test="${permissions.contains(QuyenTruyCap_BC)}">
						<li><img
							src="${pageContext.request.contextPath}/image-source/BCTK.svg"
							alt=""> <a class="collapsible" data-bs-toggle="collapse"
							href="#collapsebchk">Báo cáo thống kê</a></li>
						<div class="collapse" id="collapsebchk"
							data-bs-parent="#menu-accordion">
							<ul>
								<li class="submenu"><a href="8.BCTK-KLNX.jsp"
									target="main-frame"> > Khối lượng nhập xuất</a></li>
								<li class="submenu"><a href="HangTonKho"
									target="main-frame"> > Hàng tồn kho</a></li>
								<li class="submenu"><a href="10.BCTK-LSGD.jsp"
									target="main-frame"> > Lịch sử giao dịch</a></li>
							</ul>
						</div>
					</c:if>

					<c:if test="${permissions.contains(QuyenTruyCap_TK)}">
						<li><img
							src="${pageContext.request.contextPath}/image-source/STAFF.svg"
							alt=""> <a href="QuanLyTaiKhoan" target="main-frame">Quản lý tài khoản</a></li>
					</c:if>

					<c:if test="${ChucVu eq QuanLyRole}">
						<li><img
							src="${pageContext.request.contextPath}/image-source/doitac.svg"
							alt=""> <a href="doiTac" target="main-frame">Thông tin đối tác</a></li>
					</c:if>
				</ul>
			</div>

			<a href="${pageContext.request.contextPath}/logout"
				class="menu-item dangxuat"> <img
				src="${pageContext.request.contextPath}/image-source/logout.svg"
				alt="Đăng xuất"> Đăng xuất
			</a>
		</div>

		<iframe class="col-10" name="main-frame"
			src="2.trangchu.jsp"
			style="flex: 1; border: none; width: 100%; height: 100vh; padding: 0;"></iframe>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
