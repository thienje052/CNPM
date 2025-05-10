<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Quản lý nhập/xuất - Tạo đơn</title>
  <link rel="stylesheet" href="./css/6.QLNX-taodon.css">
</head>

<body>
  <div class="header">
    Quản lý nhập/xuất - Tạo đơn
  </div>

  <div class="form-container">
    <select name="loaiPhieu">
      <c:forEach var="lp" items="${dsLoaiPhieu}">
        <option value="${lp.id}">${lp.ten}</option>
      </c:forEach>
    </select>

    <select name="maDoiTac">
      <c:forEach var="dt" items="${dsDoiTac}">
        <option value="${dt.id}">${dt.name}</option>
      </c:forEach>
    </select>

    <input type="date" name="ngayLap" />

    <select name="maHang">
      <c:forEach var="hh" items="${dsHangHoa}">
        <option value="${hh.id}">${hh.name}</option>
      </c:forEach>
    </select>

    <select name="loaiHang">
      <c:forEach var="lh" items="${dsLoaiHang}">
        <option value="${lh.id}">${lh.name}</option>
      </c:forEach>
    </select>

    <select name="viTri">
      <c:forEach var="k" items="${dsViTri}">
        <option value="${k.id}">${k.ten}</option>
      </c:forEach>
    </select>

    <input type="text" name="tenHang" placeholder="Tên hàng" />
    <input type="number" name="soLuong" placeholder="Số lượng" />
    <input type="text" name="donViTinh" placeholder="Đơn vị tính" />
    <input type="text" name="moTa" placeholder="Mô tả" />

    <button type="submit" name="action" value="them">Thêm hàng</button>
    <button type="submit" name="action" value="xoa">Xóa hàng</button>
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
        </tr>
      </thead>
      <tbody>
        <c:forEach var="item" items="${dsHangDaThem}">
          <tr>
            <td><input type="radio" name="selectRow" /></td>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.catagory}</td>
            <td>${item.quantity}</td>
            <td>${item.measurement}</td>
            <td>${item.description}</td>
            <td>${item.viTri}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <div class="form-actions">
    <button type="submit" name="action" value="xacnhan">Xác nhận</button>
    <button type="reset">Hủy</button>
  </div>
</body>
</html>