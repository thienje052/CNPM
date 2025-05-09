<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.*, Model.QuyenTruyCap" %>
<%
    List<QuyenTruyCap> dsQuyen = (List<QuyenTruyCap>) session.getAttribute("dsQuyen");
    boolean qlNX = false, qlTK = false, qlHH = false, qlTKK = false;

    if (dsQuyen != null) {
        for (QuyenTruyCap q : dsQuyen) {
            if (q.getRoleId() == 1) qlNX = true;
            if (q.getRoleId() == 2) qlTK = true;
            if (q.getRoleId() == 3) qlHH = true;
            if (q.getRoleId() == 4) qlTKK = true;
        }
    }
%>

<ul class="sidebar">
    <% if (qlNX) { %>
    <li><a href="6.QLNX-taodon.jsp">Quản lý nhập xuất</a></li>
    <% } %>

    <% if (qlTK) { %>
    <li><a href="11.account.jsp">Quản lý tài khoản</a></li>
    <% } %>

    <% if (qlHH) { %>
    <li><a href="3.QLHH-DMHH.jsp">Quản lý hàng hóa</a></li>
    <% } %>

    <% if (qlTKK) { %>
    <li><a href="8.BCTK-KLNX.jsp">Thống kê kho</a></li>
    <li><a href="10.BCTK-LSGD.jsp">Lịch sử giao dịch</a></li>
    <% } %>
</ul>
