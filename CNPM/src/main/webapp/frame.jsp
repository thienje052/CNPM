<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Side Bar</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/1.sidebar.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="row">
    <div class="col-2 sidebar" style="padding: 0;" id="sidebar">
      <div class="sidebar-header">
        <img src="${pageContext.request.contextPath}/image-source/User_fill.svg" alt="User avatar" />
        <div class="user-info">
          <strong>User: ${sessionScope.currentUser.userAccount}</strong><br />
          ID: ${sessionScope.currentUser.ID_Employee}
        </div>
      </div>
      <div class="menu">
        <ul>
            <li><img src="${pageContext.request.contextPath}/image-source/home-1.svg" alt="">
              <a href="${pageContext.request.contextPath}/2.trangchu.jsp" target="main-frame">Trang chủ</a>
            </li>
          <c:if test="${permissions.contains(QuyenTruyCap_HH)}">
            <li><img src="${pageContext.request.contextPath}/image-source/QLHH.svg" alt="">
              <a class="collapsible" data-bs-toggle="collapse" href="#collapseHangHoa">Quản lý hàng hóa</a>
            </li>
            <div class="collapse" id="collapseHangHoa">
              <ul>
                <li class="submenu"><a href="${pageContext.request.contextPath}/3.QLHH-DMHH.jsp" target="main-frame"> > Danh mục hàng hóa</a></li>
                <li class="submenu"><a href="${pageContext.request.contextPath}/4.QLHH-TX.jsp" target="main-frame"> > Truy xuất hàng hóa</a></li>
              </ul>
            </div>
          </c:if> 
          <c:if test="${permissions.contains(QuyenTruyCap_NXH)}">
          	<li style=''><img alt="" src="../image-source/qlnx.svg" /> 
          		<a class="collapsible" data-bs-toggle="collapse" href="#collapsenx">Quản lý nhập xuất</a></li>
				<div class="collapse" id="collapsenx" style=''>
					<ul>
						<li class="submenu"><a href="6.QLNX-taodon.html" target="main-frame"> &gt; Tạo đơn</a></li>
						<li class="submenu"><a href="7.QLNX-truyxuat.html" target="main-frame"> &gt; Truy xuất đơn</a></li>
					</ul>
				</div>
          </c:if>
          <c:if test="${permissions.contains(QuyenTruyCap_TK) }">
          	<li><img src="../image-source/STAFF.svg" alt=""><a href="11.account.html"target="main-frame">Quản lý tài khoản</a></li>
          </c:if>
          <c:if test="${permissions.contains(QuyenTruyCap_BC)}">
          	<li><img src="../image-source/BCTK.svg"alt="">
	            <a class="collapsible" data-bs-toggle="collapse" href="#collapsebchk">Báo cáo thống kê</a>
	          </li>
	          <div class="collapse" id="collapsebchk">
	            <ul>
	              <li class="submenu"><a href="8.BCTK-KLNX.html"target="main-frame"> > Khối lượng nhập xuất</a></li>
	              <li class="submenu"><a href="9.BCTK-HTK.html"target="main-frame"> > Hàng tồn kho</a></li>
	              <li class="submenu"><a href="10.BCTK-LSGD.html"target="main-frame"> > Lịch sử giao dịch</a></li>
	            </ul>
	          </div>
          </c:if>
          <c:if test="${ChucVu eq QuanLyRole}">
          	<li><img src="../image-source/doitac.svg" alt=""><a href="14.doitac.html"target="main-frame">Thông tin đối tác</a></li>
          </c:if>
          <a href="${pageContext.request.contextPath}/logout" class="menu-item dangxuat"><img src="${pageContext.request.contextPath}/image-source/logout.svg" alt="Đăng xuất"> Đăng xuất</a>
        </ul>
      </div>
    </div>
    <iframe class="col-10" name="main-frame"
      src="${pageContext.request.contextPath}/2.trangchu.jsp"
      style="flex: 1; border: none; width: 100%; height: 100vh; padding: 0;"></iframe>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
