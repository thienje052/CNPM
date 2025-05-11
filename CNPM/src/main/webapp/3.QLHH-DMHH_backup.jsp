<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Danh mục hàng hóa</title>
  <link rel="stylesheet" href="./css/3.QLHH-DMHH.css">
  
</head>
<body>
  <header>
    Quản lý hàng hóa - Danh mục hàng hóa
  </header>


  <form action="/xu-ly-danh-muc" method="POST">
    <div class="form-top">
      <div class="form-group">
        <label for="maLoai">Mã loại</label>
        <input type="text" id="maLoai" name="maLoai" placeholder="Mã loại">
      </div>
      <div class="form-group">
        <label for="tenLoai">Tên loại</label>
        <input type="text" id="tenLoai" name="tenLoai" placeholder="Tên loại">
      </div>
      <div class="form-buttons">
        <button type="submit" name="action" value="them">Thêm</button>
        <button type="submit" name="action" value="xoa">Xóa</button>
        <button type="submit" name="action" value="sua">Sửa</button>
      </div>
    </div>

    <table>
      <thead>
        <tr>
          <th>Mã loại</th>
          <th>Tên loại</th>
        </tr>
      </thead>
      <tbody>
       <c:forEach var="loai" items="${dsLoaiHang}">
 		 <tr>
    		<td>${loai.ID}</td>
    		<td>${loai.Name}</td>
  		</tr>
		</c:forEach>
      </tbody>
    </table>
  </form>
</body>
</html>
