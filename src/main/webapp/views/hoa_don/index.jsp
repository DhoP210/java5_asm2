<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>index</title>
</head>
<body>

<br>
<a href="/hoa-don/create">Thêm mới</a>
<table>
    <thead>
        <tr>
<%--            <th>Mã hóa đơn</th>--%>
            <th>ID nhân viên</th>
            <th>ID khách hàng</th>
            <th>Ngày mua hàng</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listHD}" var="hd">
            <tr>
<%--                <td>${hd.maHoaDon}</td>--%>
                <td>${hd.idNv}</td>
                <td>${hd.idKh}</td>
                <td>${hd.ngayMuaHang}</td>
                <td>${hd.trangThai}</td>
                <td><a href="/hoa-don/edit/${hd.id}">update</a></td>
                <td><a href="/hoa-don/delete/${hd.id}">delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>