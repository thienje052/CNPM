&lt;%@ page session="true" import="java.util.*" %&gt;
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<title>Side bar</title>
<link href="../css/1.sidebar.css" rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<style>
#sub-frame-error {
	display: none;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col-2 sidebar" id="sidebar" style="padding: 0">
			<div class="sidebar-header">
				<img alt="User avatar" src="../image-source/User_fill.svg" />
				<div class="user-info">
					<strong>User: Sora</strong><br /> ID: 123456789
				</div>
			</div>
			<div class="menu">
				<ul>
					<li><img alt="" src="../image-source/home-1.svg" /><a
						href="2.trangchu.html" target="main-frame">Trang chủ</a></li>
					<li style=''><img alt="" src="../image-source/QLHH.svg" /> <a
						class="collapsible" data-bs-toggle="collapse"
						href="#collapseHangHoa">Quản lý hàng hóa</a></li>
					<div class="collapse" id="collapseHangHoa" style=''>
						<ul>
							<li class="submenu"><a href="3.QLHH-DMHH.html"
								target="main-frame"> &gt; Danh mục hàng hóa</a></li>
							<li class="submenu"><a href="4.QLHH-TX.html"
								target="main-frame"> &gt; Truy xuất hàng hóa</a></li>
						</ul>
					</div>
					<li style=''><img alt="" src="../image-source/qlnx.svg" /> <a
						class="collapsible" data-bs-toggle="collapse" href="#collapsenx">Quản
							lý nhập xuất</a></li>
					<div class="collapse" id="collapsenx" style=''>
						<ul>
							<li class="submenu"><a href="6.QLNX-taodon.html"
								target="main-frame"> &gt; Tạo đơn</a></li>
							<li class="submenu"><a href="7.QLNX-truyxuat.html"
								target="main-frame"> &gt; Truy xuất đơn</a></li>
						</ul>
					</div>
					<li style=''>&gt; <img alt="" src="../image-source/BCTK.svg" />
						<a class="collapsible" data-bs-toggle="collapse"
						href="#collapsebchk">Báo cáo thống kê</a>
					</li>
					<div class="collapse" id="collapsebchk" style=''>
						<ul>
							<li class="submenu"><a href="8.BCTK-KLNX.html"
								target="main-frame"> &gt; Khối lượng nhập xuất</a></li>
							<li class="submenu"><a href="9.BCTK-HTK.html"
								target="main-frame"> &gt; Hàng tồn kho</a></li>
							<li class="submenu"><a href="10.BCTK-LSGD.html"
								target="main-frame"> &gt; Lịch sử giao dịch</a></li>
						</ul>
					</div>
					<li style=''><img alt="" src="../image-source/STAFF.svg" /><a
						href="11.account.html" target="main-frame">Quản lý tài khoản</a></li>
					<li><img alt="" src="../image-source/doitac.svg" /><a
						href="14.doitac.html" target="main-frame">Thông tin đối tác</a></li>
				</ul>
			</div>
			<a class="menu-item dangxuat" href="#"> <img alt="Đăng xuất"
				src="../image-source/logout.svg" /> Đăng xuất
			</a>
		</div>
		<iframe class="col-10" name="main-frame" src="2.trangchu.html"
			style="flex: 1; border: none; width: 100%; height: 100vh; padding: 0"></iframe>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
