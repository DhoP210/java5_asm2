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
<a href="/a">list index</a>
<br>
<a href="/hoa-don/create">Thêm mới</a>
<br>
<form method="GET" action="/hoa-don/index">
    <div>
        <label>Tìm theo tên</label>
        <input type="text" name="keyword" />
    </div>
    <div>
        <button>Tìm kiếm</button>
    </div>
</form>
<br>
<table border="1">
    <thead>
        <tr>
            <th>ID hóa đơn</th>
            <th>Tên nhân viên</th>
            <th>Tên khách hàng</th>
            <th>Ngày mua hàng</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${pageHD.content}" var="hd">
            <tr>
                <td>${hd.id}</td>
                <td>${hd.tenKH}</td>
                <td>${hd.tenNV}</td>
                <td>${hd.ngayMua}</td>
                <td>${hd.trangThai}</td>
                <td><a href="/hoa-don/edit/${hd.id}">update</a></td>
                <td><a href="/hoa-don/delete/${hd.id}">delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<nav><ul>
    <c:forEach begin="0" end="${pageHD.totalPages-1}" var="page">
        <a href="/hoa-don/index?page=${page}&keyword=${param.keyword}">${page+1}</a>
    </c:forEach>
</ul></nav>
</body>
</html>