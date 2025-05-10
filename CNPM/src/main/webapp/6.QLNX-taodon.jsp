<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">

<head>
  <meta charset="UTF-8">
  <title>Quản lý nhập/xuất - Tạo đơn</title>
  <link rel="stylesheet" href="./css/6.QLNX-taodon.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

  <header>Quản lý nhập/xuất - Tạo đơn</header>

  <form action="XuLyPhieu" method="POST">

    <!-- Hàng 1 -->
    <div class="row">
      <div class="form-group">
        <label for="loaiDon">Loại đơn</label>
        <select id="loaiDon" name="loaiDon">
          <option value="Nhập" ${param.loaiDon == 'Nhập' ? 'selected' : ''}>Nhập</option>
          <option value="Xuất" ${param.loaiDon == 'Xuất' ? 'selected' : ''}>Xuất</option>
        </select>
      </div>
      <div class="form-group">
        <label for="maDoiTac">Mã đối tác</label>
        <input type="text" id="maDoiTac" name="maDoiTac"  value="${param.maDoiTac}" />
      </div>
      <div class="form-group">
        <label for="ngay">Ngày</label>
        <input type="date" id="ngay" name="ngay"  value="${param.ngay}" />
      </div>
    </div>

    <!-- Hàng 2 -->
    <div class="row">
      <div class="form-group">
        <label for="maHang">Mã hàng</label>
        <input type="text" id="maHang" name="maHang"  value="${param.maHang}" />
      </div>
      <div class="form-group">
        <label for="tenHang">Tên hàng</label>
        <input type="text" id="tenHang" name="tenHang"  value="${param.tenHang}" />
      </div>
      <div class="form-group">
        <label for="loaiHang">Loại hàng</label>
        <input type="text" id="loaiHang" name="loaiHang"  value="${param.loaiHang}" />
      </div>
      <div class="form-group">
        <label for="viTri">Vị trí</label>
        <input type="text" id="viTri" name="viTri"  value="${param.viTri}" />
      </div>
    </div>

    <!-- Hàng 3 -->
    <div class="row">
      <div class="form-group">
        <label for="soLuong">Số lượng</label>
        <input type="number" id="soLuong" name="soLuong"  value="${param.soLuong}" />
      </div>
      <div class="form-group">
        <label for="donViTinh">Đơn vị tính</label>
        <input type="text" id="donViTinh" name="donViTinh"  value="${param.donViTinh}" />
      </div>
      <div class="form-group">
        <label for="moTa">Mô tả</label>
        <input type="text" id="moTa" name="moTa"  value="${param.moTa}" />
      </div>
    </div>

    <div class="action-buttons">
      <button type="submit" name="action" value="themHang">Thêm hàng</button>
      <button type="submit" name="action" value="xoaHang">Xóa hàng</button>
    </div>

    <!-- Bảng dữ liệu -->
    <table class="table table-bordered mt-4">
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
              <td><input type="radio" name="selectedMaHang" value="${hh.id}" /></td>
              <td>${hh.id}</td>
              <td>${hh.name}</td>
              <td>${hh.catagory}</td>
              <td>${hh.quantity}</td>
              <td>${hh.measurement}</td>
              <td>${hh.description}</td>
              <td>
                <c:choose>
                  <c:when test="${not empty param.viTri}">${param.viTri}</c:when>
                  <c:otherwise>${hh.vitri}</c:otherwise>
                </c:choose>
              </td>
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