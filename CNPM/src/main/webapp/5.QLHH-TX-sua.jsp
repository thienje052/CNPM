<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Quản lý hàng hóa</title>
  <link rel="stylesheet" href="./css/main.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  
</head>
<body>
  <div class="header">
    Quản lý hàng hóa - Sửa hàng hóa
  </div>

  <form class="xulyhanghoa" action="/xu-ly-hang-hoa" method="POST">
    <div class="foma-group">
      <label for="maHang">Mã hàng</label>
      <input type="text" id="maHang" name="maHang">
    </div>

    <div class="foma-group">
      <label for="loaiHang">Loại hàng</label>
      <select id="loaiHang" name="loaiHang">
        <option value="">-- Chọn loại hàng --</option>
        <option value="loai1">Loại 1</option>
        <option value="loai2">Loại 2</option>
      </select>
    </div>

    <div class="foma-group">
      <label for="tenHang">Tên hàng</label>
      <input type="text" id="tenHang" name="tenHang">
    </div>

    <div class="foma-group">
      <label for="viTri">Vị trí</label>
      <input type="text" id="viTri" name="viTri">
    </div>

    <div class="foma-button">
      <button type="submit">Sửa</button>
    </div>
  </form>
</body>
</html>
