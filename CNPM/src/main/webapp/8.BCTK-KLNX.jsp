<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Báo cáo thống kê</title>
  <link rel="stylesheet" href="./css/main.css" />
</head>
<body>
  <div class="header">Báo cáo thống kê - Khối lượng nhập/xuất</div>

  <div class="sectiona">
    <h4>KHỐI LƯỢNG NHẬP</h4>
    <form class="fami-inline" action="/report/import" method="POST">
      <label for="thang-nhap">Tháng</label>
      <select name="thang" id="thang-nhap">
        <c:forEach begin="1" end="12" var="i">
          <option value="${i}" ${param.thang == i ? 'selected' : ''}>${i}</option>
        </c:forEach>
      </select>

      <label for="nam-nhap">Năm</label>
      <select name="nam" id="nam-nhap">
        <option>2023</option>
        <option>2024</option>
        <option ${param.nam == '2025' ? 'selected' : ''}>2025</option>
      </select>

      <button type="submit" class="btn-submita">Submit</button>
    </form>

    <table>
      <thead>
        <tr>	
          <th>Mã đơn</th>
          <th>Mã đối tác</th>
          <th>Mã nhân viên</th>
          <th>Mã hàng</th>
          <th>Loại phiếu</th>
          <th>Ngày lập</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="phieu" items="${dsNhap}">
          <tr>
            <td>${phieu.maPhieu}</td>
            <td>${phieu.doiTac}</td>
            <td>${phieu.nhanVien}</td>
            <td>${phieu.maHang}</td>
            <td>${phieu.loaiPhieu}</td>
            <td>${phieu.ngayLap}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <div class="summary">
      Tổng đơn nhập: ${tongDonNhap}<br/>
      Loại hàng: ...
    </div>
  </div>

  <div class="sectiona">
    <h4>KHỐI LƯỢNG XUẤT</h4>
    <form class="fami-inline" action="/report/export" method="POST">
      <label for="thang-xuat">Tháng</label>
      <select name="thang" id="thang-xuat">
        <c:forEach begin="1" end="12" var="i">
          <option value="${i}" ${param.thang == i ? 'selected' : ''}>${i}</option>
        </c:forEach>
      </select>

      <label for="nam-xuat">Năm</label>
      <select name="nam" id="nam-xuat">
        <option>2023</option>
        <option>2024</option>
        <option ${param.nam == '2025' ? 'selected' : ''}>2025</option>
      </select>

      <button type="submit" class="btn-submita">Submit</button>
    </form>

    <table class="bangdulieu">
      <thead>
        <tr>
          <th>Mã đơn</th>
          <th>Mã đối tác</th>
          <th>Mã nhân viên</th>
          <th>Mã hàng</th>
          <th>Loại phiếu</th>
          <th>Ngày lập</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="phieu" items="${dsXuat}">
          <tr>
            <td>${phieu.maPhieu}</td>
            <td>${phieu.doiTac}</td>
            <td>${phieu.nhanVien}</td>
            <td>${phieu.maHang}</td>
            <td>${phieu.loaiPhieu}</td>
            <td>${phieu.ngayLap}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <div class="summary">
      Tổng đơn xuất: ${tongDonXuat}<br/>
      Loại hàng: ...
    </div>
  </div>
</body>
</html>
