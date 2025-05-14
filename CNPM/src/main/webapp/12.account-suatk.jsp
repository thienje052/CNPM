<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sửa tài khoản</title>
  <link rel="stylesheet" href="./css/main.css">
</head>
<body>

  <div class="header">Quản lý tài khoản - Sửa tài khoản</div>

  <div class="containerthemsuatk">
    <form class="themsuatkform" method="POST" action="/sua-tai-khoan">

      <!-- Cột trái -->
      <div class="form1-column">
        <div class="form1-group">
          <label class="a" for="employeeName">Tên nhân viên</label>
          <input type="text" id="employeeName" name="employeeName" value="${nv.name}" required>
        </div>

        <div class="form1-group">
          <label class="a" for="phone">Số điện thoại</label>
          <input type="text" id="phone" name="phone" value="${nv.phoneNumber}">
        </div>

        <div class="form1-group">
          <label class="a" for="email">Email</label>
          <input type="email" id="email" name="email" value="${nv.email}">
        </div>

        <div class="form1-group">
          <label class="a" for="position">Vị trí</label>
          <select id="position" name="position">
            <option value="">-- Chọn vị trí --</option>
            <option value="nhanvien" ${nv.position eq 'Employee' ? 'selected="selected"' : ''}>Nhân viên</option>
			<option value="quanly" ${nv.position eq 'Manager' ? 'selected="selected"' : ''}>Quản lý</option>
          </select>
        </div>
      </div>

      <!-- Cột phải -->
      <div class="form1-column">
        <div class="form1-group">
          <label class="a" for="username">Tên đăng nhập</label>
          <input type="text" id="username" name="username" value="${tk.userAccount}" required>
        </div>

        <div class="form1-group">
          <label class="a" for="password">Mật khẩu</label>
          <input type="password" id="password" name="password" value="${tk.password}" required>
        </div>

        <div class="form1-group">
          <label class="a" for="warehouse">Kho phụ trách</label>
          <select id="warehouse" name="warehouse">
			    <option value="">-- Chọn kho --</option>
			    <c:forEach var="kho" items="${lstKho}">
			        <option value="${kho.ID}" ${kho.ID == nv.ID ? 'selected="selected"' : ''}>${kho.ID}</option>
			    </c:forEach>
			</select>
        </div>

        <div class="form1-group">
          <label class="a">Quyền truy cập <span class="required">( * )</span></label>
          <div class="checkbox-group">
            <label class="a">
			    <input type="checkbox" name="roles[]" value="nhapxuat" 
			        ${tk.roles.contains('NXH') ? 'checked="checked"' : ''}> Quản lý nhập/xuất
			</label>
			
			<label class="a">
			    <input type="checkbox" name="roles[]" value="hanghoa" 
			        ${tk.roles.contains('HH') ? 'checked="checked"' : ''}> Quản lý hàng hóa
			</label>
			
			<label class="a">
			    <input type="checkbox" name="roles[]" value="taikhoan" 
			        ${tk.roles.contains('TK') ? 'checked="checked"' : ''}> Quản lý tài khoản
			</label>
			
			<label class="a">
			    <input type="checkbox" name="roles[]" value="thongke" 
			        ${tk.roles.contains('BC') ? 'checked="checked"' : ''}> Báo cáo thống kê
			</label>
          </div>
        </div>
      </div>

      <!-- Nút hành động -->
      <div class="button-group3" style="width: 100%;">
        <button type="submit" class="button-confirm">Xác nhận</button>
        <button type="button" onclick="window.history.back()" class="button-cancel">Hủy</button>
      </div>

    </form>
  </div>

</body>
</html>
