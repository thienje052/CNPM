<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">

<head>
  <meta charset="UTF-8">
  <title>Quản lý đối tác - Thêm đối tác</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="./css/main.css">
</head>

<body>

  <div class="header">Quản lý đối tác - Thêm đối tác</div>

  <div class="form-containerthemsuaDT">
    <form action="themDoiTac" method="post">
      <div class="mb-3 form-group">
        <label for="partnerName" class="form-label">Tên đối tác</label>
        <input type="text" class="form-control" id="partnerName" name="name"
               value="${doiTac.Name}" required>
      </div>

      <div class="mb-3 form-group">
        <label for="phone" class="form-label">Số điện thoại</label>
        <input type="text" class="form-control" id="phone" name="phone"
               value="${doiTac.PhoneNumber}" required>
      </div>

      <div class="mb-3 form-group">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email"
               value="${doiTac.Email}" required>
      </div>

      <hr>

      <div class="text-center">
        <button type="submit" class="btn btn-primary btn-custom me-2">Xác nhận</button>
        <a href="doiTac" class="btn btn-primary btn-custom" >Hủy</a>
      </div>
    </form>
  </div>

</body>
</html>
