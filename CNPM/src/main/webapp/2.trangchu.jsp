<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Trang chủ</title>
 <link rel="stylesheet" href="./css/2.trangchu.css">
</head>
<body>
  <div class="header">
    <h2>Trang chủ</h2>
  </div>

  <div class="dashboard">
    <div class="section don-nhap">
      <div class="section-title">Đơn nhập hôm nay</div>
      <div class="section-number">5</div>
      
    </div>
    <div class="section don-xuat">
      <div class="section-title">Đơn xuất hôm nay</div>
      <div class="section-number">4</div>
      
    </div>
  </div>

  <div class="main-content">
    <div class="box thong-bao">
      <h3>Thông báo mới</h3>
      <ul>
        <li>Cảnh báo đầy kho</li>
        <li>Thông báo lịch nghỉ</li>
      </ul>
    </div>

    <div class="box nut">
	  <form action="XuLyPhieu"><button>Tạo đơn mới</button></form>
      <form action="TruyXuatDon"><button>Truy xuất đơn</button></form>
      <form action="HangTonKho"><button>Thống kê tồn kho</button></form>
      
      
    </div>

    <div class="box so-ke-trong">
      <h3>Số kệ trống</h3>
      <div class="ke-trong">${SoKeTrong}</div>
    </div>
</div>
</body>
</html>
