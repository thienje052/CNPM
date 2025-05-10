<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Truy xuất đơn nhập/xuất</title>
  <link rel="stylesheet" href="./css/7.QLNX-truyxuat.css">
</head>
<body>
  <div class="header">
    Truy xuất đơn nhập/xuất
  </div>

  <div class="search-bar">
    <input type="text" placeholder="Tìm theo mã đơn, đối tác, loại đơn..." name="keyword" />
    <button type="submit">Tìm kiếm</button>
  </div>

  <div class="table-container">
    <table>
      <thead>
        <tr>
          <th>Mã đơn</th>
          <th>Ngày lập</th>
          <th>Loại đơn</th>
          <th>Người lập</th>
          <th>Đối tác</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="phieu" items="${dsPhieu}">
          <tr>
            <td>${phieu.maPhieu}</td>
            <td>${phieu.ngayLap}</td>
            <td>${phieu.loaiPhieu}</td>
            <td>${phieu.nguoiLap}</td>
            <td>${phieu.doiTac}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>