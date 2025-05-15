<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Đăng nhập - Hệ thống kho</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/0.stylelogin.css">
</head>
<body>
	<header>
		<h1>HỆ THỐNG QUẢN LÝ NHẬP/XUẤT KHO HÀNG</h1>
	</header>

	<main class="container">
		<section class="login-box">
			<h2>ĐĂNG NHẬP</h2>
			<form action="${pageContext.request.contextPath}/login" method="post">
				<input type="text" placeholder="Tên người dùng" name="username"
					required />
				<div class="password-field">
					<input type="password" id="password" placeholder="Mật khẩu"
						name="password" required /> <img
						src="${pageContext.request.contextPath}/image-source/loginyey.svg"
						alt="Hiện mật khẩu" id="togglePassword" role="button" tabindex="0" />
				</div>

				<c:if test="${not empty error}">
					<p style="color: red;">${error}</p>
				</c:if>
				<button type="submit">Đăng nhập</button>

			</form>
		</section>
	</main>
	<footer></footer>
	<script>
  window.addEventListener('DOMContentLoaded', () => {
    const togglePassword = document.getElementById('togglePassword');
    const passwordInput = document.getElementById('password');

    if (togglePassword && passwordInput) {
      togglePassword.addEventListener('click', function () {
        const isPassword = passwordInput.type === 'password';
        passwordInput.type = isPassword ? 'text' : 'password';
        this.alt = isPassword ? 'Ẩn mật khẩu' : 'Hiện mật khẩu';
      });
    }
  });
</script>
</body>
</html>
