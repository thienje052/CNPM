<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Báo cáo lịch sử giao dịch</title>
    <link rel="stylesheet" href="./css/10.BCTK-LSGD.css">
</head>
<body>

  <div class="header">Báo cáo thống kê - Lịch sử giao dịch</div>

  <div class="section">
    <h4>Lịch sử giao dịch</h4>
    
    <!-- FORM FILTER GỬI VỀ BACKEND -->
    <form action="/transaction-history" method="POST">
      <label for="month">Tháng</label>
      <select name="month" id="month">
        <!-- Tự động sinh từ 1-12 -->
        <script>
          for (let i = 1; i <= 12; i++) {
            document.write(`<option value="${i}" ${i === 4 ? "selected" : ""}>${i}</option>`);
          }
        </script>
        
        
        
        <script>
          for (let i = 1; i <= 12; i++) {
            document.write(`<option value="${i}" ${i === 4 ? "selected" : ""}>${i}</option>`);
          }
        </script>
      </select>

      <label for="year">Năm</label>
      <select name="year" id="year">
        <option value="2025" selected>2025</option>
        <option value="2024">2024</option>
        <option value="2023">2023</option>
        <!-- ... -->
      </select>

      <button type="submit" class="btn-submit">Submit</button>
    </form>

    <!-- BẢNG DỮ LIỆU GIAO DỊCH -->
    <table>
      <thead>
        <tr>
          <th>Mã giao dịch</th>
          <th>Ngày/giờ giao dịch</th>
          <th>Loại giao dịch</th>
          <th>Mã sản phẩm</th>
          <th>Số lượng</th>
          <th>Đơn vị tính</th>
          <th>Vị trí kho</th>
          <th>Đối tác</th>
        </tr>
      </thead>
      <tbody>
        <!-- Dữ liệu sẽ được render động từ backend -->
        <tr><td colspan="8" style="text-align: center;">Không có dữ liệu</td></tr>
      </tbody>
    </table>
  </div>
</body>
</html>
