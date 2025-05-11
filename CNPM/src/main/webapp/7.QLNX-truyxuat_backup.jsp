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
  
  <!--<div class="search-bar">
    <input type="text" placeholder="Tìm theo mã đơn, đối tác, loại đơn..." name="keyword" />
    <button type="submit">Tìm kiếm</button>
  </div>-->
  
  <form method="post" action="TruyXuatDon">
    <div class="search-bar">
      <input type="text" name="maDon" placeholder="Mã đơn" value="${param.maDon}" onchange="this.form.submit()"/>
      <select name="loaiDon" onchange="this.form.submit()">
      <option value="Export" ${param.loaiDon == '' ? 'selected' : ''}></option>
    <option value="Export" ${param.loaiDon == 'Export' ? 'selected' : ''}>Phiếu Xuất</option>
    <option value="Import" ${param.loaiDon == 'Import' ? 'selected' : ''}>Phiếu Nhập</option>
</select>
      <input type="text" name="maNhanVien" placeholder="Mã nhân viên" value="${param.maNhanVien}" onchange="this.form.submit()"/>
      <input type="text" name="maDoiTac" placeholder="Mã đối tác" value="${param.maDoiTac}" onchange="this.form.submit()"/>
      <input type="date" name="ngay" value="${param.ngay}" onchange="this.form.submit()"/>
    </div>
  </form>
  
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
            <td>${phieu.ID}</td>
      		<td>${phieu.dateTime.toLocalDate()}</td>
      		<td>${phieu.type}</td>
      		<td>${phieu.ID_Employee}</td>
      		<td>${phieu.ID_Partner}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>