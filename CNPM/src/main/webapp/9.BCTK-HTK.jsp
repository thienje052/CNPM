<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Báo cáo tồn kho</title>
    <link rel="stylesheet" href="./css/9.BCTK-HTK.css" />
</head>
<body>
  <div class="header">Báo cáo thống kê - Hàng tồn kho</div>

  <div class="section">
    <h4>Hàng tồn kho</h4>

    <!-- Bạn có thể gửi form này để lọc hàng tồn theo tháng/năm/kho nếu muốn -->
    <form action="/inventory-report" method="POST">
      <!-- Nếu cần filter theo tháng/năm/kho thì thêm select/input vào đây -->

      <table>
        <thead>
          <tr>
            <th>Mã hàng</th>
            <th>Tên hàng</th>
            <th>Số lượng</th>
            <th>Đơn vị tính</th>
            <th>Vị trí</th>
            <th>Ngày nhập</th>
          </tr>
        </thead>
        <tbody>
          <!-- Dữ liệu hàng tồn thực tế sẽ được render ở đây từ backend -->
          <tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>
          <tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>
        </tbody>
      </table>

      <!-- Nếu bạn cần gửi form để lấy dữ liệu theo điều kiện -->
      <!-- <button type="submit" class="btn-submit">Lọc hàng tồn</button> -->
    </form>
  </div>
</body>
</html>
