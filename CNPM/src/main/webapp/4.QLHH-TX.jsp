<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Quản lý hàng hóa</title>
  <link rel="stylesheet" href="./css/4.QLHH-TX.css">
</head>

<body>
  <div class="header">
    Quản lý hàng hóa - Truy xuất hàng hóa
  </div>

  <div class="form-container">
    <input type="text" placeholder="Mã hàng">
    <select>
      <option>Loại hàng</option>
    </select>
    <input type="text" placeholder="Tên hàng">
    <input type="text" placeholder="Vị trí">
    <a href="5.QLHH-TX-sua.jsp"><button>Sửa</button></a>
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
          <th>Ngày nhập</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="hh" items="${dsHangHoa}">
          <tr>
            <td><input type="radio" name="selectRow" /></td>
            <td>${hh.id}</td>
            <td>${hh.name}</td>
            <td>${hh.catagory}</td>
            <td>${hh.quantity}</td>
            <td>${hh.measurement}</td>
            <td>${hh.description}</td>
            <td>${hh.viTri}</td>
            <td>${hh.ngayNhap}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
