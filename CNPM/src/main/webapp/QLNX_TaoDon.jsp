<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, Model.HangHoa" %>
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
      <div class="form-group col">
        <label for="loaiDon">Loại đơn</label>
        <select id="loaiDon" name="loaiDon" class="form-control">
          <option>Nhập</option>
          <option>Xuất</option>
        </select>
      </div>
      <div class="form-group col">
        <label for="maDoiTac">Mã đối tác</label>
        <input type="text" id="maDoiTac" name="maDoiTac" class="form-control">
      </div>
      <div class="form-group col">
        <label for="ngay">Ngày</label>
        <input type="date" id="ngay" name="ngay" class="form-control">
      </div>
    </div>

    <!-- Hàng 2 -->
    <div class="row mt-3">
      <div class="form-group col">
        <label for="maHang">Mã hàng</label>
        <input type="text" id="maHang" name="maHang" class="form-control">
      </div>
      <div class="form-group col">
        <label for="tenHang">Tên hàng</label>
        <input type="text" id="tenHang" name="tenHang" class="form-control">
      </div>
      <div class="form-group col">
        <label for="loaiHang">Loại hàng</label>
        <input type="text" id="loaiHang" name="loaiHang" class="form-control">
      </div>
      <div class="form-group col">
        <label for="viTri">Vị trí</label>
        <input type="text" id="viTri" name="viTri" class="form-control">
      </div>
    </div>

    <!-- Hàng 3 -->
    <div class="row mt-3">
      <div class="form-group col">
        <label for="soLuong">Số lượng</label>
        <input type="number" id="soLuong" name="soLuong" class="form-control">
      </div>
      <div class="form-group col">
        <label for="donViTinh">Đơn vị tính</label>
        <input type="text" id="donViTinh" name="donViTinh" class="form-control">
      </div>
      <div class="form-group col">
        <label for="moTa">Mô tả</label>
        <input type="text" id="moTa" name="moTa" class="form-control">
      </div>
    </div>

    <div class="action-buttons mt-3">
      <button type="submit" name="action" value="themHang" class="btn btn-primary">Thêm hàng</button>
      <button type="submit" name="action" value="xoaHang" class="btn btn-danger">Xóa hàng</button>
    </div>

    <!-- Bảng dữ liệu -->
    <table class="table table-bordered mt-4">
      <thead>
        <tr>
          <th></th>
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
        <%
          List<HangHoa> cart = (List<HangHoa>) session.getAttribute("cart");
          if (cart != null) {
            for (HangHoa hh : cart) {
        %>
        <tr>
          <td><input type="radio" name="selectedMaHang" value="<%= hh.getID() %>"></td>
          <td><%= hh.getID() %></td>
          <td><%= hh.getName() %></td>
          <td><%= hh.getCatagory() %></td>
          <td><%= hh.getQuantity() %></td>
          <td><%= hh.getMeasurement() %></td>
          <td><%= hh.getDescription() %></td>
          <td><%= request.getParameter("viTri") != null ? request.getParameter("viTri") : hh.getDescription() %></td>
        </tr>
        <%
            }
          }
        %>
      </tbody>
    </table>

    <div class="footer-buttons mt-3">
      <button type="submit" name="action" value="xacNhan" class="btn btn-success">Xác nhận</button>
      <button type="submit" name="action" value="huy" class="btn btn-secondary">Hủy</button>
    </div>
  </form>
</body>

</html>